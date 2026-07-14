package com.electra.automation.testcases.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.pages.authentication.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {

       private RegisterPage registerPage;

    @BeforeMethod
    public void setupPage() throws Exception{
        registerPage = new RegisterPage(getDriver());
        registerPage.clickAllMenuButton();
        Thread.sleep(5000); // Wait for login to process
        registerPage.clickRegistrationImagebtn();
        Thread.sleep(2000); // Wait for login to process
        registerPage.ClickPatientsRegistration();
    }


    @Test(description = "Validates registration page interactions", priority = 0)
    public void verifyRegistrationFlow() throws Exception {
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
// Registration Scenarios
    @Test(priority = 1)   // Registration flow
    public void verifyNewPatientRegistration() throws Exception {
        registerPage.patienttype();
        registerPage.patientID();
        registerPage.patienttariff();
        registerPage.sendSolutation();
        Thread.sleep(4000); // Wait for login to process
    }

    // @Test(priority = 2)
    // public void verifyMandatoryFieldValidation() {
    //     // Validate mandatory fields
    // }

    // @Test(priority = 3)
    // public void verifyDuplicatePatientRegistration() {
    //     // Duplicate patient validation
    // }

    // @Test(priority = 4)
    // public void verifyPatientSearch() {
    //     // Search functionality
    // }

    // @Test(priority = 5)
    // public void verifyRegistrationReceipt() {
    //     // Receipt generation
    // }

}
