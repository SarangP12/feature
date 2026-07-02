package com.electra.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
    @FindBy(css = ".profile")
    private WebElement profileSection;

    public MyProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProfileVisible() {
        return profileSection.isDisplayed();
    }
}
