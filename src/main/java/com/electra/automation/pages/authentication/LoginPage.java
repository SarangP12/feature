package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.electra.automation.base.BaseClass;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;

public class LoginPage extends BaseClass {


    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);

}

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(xpath="//button[text()='Sign In']")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    // public void enterUsername(String username) {
    //     usernameInput.sendKeys(username);
    // }

    // public void enterPassword(String password) {
    //     passwordInput.sendKeys(password);
    // }

    // public void clickLogin() {
    //     loginButton.click();
    // }


        /**
     * Verify Login Form is displayed
     */
    public boolean isLoginFormVisible() {
        wait.waitForVisibility(usernameInput);
        return usernameInput.isDisplayed()
                && passwordInput.isDisplayed()
                && loginButton.isDisplayed();
    }

    public void enterUsername(String username) {
        wait.waitForVisibility(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.waitForVisibility(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        wait.waitForClickable(loginButton).click();
    }

    public void verifyLoginPageLoads() throws Exception {

        enterUsername(ConfigReader.getValue("qa.username"));
        enterPassword(ConfigReader.getValue("qa.password"));
        clickLogin();

//         LoginPage loginPage = new LoginPage(getDriver());
//         Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form should be visible");
//         loginPage.enterUsername(ConfigReader.getValue("qa.username"));
//         loginPage.enterPassword(ConfigReader.getValue("qa.password")); 
//         loginPage.clickLogin();
//         Thread.sleep(2000); // Wait for login to process
//         closeExtraTabs();
}


    // public boolean isLoginFormVisible() {
    //     return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    // }


}
