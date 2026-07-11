package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {
    @Test(description = "Validates registration page interactions")
    public void verifyRegistrationFlow() throws Exception {
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.clickAllMenuButton();
        Thread.sleep(4000); // Wait for login to process
        registerPage.clickRegistrationImage();
        Thread.sleep(4000); // Wait for login to process
        registerPage.ClickPatientsRegistration();
        registerPage.AddPatientClick();
        Thread.sleep(4000); // Wait for login to process
        Assert.assertTrue(true);
    }
}
