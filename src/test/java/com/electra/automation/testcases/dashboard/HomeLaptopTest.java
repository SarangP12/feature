package com.electra.automation.testcases.dashboard;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.product.LaptopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeLaptopTest extends BaseClass {
    @Test(description = "Validates laptop page")
    public void verifyLaptopPage() {
        LaptopPage page = new LaptopPage(getDriver());
        Assert.assertTrue(page.isLaptopVisible(), "Laptop section should be visible");
    }
}
