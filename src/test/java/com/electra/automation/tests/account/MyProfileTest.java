package com.electra.automation.tests.account;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.account.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfileTest extends BaseClass {

    @Test
    public void verifyProfilePageLoads() {
        MyProfilePage profilePage = new MyProfilePage(getDriver());
        Assert.assertTrue(profilePage.isProfileVisible(), "Profile section is not visible");
    }
}
