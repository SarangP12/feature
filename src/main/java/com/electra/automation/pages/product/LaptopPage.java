package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage {
    @FindBy(css = ".laptop")
    private WebElement laptopSection;

    public LaptopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLaptopVisible() {
        return laptopSection.isDisplayed();
    }
}
