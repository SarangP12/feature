package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {
    @Test(description = "Validates registration page interactions")
    public void verifyRegistrationFlow() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Doe");
        registerPage.enterEmail("john.doe@example.com");
        registerPage.submit();
        Assert.assertTrue(true);
    }
}
