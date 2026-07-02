package com.electra.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(css = ".my-account")
    private WebElement accountSection;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return accountSection.isDisplayed();
    }
}
