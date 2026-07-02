package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
    @FindBy(css = ".product-info")
    private WebElement productInfoSection;

    public ProductInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductInfoVisible() {
        return productInfoSection.isDisplayed();
    }
}
