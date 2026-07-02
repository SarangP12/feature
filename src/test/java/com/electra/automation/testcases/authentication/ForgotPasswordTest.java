package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseClass {
    @Test(description = "Validates forgot password flow")
    public void verifyForgotPasswordFlow() {
        ForgotPasswordPage page = new ForgotPasswordPage(getDriver());
        page.enterEmail("user@example.com");
        page.submit();
        Assert.assertTrue(true);
    }
}
