package com.electra.automation.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
// import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownUtility {

    private final WebDriver driver;
    private final WaitUtility waitUtility;

public DropDownUtility(WebDriver driver) {
    this.driver = driver;
    this.waitUtility = new WaitUtility(driver);
}

    public static void selectByVisibleText(WebElement element, String text) {
        new org.openqa.selenium.support.ui.Select(element).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        new org.openqa.selenium.support.ui.Select(element).selectByValue(value);
    }
    public static void selectByIndex(WebElement element, int index) {
        new org.openqa.selenium.support.ui.Select(element).selectByIndex(index);
    }
    
// public static void selectReactOption(WebDriver driver, WebElement dropdown, String optionText) {

//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

//     // STEP 1 : Wait & Click Dropdown
//     WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
//     clickable.click();

//     // STEP 2 : Find Search Input
//     WebElement input = clickable;

//     if (!"input".equalsIgnoreCase(clickable.getTagName())) {
//         try {
//             input = clickable.findElement(By.cssSelector("input,[role='combobox']"));
//         } catch (NoSuchElementException e) {
//             input = clickable;
//         }
//     }
//     final WebElement finalInput = input;

//     // STEP 3 : Wait until dropdown opens
//     wait.until(driver1 ->
//             "true".equals(finalInput.getAttribute("aria-expanded")));

//     // STEP 4 : Wait until API loads options
//     String listBoxId = finalInput.getAttribute("aria-controls");

//     By allOptions = By.xpath(
//             "//*[@id='" + listBoxId + "']//*[contains(@id,'-option-')]");

//     wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(allOptions, 0));

//     // STEP 5 : Clear existing text
//     input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//     input.sendKeys(Keys.DELETE);

//     // STEP 6 : Type Search Text
//     input.sendKeys(optionText);

//     // STEP 7 : Wait for searched option
//     By option = By.xpath(
//             "//*[@id='" + listBoxId + "']//*[contains(@id,'-option-')][contains(normalize-space(),'"
//                     + optionText + "')]");

//     WebElement optionElement =
//             wait.until(ExpectedConditions.elementToBeClickable(option));

//     optionElement.click();
// }
    public void selectReactOption(WebElement dropdown, String optionText) {

        // STEP 1: Wait & click dropdown
        WebElement clickable =
                waitUtility.waitForElementClickable(
                        dropdown, 50);

        clickable.click();

        // STEP 2: Find search input
        WebElement input = clickable;

        if (!"input".equalsIgnoreCase(
                clickable.getTagName())) {

            try {
                input = clickable.findElement(
                        By.cssSelector(
                                "input,[role='combobox']"));

            } catch (NoSuchElementException e) {
                input = clickable;
            }
        }
        final WebElement finalInput = input;

        // STEP 3: Wait until dropdown opens
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(driver1 ->
                        "true".equals(finalInput.getAttribute("aria-expanded")));

        // STEP 4: Get listbox ID
        String listBoxId =
                finalInput.getDomAttribute("aria-controls");

        if (listBoxId == null ||
                listBoxId.isBlank()) {

            throw new IllegalStateException(
                    "React-Select listbox ID not found.");
        }

        // STEP 5: Clear existing text
        input.sendKeys(
                Keys.chord(Keys.CONTROL, "a"));

        input.sendKeys(Keys.DELETE);

        // STEP 6: Type option
        input.sendKeys(optionText);

        // STEP 7: Find option
        By option = By.xpath(
                "//*[@id='" + listBoxId + "']" +
                "//*[contains(@id,'-option-')]" +
                "[contains(normalize-space(),'" +
                optionText + "')]");

        // STEP 8: Wait for option
        WebElement optionElement =
                waitUtility.waitForElementClickable(
                        option, 50);

        // STEP 9: Click option
        optionElement.click();
    }

}
 