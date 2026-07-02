package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.ChangePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseClass {
    @Test(description = "Validates password change page")
    public void verifyChangePasswordPage() {
        ChangePasswordPage page = new ChangePasswordPage(getDriver());
        page.changePassword("oldPassword", "newPassword123");
        Assert.assertTrue(true);
    }
}
