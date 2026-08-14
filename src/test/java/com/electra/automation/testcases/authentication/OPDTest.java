package com.electra.automation.testcases.authentication;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.OPD_Data;
import com.electra.automation.models.PatientData;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.pages.authentication.OPDPage;
import com.electra.automation.pages.authentication.SetupMasterPage;
import com.electra.automation.utilities.AssertionUtility;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.RandomDataUtility;

public class OPDTest extends BaseClass {

    private SetupMasterPage setupMasterPage;
    private OPDPage OPDPage;
    private OPD_Data OPDData;
    private PatientData patient;
    private AssertionUtility assertion;

    @BeforeMethod //AssertionUtility initialization before each test method
    public void setUpAssertion() {
        assertion = new AssertionUtility(getDriver());
    }

    // Common Login Methode Define( All test cases are depend on this method)
    @Test(description = "Validates login page loads and login form is visible", priority = 0)
    public void loginPageLoads() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginFormVisible(),
                "Login form should be visible");
        loginPage.verifyLoginPageLoads();
        closeExtraTabs();
    }

    @Test(dependsOnMethods = "loginPageLoads", description = "Open OPD page", priority = 1)
    private void openOPDPage() throws Exception {
        OPDPage = new OPDPage(getDriver());
        setupMasterPage = new SetupMasterPage(getDriver());
        OPDData = RandomDataUtility.generateOPData();

        // verifyLoginPageLoads();
        Thread.sleep(2000);
        // OPDPage.clickLogInExitLocation(); //-- Without location access

        OPDPage.patientEMREHRRecord(OPDData);
    }

}
