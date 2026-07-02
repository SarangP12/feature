package com.electra.automation.testcases.dashboard;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.product.CameraPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeCameraTest extends BaseClass {
    @Test(description = "Validates camera page")
    public void verifyCameraPage() {
        CameraPage page = new CameraPage(getDriver());
        Assert.assertTrue(page.isCameraVisible(), "Camera section should be visible");
    }
}
