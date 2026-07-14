package com.electra.automation.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

//Page Factory constructor
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    // @FindBy(xpath="//input[@id=\"react-select-67-input\"]")
    // public WebElement patientTariffDropdown;

    // @FindBy(xpath="//input[@id=\"react-select-67-input\"]")
    // public WebElement patientTariffDropdown;

    // @FindBy(xpath="//input[@id=\"react-select-67-input\"]")
    // public WebElement patientTariffDropdown;

//Given Webelement Access Methods
    public void clickAllMenuButton() {
        btnAllMenuElement.click();
    }
    public void clickRegistrationImagebtn() {
        btnRegImgAll.click();
    }
    public void ClickPatientsRegistration() {
        btnClickPatients.click();
    }
    public void AddPatientClick() {
        btnAddpatient.click();
    }
    public void clickSubmit() {
        btnSubmit.click();
    }
    public void patienttype(){
        patientCatDropdown.click();
        patientCatDropdown.sendKeys("Staff");
    }
     public void patientID(){
        patientCatIdDropdown.click();
        patientCatIdDropdown.sendKeys("Staff Benefit");
    }
    public void patienttariff(){
        patientTariffDropdown.click();
        patientTariffDropdown.sendKeys("Staff Patient (Staff Patient)");
    }
    public void sendSolutation(){
        patientsalutationDropdown.click();
        patientsalutationDropdown.sendKeys("Mr.");
    }
    //     public void sendpatientId(String driver){
    //     patientCatIdDropdown.sendKeys(driver);
    // }
        //     public void clickpatienttype(){
    //     patientCatDropdown.click();
    // }
        //     public void clickpatienttype(){
    //     patientCatDropdown.click();
    // }
        //     public void clickpatienttype(){
    //     patientCatDropdown.click();
    // }



}
