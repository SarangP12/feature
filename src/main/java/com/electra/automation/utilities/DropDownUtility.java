package com.electra.automation.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
    public static void selectByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }
}
