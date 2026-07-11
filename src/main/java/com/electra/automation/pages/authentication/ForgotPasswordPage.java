package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    @FindBy(xpath = "//input[@Class=\"w-full pl-9 pr-20 py-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-indigo-400 text-black bg-white auth-input\"]")
    private WebElement emailInput;
    
     @FindBy(className = "text-xs text-blue-800 font-normal")
    private WebElement ForgotPassword;

    @FindBy(xpath= "//button[text()=\"Send OTP\"]")
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
        public void ForgetPassClick() {
        ForgotPassword.click();
    }
}
