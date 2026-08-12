package com.electra.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.testng.Assert;

public class AssertionUtility {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public AssertionUtility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================================================
    // 1. Verify Element Displayed
    // =========================================================

    public void verifyElementDisplayed(WebElement element) {

        WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        Assert.assertTrue(
                visibleElement.isDisplayed(),
                "Element is not displayed."
        );
    }

    // =========================================================
    // 2. Verify Element Not Displayed
    // =========================================================

    public void verifyElementNotDisplayed(By locator) {

        boolean notDisplayed = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );

        Assert.assertTrue(
                notDisplayed,
                "Element is still displayed."
        );
    }

    // =========================================================
    // 3. Verify Element + Text
    // =========================================================

    public void verifyElement(
            WebElement element,
            String expectedMessage,
            boolean verifyText) {

        WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        Assert.assertTrue(
                visibleElement.isDisplayed(),
                "Element is not displayed."
        );

        if (verifyText) {

            String actualText = visibleElement.getText().trim();

            Assert.assertEquals(
                    actualText,
                    expectedMessage,
                    "Text verification failed. " +
                    "Expected: [" + expectedMessage + "] " +
                    "but Actual: [" + actualText + "]"
            );
        }
    }

    // =========================================================
    // 4. Verify Contains Text
    // =========================================================

    public void verifyContainsText(
            WebElement element,
            String expectedText) {

        WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        Assert.assertTrue(
                visibleElement.isDisplayed(),
                "Element is not displayed."
        );

        String actualText = visibleElement.getText().trim();

        Assert.assertTrue(
                actualText.contains(expectedText),
                "Text verification failed. " +
                "Expected text to contain: [" + expectedText + "] " +
                "but Actual text was: [" + actualText + "]"
        );
    }

    // =========================================================
    // 5. Verify Input Field Value
    // =========================================================

    public void verifyInputValue(WebElement element, String expectedValue) {

        WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        Assert.assertTrue(
                visibleElement.isDisplayed(),
                "Input element is not displayed."
        );

        String actualValue = visibleElement.getDomProperty("value").trim();

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Input value verification failed. " +
                "Expected: [" + expectedValue + "] " +
                "but Actual: [" + actualValue + "]"
        );
    }

    // =========================================================
    // 6. Verify Amount
    // =========================================================

    public void verifyAmount(
            WebElement amountElement,
            double expectedAmount) {

        WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOf(amountElement)
        );

        Assert.assertTrue(
                visibleElement.isDisplayed(),
                "Amount element is not displayed."
        );

        String actualText = visibleElement
                .getText()
                .trim()
                .replace("₹", "")
                .replace(",", "")
                .trim();

        double actualAmount;

        try {
            actualAmount = Double.parseDouble(actualText);

        } catch (NumberFormatException e) {

            Assert.fail(
                    "Unable to convert amount to number. " +
                    "Actual value: [" + actualText + "]"
            );

            return;
        }

        Assert.assertEquals(
                actualAmount,
                expectedAmount,
                0.01,
                "Amount verification failed. " +
                "Expected: [" + expectedAmount + "] " +
                "but Actual: [" + actualAmount + "]"
        );
    }

    // =========================================================
    // 7. Verify Temporary Toast Message
    // =========================================================

    public void verifyTemporaryToastMessage(
            By toastLocator,
            String expectedMessage,
            int timeoutSeconds) {

        WebDriverWait toastWait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutSeconds)
        );

        WebElement toast = toastWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        toastLocator
                )
        );

        Assert.assertTrue(
                toast.isDisplayed(),
                "Toast message is not displayed."
        );

        String actualMessage = toast.getText().trim();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Toast message verification failed. " +
                "Expected: [" + expectedMessage + "] " +
                "but Actual: [" + actualMessage + "]"
        );
    }

    // =========================================================
    // 8. Verify Toast Disappears
    // =========================================================

    public void verifyToastDisappears(
            By toastLocator,
            int timeoutSeconds) {

        WebDriverWait toastWait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutSeconds)
        );

        boolean disappeared = toastWait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        toastLocator
                )
        );

        Assert.assertTrue(
                disappeared,
                "Toast message did not disappear within "
                + timeoutSeconds + " seconds."
        );
    }

    // =========================================================
    // 9. Verify Success Message / Popup
    // =========================================================

    public void verifySuccessMessage(
            By messageLocator,
            String expectedMessage,
            int timeoutSeconds) {

        WebDriverWait messageWait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutSeconds)
        );

        WebElement message = messageWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        messageLocator
                )
        );

        Assert.assertTrue(
                message.isDisplayed(),
                "Success message is not displayed."
        );

        String actualMessage = message.getText().trim();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Success message verification failed. " +
                "Expected: [" + expectedMessage + "] " +
                "but Actual: [" + actualMessage + "]"
        );
    }

    // =========================================================
    // 10. Verify Button Enabled
    // =========================================================

    public void verifyButtonEnabled(WebElement button) {

        WebElement visibleButton = wait.until(
                ExpectedConditions.visibilityOf(button)
        );

        Assert.assertTrue(
                visibleButton.isEnabled(),
                "Button is not enabled."
        );
    }

    // =========================================================
    // 11. Verify Button Disabled
    // =========================================================

    public void verifyButtonDisabled(WebElement button) {

        WebElement visibleButton = wait.until(
                ExpectedConditions.visibilityOf(button)
        );

        Assert.assertFalse(
                visibleButton.isEnabled(),
                "Button is enabled but expected to be disabled."
        );
    }

    // =========================================================
    // 12. Verify Checkbox Selected
    // =========================================================

    public void verifyCheckboxSelected(WebElement checkbox) {

        Assert.assertTrue(
                checkbox.isSelected(),
                "Checkbox is not selected."
        );
    }

    // =========================================================
    // 13. Verify Checkbox Not Selected
    // =========================================================

    public void verifyCheckboxNotSelected(WebElement checkbox) {

        Assert.assertFalse(
                checkbox.isSelected(),
                "Checkbox is selected but expected to be unselected."
        );
    }

    // =========================================================
    // 14. Verify Attribute Value
    // =========================================================

    public void verifyAttribute(
            WebElement element,
            String attributeName,
            String expectedValue) {

        WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        String actualValue = visibleElement
                .getDomAttribute(attributeName);

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Attribute verification failed. " +
                "Attribute: [" + attributeName + "] " +
                "Expected: [" + expectedValue + "] " +
                "but Actual: [" + actualValue + "]"
        );

    }

}
