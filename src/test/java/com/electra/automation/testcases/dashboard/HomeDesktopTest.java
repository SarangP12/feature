package com.electra.automation.testcases.dashboard;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.product.DesktopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeDesktopTest extends BaseClass {
    @Test(description = "Validates desktop page")
    public void verifyDesktopPage() {
        DesktopPage page = new DesktopPage(getDriver());
        Assert.assertTrue(page.isDesktopVisible(), "Desktop section should be visible");
    }
}
