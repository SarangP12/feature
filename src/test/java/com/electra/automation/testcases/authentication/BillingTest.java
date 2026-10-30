package com.electra.automation.testcases.authentication;

public class BillingTest {


//////////////////////////////////////////////////////////////////////////
/// Register me dala hua tha code ye [check after u get time]
/// /////////////////////////////////////////////////////////////////////


    //     @Test(dependsOnMethods = "verifyEmergencyPatient", description = "Verify register with appointment functionality", priority = 8)
//     public void registerAndVerifyBill() throws Exception {

//         patient = RandomDataUtility.generatePatient();

//         registerPage.registerWithEmergency(patient);

//     // Step 1: Fill Registration form
//     registerPage.registerPatient(patient);

//     // Step 2: Submit Registration
//     registerPage.clickSubmit();

//     // Step 3: Capture generated Patient ID
//     registerPage.wait.waitForElementVisible(generatedPatientId);

//     String patientId = generatedPatientId.getText().trim();

//     Assert.assertFalse(
//             patientId.isBlank(),
//             "Patient ID was not generated!"
//     );

//     // Step 4: Capture Registration bill amount
//     wait.waitForElementVisible(registrationBillAmount);

//     String registrationAmountText =
//             registrationBillAmount.getText().trim();

//     BigDecimal registrationAmount =
//             parseBillAmount(registrationAmountText);

//     // Step 5: Open Billing module
//     clickAllMenuButton();

//     wait.waitForElementClickable(billingModule).click();

//     // Step 6: Search using the same Patient ID
//     wait.waitForElementVisible(billingPatientSearch);

//     billingPatientSearch.clear();
//     billingPatientSearch.sendKeys(patientId);

//     wait.waitForElementClickable(billingSearchButton).click();

//     // Step 7: Wait for the matching bill amount
//     wait.waitForElementVisible(billingAmount);

//     String billingAmountText =
//             billingAmount.getText().trim();

//     BigDecimal actualBillingAmount =
//             parseBillAmount(billingAmountText);

//     // Step 8: Compare both amounts
//     Assert.assertEquals(
//             actualBillingAmount.compareTo(registrationAmount),
//             0,
//             "Bill amount mismatch for Patient ID: " + patientId
//             + ". Registration: " + registrationAmount
//             + ", Billing: " + actualBillingAmount
//     );

//     System.out.println(
//             "PASS: Registration bill verified in Billing module."
//     );

//     System.out.println("Patient ID: " + patientId);
//     System.out.println("Registration Amount: "
//             + registrationAmount);
//     System.out.println("Billing Amount: "
//             + actualBillingAmount);
// }

// private BigDecimal parseBillAmount(String amountText) {

//     String cleanedAmount = amountText
//             .replace("₹", "")
//             .replace("Rs.", "")
//             .replace("Rs", "")
//             .replace(",", "")
//             .trim();

//     return new BigDecimal(cleanedAmount);
// }
}
