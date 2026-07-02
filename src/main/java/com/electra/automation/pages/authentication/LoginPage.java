package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(xpath="//button[text()='Sign In']")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginFormVisible() {
        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }
}
