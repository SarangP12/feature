package com.electra.automation.pages.authentication;

import com.electra.automation.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {

    private WebDriver driver;
//Page Factory constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void clickElement(WebElement element) {
        click(element);
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
    public WebElement patientCatDropdown;
    
    @FindBy(xpath="//input[@id=\"patient_category_id\"]")
    public WebElement patientCatIdDropdown;
    
    @FindBy(xpath="//input[@id=\"react-select-67-input\"]")
    public WebElement patientTariffDropdown;

    @FindBy(xpath="//input[@id=\"salutation\"]")
    public WebElement patientsalutationDropdown;

    @FindBy(xpath="//input[@id=\"first_name\"]")
    public WebElement firstNameInput;

    @FindBy(xpath="//input[@id=\"last_name\"]")
    public WebElement lastNameInput;

    @FindBy(xpath="//input[@placeholder=\"Y\"]")
    public WebElement patientBirthYearinput;

    @FindBy(xpath="//input[@type=\"tel\"]")
    public WebElement patientMobileinput;

    @FindBy(xpath="//input[id=\"current_address\"]")
    public WebElement patient_addressinput;

    @FindBy(id="current_city_id")
    public WebElement patientCityInput;

    @FindBy(xpath="//input[@id=\"department_id\"]")
    public WebElement patientDepartmentinput;

    // @FindBy(xpath="//input[@placeholder=\"Y\"]")
    // public WebElement patientBirthYear;

//Given Webelement Access Methods
    public void clickAllMenuButton() {
        click(btnAllMenuElement);
        // btnAllMenuElement.click();
    }
    public void clickRegistrationImagebtn() {
        click(btnRegImgAll);
    }
    public void ClickPatientsRegistration() {
        click(btnClickPatients);
        // btnClickPatients.click();
    }
    public void AddPatientClick() {
        click(btnAddpatient);
        // btnAddpatient.click();
    }
    public void clickSubmit() {
       click(btnSubmit);
        // btnSubmit.click();
    }
    public void patienttype(){
        click(patientCatDropdown);
        // patientCatDropdown.click();
        patientCatDropdown.sendKeys("Staff");
    }
     public void patientID(){
        click(patientCatIdDropdown);
        patientCatIdDropdown.sendKeys("Staff Benefit");
    }
    public void patienttariff(){
        click(patientTariffDropdown);
        patientTariffDropdown.sendKeys("Staff Patient (Staff Patient)");
    }
    public void sendSolutation(){
        click(patientsalutationDropdown);
        patientsalutationDropdown.sendKeys("Mr.");
    }
        public void patientFirstName(String Fname){
        waitForVisibility(firstNameInput).clear();
        firstNameInput.sendKeys(Fname);
    }
        public void patientLastName(String Lname){
        waitForVisibility(lastNameInput).clear();
        lastNameInput.sendKeys(Lname);
    }
        public void patientBirthYear(String year){
        waitForVisibility(patientBirthYearinput).clear();
        patientBirthYearinput.sendKeys(year);
    }
        public void patientmobile(String mobile){
        waitForVisibility(patientMobileinput).clear();
        patientMobileinput.sendKeys(mobile);
    }
        public void patientAdress(String adress){
        waitForVisibility(patient_addressinput).clear();
        patient_addressinput.sendKeys(adress);
    }
        public void patientCity(String city){
        waitForVisibility(patientCityInput).clear();
        patientCityInput.sendKeys(city);
    }
        public void patienDepartment(String department){
        waitForVisibility(patientDepartmentinput).clear();
        patientDepartmentinput.sendKeys(department);
    }
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
