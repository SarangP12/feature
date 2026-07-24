package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.pages.authentication.RegisterPage;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.RandomDataUtility;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {

    private RegisterPage registerPage;
    private PatientData patient;

    // Common Login Methode Define( All test cases are depend on this method)
    @Test(description = "Validates login page loads and login form is visible")
    public void verifyLoginPageLoads() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form should be visible");
        loginPage.enterUsername(ConfigReader.getValue("qa.username"));
        loginPage.enterPassword(ConfigReader.getValue("qa.password")); 
        loginPage.clickLogin();
        Thread.sleep(2000); // Wait for login to process
        closeExtraTabs();
}
    @Test(description = "Open registration page", priority = 0)
    private void openRegistrationPage() throws Exception {
        registerPage = new RegisterPage(getDriver());
        verifyLoginPageLoads();
        Thread.sleep(2000);
        registerPage.clickLogInExitLocation();
        registerPage.clickAllMenuButton();
        registerPage.clickRegistrationImagebtn();
        registerPage.ClickPatientsRegistration();
        registerPage.AddPatientClick();
    }
    @Test(description = "Validates registration page validation", priority = 1)
    public void validationRegistrationPage() throws Exception {
        openRegistrationPage();
        registerPage.clickSubmit();
        Thread.sleep(4000); // Wait for login to process
// Validate that the appropriate validation messages are displayed
    verifyElement(registerPage.tariffValidation, "Applicable Tariff is required.",true);
    verifyElement(registerPage.firstNameValidation, "First Name is required.",true);
    verifyElement(registerPage.genderValidation, "Gender is required.",true);
    verifyElement(registerPage.dobValidation, "Date of Birth is required.",true);
    verifyElement(registerPage.mobileValidation, "Mobile No is required.",true);
    verifyElement(registerPage.addressValidation, "Address is required.",true);
    }
//     // Regration flow Scenarios
    @Test(description = "Registration valid data without appointment",priority = 2)
    public void verifyNewPatientRegistration() throws Exception {
        openRegistrationPage();
        Thread.sleep(25000);
        registerPage.selectPatientCategoryType("Staff");
        // Thread.sleep(2000);
        registerPage.selectPatientCategoryID("Staff Benefit");
        registerPage.selectPatientTariff("Staff Patient");
        registerPage.selectPatientSalutation("Mrs.");
        registerPage.patientFirstName("Sweety");
        registerPage.patientLastName("Pande");
        registerPage.patientBirthYear("1990");
        registerPage.patientmobile("1934555891");
        registerPage.patientAdress("128 Main St, Roing");
        Thread.sleep(25000);
        try {
        registerPage.selectPatientCity("Roing");
    } catch (Exception e) {
    System.out.println("City dropdown failed.");// registerPage.selectPatientCity("Pune");
    }       
    //     try {
    //     registerPage.selectAppointmentDepartment("General Medicine");
    // } catch (Exception e) {
    // System.out.println("Department dropdown failed."); 
    // }
    //     try {
    //     registerPage.selectAppointmentUnit("General Medicine - Unit A");
    // } catch (Exception e) {
    // System.out.println("Unit dropdown failed."); // registerPage.selectAppointmentUnit("General Medicine - Unit A");
    // }
    //     try {
    //     registerPage.selectAppointmentDoctor("Dr. Hayden Beahan");
    // } catch (Exception e) {
    // System.out.println("Doctor dropdown failed.");// registerPage.selectAppointmentDoctor("Dr. Hayden Beahan");
    // }
//Other details Page
        registerPage.clickOtherDetails();
        registerPage.selectRegLanguage("Hindi");
        registerPage.selectPatientNationality("Indian");
        registerPage.selectPatientReligion("Hindu");
        registerPage.clickSameAsCurrentAddress(); 
        registerPage.clickSubmit();
        Thread.sleep(1000);
        closeExtraTabs();
        Thread.sleep(1000);
        closeExtraTabs();
        verifyElement(registerPage.PatientInfoPage,
                   "Patient Info", true);
        verifyElement(registerPage.btnAddpatient, null, false);
    }

@Test(description = "Verify new patient registration", priority = 3)
public void verifyPatientRegistration() throws Exception {

    patient = RandomDataUtility.generatePatient();

    openRegistrationPage();

    Thread.sleep(25000);

    registerPage.registerPatient(patient);

    verifyElement(registerPage.btnAddpatient, null, false);
}
@Test(dependsOnMethods = "verifyPatientRegistration")
public void duplicateRegistration() throws Exception {

    System.out.println(patient.getFirstName());
    System.out.println(patient.getMobile());

    openRegistrationPage();
    Thread.sleep(25000);
    registerPage.registerPatient(patient);

    verifyElement(registerPage.PatientDuplicateToast,"Patient already exists",true);
}
//     // @Test(priority = 4)
//     // public void verifyPatientSearch() {
//     //     // Search functionality
//     // }

//     // @Test(priority = 5)
//     // public void verifyRegistrationReceipt() {
//     //     // Receipt generation
//     // }
}
