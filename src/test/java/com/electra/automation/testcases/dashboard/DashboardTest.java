package com.electra.automation.testcases.dashboard;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.dashboard.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseClass {
    @Test(description = "Validates dashboard page")
    public void verifyDashboard() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be visible");
    }
}
