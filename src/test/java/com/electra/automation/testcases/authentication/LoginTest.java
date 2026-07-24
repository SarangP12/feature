package com.electra.automation.testcases.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.utilities.ConfigReader;

public class LoginTest extends BaseClass {
    @Test(description = "Validates login page loads and login form is visible")
    public void verifyLoginPageLoads() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form should be visible");
        loginPage.enterUsername(ConfigReader.getValue("qa.username"));
        loginPage.enterPassword(ConfigReader.getValue("qa.password")); 
        loginPage.clickLogin();
        Thread.sleep(2000); // Wait for login to process
        closeExtraTabs();
    }
}
