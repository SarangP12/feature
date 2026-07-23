package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {

    private RegisterPage registerPage;

    @Test(description = "registration page interactions", priority = 0)
    private void openRegistrationPage() throws Exception {
        registerPage = new RegisterPage(getDriver());
        Thread.sleep(2000);
        registerPage.clickLogInExitLocation();
        registerPage.clickAllMenuButton();
        registerPage.clickRegistrationImagebtn();
        registerPage.ClickPatientsRegistration();
        registerPage.AddPatientClick();

    }


    @Test(description = "Validates registration page interactions", priority = 1)
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

//     // Registration flow Scenarios
    @Test(description = "registration page valid data",priority = 2)   // Registration flow
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
        // Thread.sleep(4000); // Wait for login to process
    }

    @Test(priority = 2)
    public void verifyMandatoryFieldValidation() {
        // Validate mandatory fields
    }

//     // @Test(priority = 3)
//     // public void verifyDuplicatePatientRegistration() {
//     //     // Duplicate patient validation
//     // }

//     // @Test(priority = 4)
//     // public void verifyPatientSearch() {
//     //     // Search functionality
//     // }

//     // @Test(priority = 5)
//     // public void verifyRegistrationReceipt() {
//     //     // Receipt generation
//     // }
}
