package com.electra.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownUtility {

    public static void selectByVisibleText(WebElement element, String text) {
        new org.openqa.selenium.support.ui.Select(element).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        new org.openqa.selenium.support.ui.Select(element).selectByValue(value);
    }
// // dropdown utility for react select component 
//     public static void selectReactOption(WebDriver driver, WebElement dropdown, String optionText) throws Exception {

//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

//     WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
//     clickable.click();

//     WebElement input = clickable;

//     if (!"input".equalsIgnoreCase(clickable.getTagName())) {
//         try {
//             input = clickable.findElement(By.cssSelector("input, [role='combobox']"));
//         } catch (NoSuchElementException e) {
//             input = clickable;
//         }
//     }

//     wait.until(ExpectedConditions.visibilityOf(input));

//     input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//     input.sendKeys(Keys.BACK_SPACE);
//     input.sendKeys(optionText);

//     // Wait until at least one option is displayed;
//     By option = By.xpath("//div[contains(@id,'-option-') and normalize-space()='" + optionText + "']");

//     WebElement optionElement = wait.until(
//             ExpectedConditions.elementToBeClickable(option));
//             optionElement.click();
//     }

public static void selectReactOption(WebDriver driver, WebElement dropdown, String optionText) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    // STEP 1 : Wait & Click Dropdown
    WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    clickable.click();

    // STEP 2 : Find Search Input
    WebElement input = clickable;

    if (!"input".equalsIgnoreCase(clickable.getTagName())) {
        try {
            input = clickable.findElement(By.cssSelector("input,[role='combobox']"));
        } catch (NoSuchElementException e) {
            input = clickable;
        }
    }
    final WebElement finalInput = input;

    // STEP 3 : Wait until dropdown opens
    wait.until(driver1 ->
            "true".equals(finalInput.getAttribute("aria-expanded")));

    // STEP 4 : Wait until API loads options
    String listBoxId = finalInput.getAttribute("aria-controls");

    By allOptions = By.xpath(
            "//*[@id='" + listBoxId + "']//*[contains(@id,'-option-')]");

    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(allOptions, 0));

    // STEP 5 : Clear existing text
    input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    input.sendKeys(Keys.DELETE);

    // STEP 6 : Type Search Text
    input.sendKeys(optionText);

    // STEP 7 : Wait for searched option
    By option = By.xpath(
            "//*[@id='" + listBoxId + "']//*[contains(@id,'-option-')][contains(normalize-space(),'"
                    + optionText + "')]");

    WebElement optionElement =
            wait.until(ExpectedConditions.elementToBeClickable(option));

    optionElement.click();
}

}
 