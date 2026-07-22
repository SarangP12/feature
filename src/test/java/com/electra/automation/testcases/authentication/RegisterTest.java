package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.pages.authentication.RegisterPage;
import com.electra.automation.utilities.ConfigReader;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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
    verifyValidationMessage(registerPage.tariffValidation, "Applicable Tariff is required.");
    verifyValidationMessage(registerPage.firstNameValidation, "First Name is required.");
    verifyValidationMessage(registerPage.genderValidation, "Gender is required.");
    verifyValidationMessage(registerPage.dobValidation, "Date of Birth is required.");
    verifyValidationMessage(registerPage.mobileValidation, "Mobile No is required.");
    verifyValidationMessage(registerPage.addressValidation, "Address is required.");
    }

//     // Registration Scenarios
    @Test(description = "registration page valid data",priority = 2)   // Registration flow
    public void verifyNewPatientRegistration() throws Exception {
        openRegistrationPage();
        // Thread.sleep(25000);
        // registerPage.selectPatientCategoryType("Staff");
        // // Thread.sleep(2000);
        // registerPage.selectPatientCategoryID("Staff Benefit");
        // registerPage.selectPatientTariff("Staff Patient");
        registerPage.selectPatientSalutation("Mr.");
        registerPage.patientFirstName("John");
        registerPage.patientLastName("Welle");
        registerPage.patientBirthYear("51");
        registerPage.patientmobile("0334587890");
        registerPage.patientAdress("123 Main St, Pune");
        // registerPage.selectPatientCity("Pune");
    //     try {
    //     registerPage.selectPatientCity("Pune");
    // } catch (Exception e) {
    // System.out.println("City dropdown failed.");
    // }       
        // try {
        registerPage.selectAppointmentDepartment("General Medicine");
    // } catch (Exception e) {
    // System.out.println("Department dropdown failed.");
    // }
//         // registerPage.selectAppointmentDepartment("General Medicine");
//         try {
//         registerPage.selectAppointmentUnit("General Medicine - Unit A");
//     } catch (Exception e) {
//     System.out.println("Unit dropdown failed.");
//     }
//         // registerPage.selectAppointmentUnit("General Medicine - Unit A");
//         try {
//         registerPage.selectAppointmentDoctor("Dr. Hayden Beahan");
//     } catch (Exception e) {
//     System.out.println("Doctor dropdown failed.");
//     }
//         // registerPage.selectAppointmentDoctor("Dr. Hayden Beahan");
// //Other details Page
//         registerPage.clickOtherDetails();
//         registerPage.selectRegLanguage("Hindi");
//         registerPage.selectPatientNationality("Indian");
//         registerPage.selectPatientReligion("Hindu");
//         registerPage.clickSameAsCurrentAddress(); 

//         // registerPage.clickSubmit();

        Thread.sleep(3000); // Wait for login to process
    }

//     // @Test(priority = 2)
//     // public void verifyMandatoryFieldValidation() {
//     //     // Validate mandatory fields
//     // }

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
