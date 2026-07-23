package com.electra.automation.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

public class DropDownUtility {

    public static void selectByVisibleText(WebElement element, String text) {
        new org.openqa.selenium.support.ui.Select(element).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        new org.openqa.selenium.support.ui.Select(element).selectByValue(value);
    }
// dropdown utility for react select component 
    // public static void selectReactOption(WebDriver driver, WebElement dropdown, String optionText) throws Exception {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    //     WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    //     clickable.click();

    //     WebElement input = clickable;
    //     if (!"input".equalsIgnoreCase(clickable.getTagName())) {
    //         try {
    //             input = clickable.findElement(
    //                     org.openqa.selenium.By.cssSelector("input, [role='combobox']"));
    //         } catch (NoSuchElementException ignored) {
    //             input = clickable;
    //         }
    //     }

    //     wait.until(ExpectedConditions.visibilityOf(input));
    //     input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    //     input.sendKeys(Keys.BACK_SPACE);
    //     input.click();
    //     input.sendKeys(optionText);
    //     Thread.sleep(20000);
    //     input.sendKeys(Keys.ENTER);
    //     // input.sendKeys(Keys.ENTER);
    // }
// dropdown utility for react select component 
    public static void selectReactOption(WebDriver driver, WebElement dropdown, String optionText) throws Exception {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    clickable.click();

    WebElement input = clickable;

    if (!"input".equalsIgnoreCase(clickable.getTagName())) {
        try {
            input = clickable.findElement(By.cssSelector("input, [role='combobox']"));
        } catch (NoSuchElementException e) {
            input = clickable;
        }
    }

    wait.until(ExpectedConditions.visibilityOf(input));

    input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    input.sendKeys(Keys.BACK_SPACE);
    input.sendKeys(optionText);

    // Wait until at least one option is displayed;
    By option = By.xpath("//div[contains(@id,'-option-') and normalize-space()='" + optionText + "']");

    WebElement optionElement = wait.until(
            ExpectedConditions.elementToBeClickable(option));
            optionElement.click();
    }
}
 