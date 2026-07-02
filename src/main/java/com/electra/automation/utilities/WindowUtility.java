package com.electra.automation.utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowUtility {
    private final WebDriver driver;

    public WindowUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }
}
