package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage {
    public AppointmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
