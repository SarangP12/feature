package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.electra.automation.base.BaseClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.OPD_Data;
import com.electra.automation.models.PatientData;
import com.electra.automation.utilities.ADTFUtility;
import com.electra.automation.utilities.BedUtility;
import com.electra.automation.utilities.DropDownUtility;
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;
import com.electra.automation.utilities.DateUtility;
import com.electra.automation.utilities.CheckboxUtility;
import com.fasterxml.jackson.databind.deser.Deserializers;

public class BillingPage extends BaseClass {

    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;
    private BedUtility bedUtility;
    private DropDownUtility dropDownUtility;
    private ADTFUtility ADTF_Utility;
    private DateUtility dateUtility;
    private CheckboxUtility checkboxUtility;

    ////////////////////////////////////////////////////////////
    //Page Factory constructor
    ////////////////////////////////////////////////////////////

    public BillingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.dateUtility = new DateUtility(driver);

        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);
        this.bedUtility = new BedUtility(driver);
        this.ADTF_Utility = new ADTFUtility();
        this.dropDownUtility = new DropDownUtility(driver);
        this.checkboxUtility = new CheckboxUtility(driver);
    }
    /////////////////////////////////////////////////////////////////////////////////
//Webelement for Billing All Buttons fields
/////////////////////////////////////////////////////////////////////////////////
    
    @FindBy(xpath = "//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement allMenuElementBtn;

    @FindBy(xpath = "//img[@alt=\"Billing\"]")
    private WebElement billingModule;

    @FindBy(xpath = "//a[.//span[normalize-space()='Billing']]")
    private WebElement BillingbuttonClickElement;

// Amount displayed in Billing module
    @FindBy(xpath = "//table[@data-highlight-on-hover='true']//tbody/tr[1]/td[count(//table[@data-highlight-on-hover='true']//th[@data-accessor='amount']/preceding-sibling::th)+1]")
    private WebElement billingAmount;

    @FindBy(xpath = "//button[@title='Search']//div[@class='flex items-center justify-center w-6 h-6']//*[name()='svg']")
    private WebElement btnSearch;

    // Billing module Patient ID search field
    @FindBy(xpath = "//input[@placeholder='Search by patient name, UHID, mobile no, bill no...']")
    public WebElement searchBillingElement;

    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    /////////////////////////////////////////////////////////////////////////////
// // Return values method
////////////////////////////////////////////////////////////////////////////
    public String getBillingAmount() {
        return billingAmount.getText().trim();
    }

    /////////////////////////////////////////////////////////////////////////////
// // Method to click on Billing pages button
////////////////////////////////////////////////////////////////////////////
    
        public void clickAllMenuButton() {
        clickElement(allMenuElementBtn);
    }

    public void clickBillingModule() {
        clickElement(billingModule);
    }

    public void btnBillingchild() {
        clickElement(BillingbuttonClickElement);
    }

    public void clickSearch() {
        clickElement(btnSearch);
    }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }
    //     public void clickSearch() {
    //     clickElement(btnSearch);
    // }

    /////////////////////////////////////////////////////////////////////////////
// /Sendkey Billing methods
////////////////////////////////////////////////////////////////////////////
    //     public void patientFirstName1(String Fname) {
    //     wait.waitForElementVisible(searchBillingElement);
    //     searchBillingElement.clear();
    //     searchBillingElement.sendKeys(Fname);
    // }
        public void patientFirstName1(String Fname) {
        enterText(searchBillingElement, Fname);
    }

    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    //     public void patientFirstName1(String Fname) {
    //     enterText(searchBillingElement, Fname);
    // }
    /////////////////////////////////////////////////////////////////////////////
/// Dropdown Methods to select the options on react dropdown
////////////////////////////////////////////////////////////////////////////
    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //         public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //         public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }
    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
    //     dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    // }

/////////////////////////////////////////////////////////////////////////////////
    // Date picker method to select the date from the calendarUtility class
///////////////////////////////////////////////////////////////////////////////// 

    //     public void selectADTFadmitDateInput(String AdmtDate) throws Exception {
    //     dateUtility.selectDate(ADTFadmitDateInput, AdmtDate);
    // }
    //     public void selectADTFdischargeDateInput(String DischargeDate) throws Exception {
    //     dateUtility.selectDate(ADTFdischargeDateInput, DischargeDate);
    // }
    //     public void selectADTFSurgeryDateInput(String SurgeryDate) throws Exception {
    //     dateUtility.selectDate(ADTFSurgeryDateInput, SurgeryDate);
    // }
////////////////////////////////////////////////////////////////////////////////
    //  Checkbox Utility for CheckBox
////////////////////////////////////////////////////////////////////////////////
        // public void btnABDMConsentCheckBox() {
        // checkboxUtility.checkCheckbox(ABDMConsentCheckBox);
        // }

/////////////////////////////////////////////////////////////////////////////////////
/// All Defined Methods
/// ////////////////////////////////////////////////////////////////////////////////
    // Billing search button 
    
    public void searchPatientBilling(PatientData patient) throws Exception {

        clickSearch();
        patientFirstName1(patient.getFirstName());
        clickSearch();
        Thread.sleep(2000);
    }

//Billing Methods --> Billing test reusable methods
    public void patientBillingMenuOpen() throws Exception {

        clickAllMenuButton();
        clickBillingModule();
        btnBillingchild();

        Thread.sleep(2000);

    }

}
