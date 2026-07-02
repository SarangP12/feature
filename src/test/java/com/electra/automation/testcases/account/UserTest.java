package com.electra.automation.testcases.account;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.account.AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseClass {
    @Test(description = "Validates admin page")
    public void verifyAdminPanel() {
        AdminPage page = new AdminPage(getDriver());
        Assert.assertTrue(page.isAdminPanelVisible(), "Admin panel should be visible");
    }
}
