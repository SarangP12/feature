package com.electra.automation.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        return driver.getCurrentUrl().contains("saucedemo") && driver.getTitle().contains("Swag") || driver.getPageSource().contains("inventory") || driver.getPageSource().contains("products");
    }
}
