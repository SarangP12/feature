package com.electra.automation.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(css = "h1")
    private WebElement pageHeader;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isHeaderDisplayed() {
        return pageHeader.isDisplayed();
    }
}
