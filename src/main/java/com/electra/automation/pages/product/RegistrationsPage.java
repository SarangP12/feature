package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationsPage {
    public RegistrationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
