package com.electra.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    @FindBy(css = ".admin")
    private WebElement adminPanel;

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isAdminPanelVisible() {
        return adminPanel.isDisplayed();
    }
}
