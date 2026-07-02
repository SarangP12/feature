package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public ForgotPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void submit() {
        submitButton.click();
    }
}
