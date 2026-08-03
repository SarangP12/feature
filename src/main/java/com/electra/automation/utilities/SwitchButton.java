package com.electra.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchButton {

    private WebDriver driver;
    private WebDriverWait wait;

    public SwitchButton(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    private By switchInput(String settingName) {

        return By.xpath(
                "//*[contains(text(),'" + settingName + "')]" +
                "//ancestor::div[contains(@class,'space-y-2')]" +
                "//input[@role='switch']");
    }

    private By switchLabel(String settingName) {

        return By.xpath(
                "//*[contains(text(),'" + settingName + "')]" +
                "//ancestor::div[contains(@class,'space-y-2')]" +
                "//label");
    }

    /**
     * Turn ON/OFF any switch
     */
    public void setSwitch(String settingName, boolean expectedState) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        switchInput(settingName)));

        WebElement label = wait.until(
                ExpectedConditions.elementToBeClickable(
                        switchLabel(settingName)));

        boolean currentState = Boolean.parseBoolean(
                input.getAttribute("data-checked"));

        if (currentState != expectedState) {

            label.click();

            wait.until(driver ->
                    Boolean.parseBoolean(
                            input.getAttribute("data-checked"))
                            == expectedState);
        }
    }

    /**
     * Returns current switch status
     */
    public boolean isSwitchEnabled(String settingName) {

        return Boolean.parseBoolean(
                driver.findElement(switchInput(settingName))
                        .getAttribute("data-checked"));
    }

}
