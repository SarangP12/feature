package com.electra.automation.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
    @FindBy(css = "footer")
    private WebElement footerSection;

    public FooterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isFooterVisible() {
        return footerSection.isDisplayed();
    }
}
