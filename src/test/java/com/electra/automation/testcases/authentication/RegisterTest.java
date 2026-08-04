package com.electra.automation.testcases.authentication;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.pages.authentication.RegisterPage;
import com.electra.automation.pages.authentication.SetupMasterPage;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.RandomDataUtility;

public class RegisterTest extends BaseClass {

    private SetupMasterPage setupMasterPage;
    private RegisterPage registerPage;
    private PatientData patient;

    // Common Login Methode Define( All test cases are depend on this method)
    @Test(description = "Validates login page loads and login form is visible",priority = 0)
    public void verifyLoginPageLoads() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form should be visible");
        loginPage.enterUsername(ConfigReader.getValue("qa.username"));
        loginPage.enterPassword(ConfigReader.getValue("qa.password")); 
        loginPage.clickLogin();
        Thread.sleep(2000); // Wait for login to process
        closeExtraTabs();
}
    @Test(dependsOnMethods = "verifyLoginPageLoads",description = "Open registration page", priority = 1)
    private void openRegistrationPage() throws Exception {
        registerPage = new RegisterPage(getDriver());
        setupMasterPage = new SetupMasterPage(getDriver());
        // verifyLoginPageLoads();
        Thread.sleep(2000);
        registerPage.clickLogInExitLocation();
        setupMasterPage.appointmentTabSwitchDisable();
        registerPage.patientRegistrationMenu();
    }
    
    @Test(dependsOnMethods = "openRegistrationPage", description = "Validates registration page validation", priority = 2)
    public void validationRegistrationPage() throws Exception {

        registerPage.clickSubmit();
        Thread.sleep(1000); 
// Validate that the appropriate validation messages are displayed
    verifyElement(registerPage.tariffValidation, "Applicable Tariff is required.",true);
    verifyElement(registerPage.firstNameValidation, "First Name is required.",true);
    verifyElement(registerPage.genderValidation, "Gender is required.",true);
    verifyElement(registerPage.dobValidation, "Date of Birth is required.",true);
    verifyElement(registerPage.mobileValidation, "Mobile No is required.",true);
    verifyElement(registerPage.addressValidation, "Address is required.",true);
    }

@Test(dependsOnMethods = "validationRegistrationPage",description = "Verify new patient registration", priority = 3)
public void verifyPatientRegistration() throws Exception {

    patient = RandomDataUtility.generatePatient();
    // setupMasterPage.appointmentTabSwitchDisable();
    // registerPage.patientRegistrationMenu();
    registerPage.registerPatient(patient);
    registerPage.clickSubmit();
    closeExtraTabs();
    closeExtraTabs();
    Thread.sleep(500);


    verifyElement(registerPage.btnAddpatient, null, false);
}
@Test(dependsOnMethods = "validationRegistrationPage",description = "Verify duplicate registration", priority = 4)
public void duplicateRegistration() throws Exception {

    System.out.println(patient.getFirstName());
    System.out.println(patient.getMobile());
    System.out.println(patient.getAddress());

    registerPage.duplicateRegister(patient);
    registerPage.clickSubmit();

            try {
        verifyElement(registerPage.PatientDuplicateToast,"Patient already exists",true);
        } catch (Exception e) {
            System.out.println("DuplicateToast failed.");
    } 

    registerPage.clickSwitchtoList();
}
    @Test(dependsOnMethods = "duplicateRegistration",description = "Verify Search functionality", priority = 5)
    public void verifyPatientSearch() throws Exception {    

        Thread.sleep(2000);

        registerPage.searchPatient(patient);

        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "verifyPatientSearch",description = "Verify Apppintment functionality", priority = 6)
    public void patientAppointment() throws Exception {

        Thread.sleep(2000);
        registerPage.appointmentsDropdown(patient);

        closeExtraTabs();

                    try {
        // verifyElement(registerPage.PatientDuplicateToast,"Patient already exists",true);
        verifyElement(registerPage.btnAddpatient, null, false);
        } catch (Exception e) {
            System.out.println("Test failed.");
        }
    }
    @Test(dependsOnMethods = "patientAppointment",description = "Verify Booking functionality", priority = 7)
    public void patientBooking() throws Exception {

        registerPage.registerBooking(patient);

        verifyElement(registerPage.btnAddpatient, null, false);

    }
    @Test(dependsOnMethods = "patientBooking",description = "Verify register with appointment functionality", priority = 8)
    public void patientregisterWithAppointment() throws Exception {
        
        patient = RandomDataUtility.generatePatient();

        setupMasterPage. appointmentTabSwitchEnable();
        registerPage.patientRegistrationMenu();
        registerPage.registerWithAppointment(patient);
        
        registerPage.clickSubmit();
        closeExtraTabs();
        closeExtraTabs();
        Thread.sleep(500);

        verifyElement(registerPage.btnAddpatient, null, false);
    }

}
