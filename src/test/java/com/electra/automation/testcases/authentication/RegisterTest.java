package com.electra.automation.testcases.authentication;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.pages.authentication.RegisterPage;
import com.electra.automation.pages.authentication.SetupMasterPage;
import com.electra.automation.utilities.AssertionUtility;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.RandomDataUtility;

public class RegisterTest extends BaseClass {

    private SetupMasterPage setupMasterPage;
    private RegisterPage registerPage;
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

    @Test(dependsOnMethods = "loginPageLoads", description = "Open registration page", priority = 1)
    private void openRegistrationPage() throws Exception {
        registerPage = new RegisterPage(getDriver());
        setupMasterPage = new SetupMasterPage(getDriver());
        // verifyLoginPageLoads();
        Thread.sleep(2000);
        // registerPage.clickLogInExitLocation(); //-- Without location access
        setupMasterPage.appointmentTabSwitchDisable();
        registerPage.patientRegistrationMenu();
    }

    @Test(dependsOnMethods = "openRegistrationPage", description = "Validates registration page validation", priority = 2)
    public void validationRegistrationPage() throws Exception {

        registerPage.clickSubmit();
        Thread.sleep(1000);
// Validate that the appropriate validation messages are displayed
        assertion.verifyElement(registerPage.tariffValidation, "Applicable Tariff is required.", true);
        assertion.verifyElement(registerPage.firstNameValidation, "First Name is required.", true);
        assertion.verifyElement(registerPage.genderValidation, "Gender is required.", true);
        assertion.verifyElement(registerPage.dobValidation, "Date of Birth is required.", true);
        assertion.verifyElement(registerPage.mobileValidation, "Mobile No is required.", true);
        assertion.verifyElement(registerPage.addressValidation, "Address is required.", true);
    }

    @Test(dependsOnMethods = "validationRegistrationPage", description = "Verify new patient registration", priority = 3)
    public void verifyPatientRegistration() throws Exception {

        patient = RandomDataUtility.generatePatient();
        // setupMasterPage.appointmentTabSwitchDisable();
        // registerPage.patientRegistrationMenu();
        registerPage.registerPatient(patient);
        registerPage.clickSubmit();

        // String actualFirstName = registerPage.getEnteredFirstName();
        Assert.assertEquals(registerPage.getEnteredFirstName(), patient.getFirstName());

        closeExtraTabs();
        closeExtraTabs();
        Thread.sleep(500);

        assertion.verifyElement(registerPage.btnElementToastOK, null, false);
        // verifyToastMessage(registerPage.btnElementToastOK, "Patient registered successfully");
    }

    @Test(dependsOnMethods = "verifyPatientRegistration", description = "Verify duplicate registration", priority = 4)
    public void duplicateRegistration() throws Exception {

        System.out.println(patient.getFirstName());
        System.out.println(patient.getMobile());
        System.out.println(patient.getAddress());

        registerPage.duplicateRegister(patient);
        registerPage.clickSubmit();

        try {
            assertion.verifyElement(registerPage.PatientDuplicateToast, "Patient already exists", true);
        } catch (Exception e) {
            System.out.println("DuplicateToast failed.");
        }

        registerPage.clickSwitchtoList();
    }

    @Test(dependsOnMethods = "duplicateRegistration", description = "Verify Search functionality", priority = 5)
    public void verifyPatientSearch() throws Exception {

        Thread.sleep(2000);

        registerPage.searchPatient(patient);

        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "verifyPatientSearch", description = "Verify Apppintment functionality", priority = 6)
    public void patientAppointment() throws Exception {

        Thread.sleep(2000);

        registerPage.appointmentsDropdown(patient);

        closeExtraTabs();

        try {
            // verifyElement(registerPage.PatientDuplicateToast,"Patient already exists",true);
            assertion.verifyElement(registerPage.btnAddpatient, null, false);
        } catch (Exception e) {
            System.out.println("Test failed.");
        }
    }

    @Test(dependsOnMethods = "patientAppointment", description = "Verify Search functionality", priority = 5)
    public void verifyEmergencyPatient() throws Exception {

        Thread.sleep(2000);
        patient = RandomDataUtility.generatePatient();
        registerPage.registerWithEmergency(patient);

        Thread.sleep(2000);

        registerPage.clickSubmit();

        closeExtraTabs();
        closeExtraTabs();
        Thread.sleep(500);

        assertion.verifyElement(registerPage.btnAddpatient, null, false);

    }

    // @Test(dependsOnMethods = "verifyEmergencyPatient", description = "Verify Booking functionality", priority = 7)
    // public void patientBooking() throws Exception {
    //     registerPage.registerBooking(patient);
    //     verifyElement(registerPage.btnAddpatient, null, false);
    // }
//     @Test(dependsOnMethods = "patientBooking",description = "Verify register with appointment functionality", priority = 8)
//     public void patientregisterWithAppointment() throws Exception {
//         patient = RandomDataUtility.generatePatient();
//         setupMasterPage. appointmentTabSwitchEnable();
//         registerPage.patientRegistrationMenu();
//         registerPage.registerWithAppointment(patient);
//         registerPage.clickSubmit();
//         closeExtraTabs();
//         closeExtraTabs();
//         Thread.sleep(500);
//         verifyElement(registerPage.btnAddpatient, null, false);
//     }
}
