package com.electra.automation.utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateUtility {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final WaitUtility waitUtility;

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/uuuu");

    private static final DateTimeFormatter MONTH_FORMAT =
            DateTimeFormatter.ofPattern("MMMM uuuu", Locale.ENGLISH);

    public static String getCurrentDateTime(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static YearMonth parseMonthYearHeader(String header) {
        if (header == null || header.trim().isEmpty()) {
            throw new IllegalArgumentException("Calendar header is blank");
        }

        String normalized = header
                .replace('\r', ' ')
                .replace('\n', ' ')
                .replace('\t', ' ')
                .replaceAll("\\s+", " ")
                .trim();

        DateTimeFormatter[] formats = new DateTimeFormatter[] {
                DateTimeFormatter.ofPattern("MMMM uuuu", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMM uuuu", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH)
        };

        for (DateTimeFormatter format : formats) {
            try {
                return YearMonth.parse(normalized, format);
            } catch (DateTimeParseException ignored) {
                // Try the next supported header format.
            }
        }

        throw new IllegalStateException(
                "Unable to parse calendar heading: '" + header + "'"
        );
    }

    public DateUtility(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectDate(WebElement dateInput, String date) {

        // STEP 1: Parse the date passed from RandomDataUtility
        LocalDate targetDate =
                LocalDate.parse(date, DATE_FORMAT);

        YearMonth targetMonth =
                YearMonth.from(targetDate);

By calendarHeader = By.xpath(
    "//div[contains(@class,'absolute') and .//button[normalize-space()='Today']]//div[contains(@class,'flex') and contains(@class,'justify-between')]"
);

// Month text
By monthText = By.xpath(
    "//div[contains(@class,'absolute') and .//button[normalize-space()='Today']]//span[contains(@class,'cursor-pointer')][1]"
);

// Year text
By yearText = By.xpath(
    "//div[contains(@class,'absolute') and .//button[normalize-space()='Today']]//span[contains(@class,'cursor-pointer')][2]"
);
// Calendar popup container
By calendarPopup = By.xpath(
    "//div[contains(@class,'absolute') and contains(@class,'min-w-[250px]') and .//button[normalize-space()='Today']]"
);

// First navigation button: previous month
By previousMonthButton = By.xpath(
    "//div[contains(@class,'absolute') and .//button[normalize-space()='Today']]//div[contains(@class,'gap-2')]/button[1]"
);

// Second navigation button: right-arrow / next-month candidate
By nextMonthButton = By.xpath(
    "//div[contains(@class,'absolute') and .//button[normalize-space()='Today']]//div[contains(@class,'gap-2')]/button[2]"
        );

        // STEP 3: Open calendar
        waitUtility.waitForElementClickable(
                dateInput, 20).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        calendarHeader));

        // STEP 4: Navigate to target month and year
        boolean monthFound = false;

        for (int i = 0; i < 240; i++) {

            String header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            calendarHeader))
                    .getText().trim();

            YearMonth currentMonth =
                    parseMonthYearHeader(header);

            if (currentMonth.equals(targetMonth)) {
                monthFound = true;
                break;
            }

            if (currentMonth.isBefore(targetMonth)) {
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                nextMonthButton)).click();
            } else {
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                previousMonthButton)).click();
            }

            // Wait until the month heading changes
            wait.until(d -> {
                List<WebElement> headers =
                        d.findElements(calendarHeader);

                return !headers.isEmpty()
                        && !headers.get(0).getText()
                                .trim().equals(header);
            });
        }

        if (!monthFound) {
            throw new IllegalStateException(
                    "Target month not found: " + targetMonth);
        }

        // STEP 5: Locate target day inside calendar popup
        WebElement popup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        calendarPopup));

        String day = String.valueOf(
                targetDate.getDayOfMonth());

        By dayLocator = By.xpath(
                ".//*[normalize-space(text())='"
                + day + "']");

        List<WebElement> dayElements =
                popup.findElements(dayLocator);

        WebElement targetDay = null;

        for (WebElement element : dayElements) {

            if (!element.isDisplayed()
                    || !element.isEnabled()) {
                continue;
            }

            String classes =
                    element.getAttribute("class");

            String ariaDisabled =
                    element.getAttribute("aria-disabled");

            if (classes != null &&
                    (classes.toLowerCase().contains("disabled")
                    || classes.toLowerCase().contains("outside-month")
                    || classes.toLowerCase().contains("other-month"))) {
                continue;
            }

            if ("true".equalsIgnoreCase(ariaDisabled)) {
                continue;
            }

            targetDay = element;
            break;
        }

        if (targetDay == null) {
            throw new IllegalStateException(
                    "Target date not found: " + date);
        }

        // STEP 6: Click the target date
        targetDay.click();

        // STEP 7: Verify the selected date in the input
        wait.until(d ->
                date.equals(
                        d.findElement(
                                By.id(dateInput.getAttribute("id")))
                         .getAttribute("value")));

        System.out.println(
                "Successfully selected date: " + date);
    }
}
