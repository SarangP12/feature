package com.electra.automation.testcases.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.pages.authentication.RegisterPage;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.RandomDataUtility;

public class RegistrationAbha extends BaseClass {

    private RegisterPage registerPage;
    private PatientData patient;

// Common Login Methode Define( All test cases are depend on this method)
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
    @Test(priority = 1)
    public void verifyPatientSearch() {
        // Search functionality
    }

    // @Test(priority = 5)
    // public void verifyRegistrationReceipt() {
    //     // Receipt generation
    // }
}

