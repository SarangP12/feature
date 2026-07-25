package com.electra.automation.pages.authentication;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.utilities.DropDownUtility;
import java.time.Duration;

public class SearchPage  extends BaseClass  {

//         private WebDriver driver;

//     public SearchPage(WebDriver driver) {
//         this.driver = driver;
//         PageFactory.initElements(driver, this);
//     }
//         private WebDriverWait waitForDriver() {
//         return new WebDriverWait(driver, Duration.ofSeconds(10));
//     }

//     private void clickElement(WebElement element) {
//         try {
//             waitForDriver().until(ExpectedConditions.elementToBeClickable(element)).click();
//         } catch (RuntimeException ex) {
//             waitForDriver().until(ExpectedConditions.visibilityOf(element));
//             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//         }
//     }
//         private WebElement waitForVisibleElement(WebElement element) {
//         return waitForDriver().until(ExpectedConditions.visibilityOf(element));
//     }

//     // @FindBy(xpath="//input[@placeholder='Patient Name']")
//     // public WebElement txtPatientName;

//     // @FindBy(xpath="//input[@placeholder='Mobile Number']")
//     // public WebElement txtMobile;

//     @FindBy(xpath="//input[@placeholder='Search by patient name, UHID, mobile no...']")
//     public WebElement searchInput;

//     @FindBy(xpath="//button[@title='Search']//div[@class='flex items-center justify-center w-6 h-6']//*[name()='svg']")
//     private WebElement btnSearch;


//     // public void search(String value) {
//     //     btnSearch.click();
//     //     searchInput.click();
//     //     searchInput.clear();
//     //     searchInput.sendKeys(value);
//     // }
//         public void clickSearch() {

//        clickElement(btnSearch);
//     }

//         public void patientEmail(String email){
//         waitForVisibleElement(searchInput).clear();
//         searchInput.sendKeys(email);
//     }
//         public void patientFirstName(String Fname){
//         waitForVisibleElement(searchInput).clear();
//         searchInput.sendKeys(Fname);
//     }
//         public void patientLastName(String Lname){
//         waitForVisibleElement(searchInput).clear();
//         searchInput.sendKeys(Lname);
//     }
//         public void patientBirthYear(String year){
//         waitForVisibleElement(searchInput).clear();
//         searchInput.sendKeys(year);
//     }
//         public void patientmobile(String mobile){
//         waitForVisibleElement(searchInput).clear();
//         searchInput.sendKeys(mobile);
//     }

//     public void searchPatient(PatientData patient) throws Exception {

//     patientFirstName(patient.getFirstName());

//     // Assert.assertEquals(searchPage.getFirstName(), patient.getFirstName(),
//     //     "Patient First Name does not match.");

//     // patientLastName(patient.getLastName());

//     // patientBirthYear(patient.getBirthYear());

//     // patientmobile(patient.getMobile());

//     // patientEmail(patient.getEmail());

//     clickSearch();
// }
}
