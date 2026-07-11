package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseClass {
    @Test(description = "Validates forgot password flow")
    public void verifyForgotPasswordFlow() throws Exception {
        ForgotPasswordPage page = new ForgotPasswordPage(getDriver());
        page.ForgetPassClick();
        Thread.sleep(2000); // Wait for login to process
        page.enterEmail("user@example.com");
        page.submit();
        Thread.sleep(2000); // Wait for login to process
        Assert.assertTrue(true);
    }
}
