package com.electra.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {
    private final Actions actions;

    public ActionUtility(WebDriver driver) {
        this.actions = new Actions(driver);
    }

    public void click(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void doubleClick(WebElement element) {
        actions.moveToElement(element).doubleClick().perform();
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void sendKeys(WebElement element, String value) {
        actions.moveToElement(element).click().sendKeys(value).perform();
    }
}
