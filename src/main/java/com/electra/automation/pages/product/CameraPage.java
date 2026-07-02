package com.electra.automation.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CameraPage {
    @FindBy(css = ".camera")
    private WebElement cameraSection;

    public CameraPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isCameraVisible() {
        return cameraSection.isDisplayed();
    }
}
