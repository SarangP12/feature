package com.electra.automation.testcases.account;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.account.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseClass {
    @Test(description = "Validates account page")
    public void verifyMyAccountPage() {
        MyAccountPage page = new MyAccountPage(getDriver());
        Assert.assertTrue(page.isDisplayed(), "My account section should be visible");
    }
}
