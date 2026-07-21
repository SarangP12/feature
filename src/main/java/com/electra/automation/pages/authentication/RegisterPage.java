package com.electra.automation.pages.authentication;

import com.electra.automation.base.BaseClass;
import com.electra.automation.utilities.DropDownUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage extends BaseClass {

    private WebDriver driver;
//Page Factory constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private WebDriverWait waitForDriver() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickElement(WebElement element) {
        try {
            waitForDriver().until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (RuntimeException ex) {
            waitForDriver().until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private WebElement waitForVisibleElement(WebElement element) {
        return waitForDriver().until(ExpectedConditions.visibilityOf(element));
    }
// Click Action Elements
    @FindBy(xpath="//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement btnAllMenuElement;

    @FindBy(xpath = "//img[@alt=\"Registrations\"]")
    private WebElement btnRegImgAll;

    @FindBy(xpath="//span[text()=\"Patients\"]")
    private WebElement btnClickPatients;

//Validation massage
    @FindBy (xpath="//p[text()=\"First Name is required.\"]")
    public WebElement firstNameValidation;

    @FindBy (xpath="//p[text()=\"Gender is required.\"]")
    public WebElement genderValidation;

    @FindBy(xpath= "//p[text()=\"Date of Birth is required.\"]")
    public WebElement dobValidation;

    @FindBy (xpath= "//p[text()=\"Mobile No is required.\"]")
    public WebElement mobileValidation;

    @FindBy(xpath="//p[text()=\"Address is required.\"]")
    public WebElement addressValidation;

    @FindBy(xpath="//p[text()=\"Applicable Tariff is required.\"]")
    public WebElement tariffValidation;

// All Action Btton 
    @FindBy(xpath="//*[@title=\"Switch to Add\"]")
    private WebElement btnAddpatient;

    @FindBy(xpath="//button[@type=\"submit\"]")
    public WebElement btnSubmit;


// All Text fields 
    @FindBy(xpath="//input[@id=\"patient_category_type\"]")
    public WebElement patientCatTypeDropdown;
    
    @FindBy(xpath="(//input[@id='patient_category_id'])[1]")
    public WebElement patientCatIdDropdown;
    
    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[1]")
    public WebElement patientTariffDropdown;

    @FindBy(xpath="//input[@id=\"salutation\"]")
    public WebElement patientsalutationDropdown;

    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[2]")
    public WebElement patientCityInput;

    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[3]")   //Appointment Doctor Dropdown
    public WebElement ptAppointmentDoctorInput;

    @FindBy(xpath="//input[@id=\"first_name\"]")
    public WebElement firstNameInput;

    @FindBy(xpath="//input[@id=\"last_name\"]")
    public WebElement lastNameInput;

    @FindBy(xpath="//input[@placeholder=\"Y\"]")
    public WebElement patientBirthYearinput;

    @FindBy(xpath="//input[@type=\"tel\"]")
    public WebElement patientMobileinput;

    @FindBy(xpath="//input[@id=\"current_address\"]")
    public WebElement patient_addressinput;

    @FindBy(xpath="//input[@id=\"department_id\"]")
    public WebElement patientDepartmentinput;

    @FindBy(xpath="//input[@id=\"unit_id\"]")
    public WebElement patientUnitinput;

    @FindBy(xpath="//button[@class='shrink-0 p-1 rounded-full transition-colors hover:bg-gray-100 dark:hover:bg-gray-800 text-gray-500']//*[name()='svg']")
    public WebElement logInExitLocation;

//Given is Webelement Access Methods
// Dropdown Selection Methods
    public void selectPatientCategoryType(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientCatTypeDropdown, category);
}
    public void selectPatientCategoryID(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientCatIdDropdown, category);
}
    public void selectPatientTariff(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientTariffDropdown, category);
}
    public void selectPatientSalutation(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientsalutationDropdown, category);
}
    public void selectPatientCity(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientCityInput, category);
}
    public void selectAppointmentDoctor(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, ptAppointmentDoctorInput, category);
}
    public void selectAppointmentDepartment(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientDepartmentinput, category);
}
    public void selectAppointmentUnit(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientUnitinput, category);
}
    public void clickLogInExitLocation() {
        clickElement(logInExitLocation);
    }
    public void clickAllMenuButton() {
        clickElement(btnAllMenuElement);
        // btnAllMenuElement.click();
    }
    public void clickRegistrationImagebtn() {
        clickElement(btnRegImgAll);
    }
    public void ClickPatientsRegistration() {
        clickElement(btnClickPatients);
        // btnClickPatients.click();
    }
    public void AddPatientClick() {
        clickElement(btnAddpatient);
        // btnAddpatient.click();
    }
    public void clickSubmit() {
       clickElement(btnSubmit);
        // btnSubmit.click();
    }
    // public void patienttype(){
    //     clickElement(patientCatDropdown);
    //     // patientCatDropdown.click();
    //     patientCatDropdown.sendKeys("Staff");
    // }
    //  public void patientID(){
    //     clickElement(patientCatIdDropdown);
    //     patientCatIdDropdown.sendKeys("Staff Benefit");
    // }
    // public void patienttariff(){
    //     clickElement(patientTariffDropdown);
    //     patientTariffDropdown.sendKeys("Staff Patient (Staff Patient)");
    // }
    // public void sendSolutation(){
    //     clickElement(patientsalutationDropdown);
    //     patientsalutationDropdown.sendKeys("Mr.");
    // }
        public void patientFirstName(String Fname){
        waitForVisibleElement(firstNameInput).clear();
        firstNameInput.sendKeys(Fname);
    }
        public void patientLastName(String Lname){
        waitForVisibleElement(lastNameInput).clear();
        lastNameInput.sendKeys(Lname);
    }
        public void patientBirthYear(String year){
        waitForVisibleElement(patientBirthYearinput).clear();
        patientBirthYearinput.sendKeys(year);
    }
        public void patientmobile(String mobile){
        waitForVisibleElement(patientMobileinput).clear();
        patientMobileinput.sendKeys(mobile);
    }
        public void patientAdress(String adress){
        waitForVisibleElement(patient_addressinput).clear();
        patient_addressinput.sendKeys(adress);
    }
    //     public void patientCity(String city){
    //     waitForVisibleElement(patientCityInput).clear();
    //     patientCityInput.sendKeys(city);
    // }
    //     public void patienDepartment(String department){
    //     waitForVisibleElement(patientDepartmentinput).clear();
    //     patientDepartmentinput.sendKeys(department);
    // }
    //     public void clickpatienttype(String year){
    //     patientBirthYear.sendKeys(year);
    // }
    //         public void clickpatienttype(String year){
    //     patientBirthYear.sendKeys(year);
    // }
    //     public void clickpatienttype(String year){
    //     patientBirthYear.sendKeys(year);
    // }



}
