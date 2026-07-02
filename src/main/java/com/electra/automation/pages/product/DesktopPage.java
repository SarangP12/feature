package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage {
    @FindBy(css = ".desktop")
    private WebElement desktopSection;

    public DesktopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDesktopVisible() {
        return desktopSection.isDisplayed();
    }
}
