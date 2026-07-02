package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
    @FindBy(id = "currentPassword")
    private WebElement currentPasswordInput;

    @FindBy(id = "newPassword")
    private WebElement newPasswordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    public ChangePasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void changePassword(String currentPassword, String newPassword) {
        currentPasswordInput.sendKeys(currentPassword);
        newPasswordInput.sendKeys(newPassword);
        confirmPasswordInput.sendKeys(newPassword);
    }
}
