package com.electra.automation.utilities;

import org.openqa.selenium.WebDriver;

public class AlertUtility {
    private final WebDriver driver;

    public AlertUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }
}
