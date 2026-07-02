package com.electra.automation.testcases.dashboard;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.dashboard.FooterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseClass {
    @Test(description = "Validates footer visibility")
    public void verifyFooter() {
        FooterPage page = new FooterPage(getDriver());
        Assert.assertTrue(page.isFooterVisible(), "Footer should be visible");
    }
}
