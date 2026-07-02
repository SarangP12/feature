package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ABDMRegPage {
    public ABDMRegPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
