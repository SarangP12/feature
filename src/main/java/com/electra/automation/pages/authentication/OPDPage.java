package com.electra.automation.pages.authentication;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.OPD_Data;
import com.electra.automation.utilities.DropDownUtility;
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;

public class OPDPage extends BaseClass {

    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;
    private DropDownUtility dropDownUtility;

    //Page Factory constructor
    public OPDPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);
        this.dropDownUtility = new DropDownUtility(driver);
    }
    //Webelement for OPD All Buttons fields

    @FindBy(xpath = "//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement allMenuElementBtn;

    @FindBy(xpath = "//img[@alt=\"OPD\"]")
    private WebElement OPDMenuImgAllElement;

    @FindBy(xpath = "//span[text()=\"Doctor Desk\"]")
    private WebElement doctorDeskMenuElement;

    @FindBy(xpath = "//button[normalize-space()=\"EMR/EHR\"]") //(//button[contains(text(),'EMR/EHR')])[1]
    private WebElement btnOPDEMREHR;

    @FindBy(xpath = "//div[@aria-label=\"Time picker\"]")
    private WebElement emrBtnTimePicker;

    @FindBy(xpath = "//button[contains(@class,'bg-green-100') and normalize-space()='Now']")
    private WebElement emrBtnTimePickerNow;

    @FindBy(xpath = "//th[normalize-space()='BP (mmHg)']/ancestor::table//tbody/tr/td[3]//input")
    private WebElement btnOPDEMREHRBPInput;

    @FindBy(xpath = "//th[normalize-space()='Pulse (bpm)']/ancestor::table//tbody/tr/td[4]//input")
    private WebElement btnOPDEMREHRPulseInput;

    @FindBy(xpath = "//th[normalize-space()='Temp (°F)']/ancestor::table//tbody/tr/td[5]//input")
    private WebElement btnOPDEMREHRTempInput;

    @FindBy(xpath = "//th[normalize-space()='SpO₂ (%)']/ancestor::table//tbody/tr/td[6]//input")
    private WebElement btnOPDEMREHRSpO2Input;

    @FindBy(xpath = "//th[normalize-space()='RR (/min)']/ancestor::table//tbody/tr/td[7]//input")
    private WebElement btnOPDEMREHRRRInput;

    @FindBy(xpath = "//th[normalize-space()='Pain (0–10)']/ancestor::table//tbody/tr/td[8]//input")
    private WebElement btnOPDEMREHRPainInput;

    @FindBy(xpath = "//th[normalize-space()='Glucose (mg/dL)']/ancestor::table//tbody/tr/td[9]//input")
    private WebElement btnOPDEMREHRGlucoseInput;

    @FindBy(xpath = "//th[normalize-space()='Weight (kg)']/ancestor::table//tbody/tr/td[10]//input")
    private WebElement btnOPDEMREHRWeightInput;

    @FindBy(xpath = "//th[normalize-space()='Height (cm)']/ancestor::table//tbody/tr/td[11]//input")
    private WebElement btnOPDEMREHRHeightInput;

    @FindBy(xpath = "//button[@title=\"Add reading\"]")
    private WebElement btnOPDEMREHRVitals;

    @FindBy(xpath = "//input[@placeholder=\"e.g., Chest pain, Fever, Headache\"]")
    private WebElement eMREJRCC_HPInput;

    @FindBy(xpath = "//input[starts-with(@id,'assoc-symptoms-')]")
    private WebElement CC_HPSymptomsinput;
    
    @FindBy(xpath = "//input[@placeholder='3']")
    private WebElement CC_HPDurationinput;
    
    @FindBy(xpath = "//div[normalize-space()='Days']//input[starts-with(@id,'select-')]")
    private WebElement CC_HP_DaysInput;
    
    @FindBy(xpath = "//div[normalize-space()='Gradual']//input[starts-with(@id,'select-')]")
    private WebElement CC_HP_GradualInput;
    
    @FindBy(xpath = "//div[@id=\"sec-hpi\"]//div[normalize-space()='Stable']//input[starts-with(@id,'select-')]")
    private WebElement CC_HP_ProgressionInput;
    
    @FindBy(xpath = "//div[@id=\"sec-hpi\"]//div[normalize-space()='Moderate']//input[starts-with(@id,'select-')]")
    private WebElement CC_HP_severityInput;
    
    @FindBy(xpath = "//div[@id='sec-hpi']//button[@title='Add row']")
    private WebElement btnAddRowCC_HP;
    
    @FindBy(xpath = "//div[@id=\"sec-allergy\"]//div[normalize-space()='Medicine']//input[starts-with(@id,'select-')]")
    private WebElement allergyMedicineElementInput;

    @FindBy(xpath = "//div[@id=\"sec-allergy\"]//div[normalize-space()='Moderate']//input[starts-with(@id,'select-')]")
    private WebElement allergySeverityElementInput;
    
    @FindBy(xpath = "//input[@placeholder='e.g., Rash, Anaphylaxis, Hives']")
    private WebElement allergyReactionElementInput;
    
    @FindBy(xpath = "//input[@placeholder='e.g., Penicillin, Peanuts, Latex']")
    private WebElement allergyAllergynElementInput;
    
    @FindBy(xpath = "//div[@id='sec-allergy']//button[@title='Add row']")
    private WebElement btnOPDEMREHRAllergyAdd;
    
    @FindBy(xpath = "//div[@id='sec-diagnosis']//input[starts-with(@id,'react-select-')]")
    private WebElement OPDDignoConditionInput;
    
    @FindBy(xpath = "//input[@placeholder=\"e.g., Hypertensive crisis, rule out MI\"]")
    private WebElement OPDDignoCliniicalInput;
    
    @FindBy(xpath = "//input[@placeholder=\"e.g., Angina, GERD, Costochondritis\"]")
    private WebElement OPDDignoDifferentialInput;
    
    @FindBy(xpath = "//button[@title=\"Add diagnosis\"]")
    private WebElement btnOPDElementDiagnosisAdd;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    //Webelements for OPDPage_ Input Fields
    @FindBy(xpath = "//input[@placeholder=\"Search name, UHID, mobile, OP/IP no...\"]")
    private WebElement searchPatientInputElement;

    public OPDPage() {
    }

    // Webelement for OPD Validation fields
    // Webelement for OPD Toast Message fields
    // Webelement for OPD checkbox  Button fields
    // Method to click on OPD button
    public void clickAllMenuButton() {
        wait.waitForElementClickable(allMenuElementBtn).click();
    }

    public void clickOPDImagebtn() {
        wait.waitForElementClickable(OPDMenuImgAllElement).click();
    }

    public void doctorDeskMenuBtn() {
        wait.waitForElementClickable(doctorDeskMenuElement).click();
    }

    public void clickOPDEMREHR() {
        wait.waitForElementClickable(btnOPDEMREHR).click();
    }

    public void clickbtnCCHP_Add() {
        wait.waitForElementClickable(btnAddRowCC_HP).click();
    }
    public void clickEMREHRVitalAddbtn() {
        wait.waitForElementClickable(btnOPDEMREHRVitals).click();
    }
    public void clickOPDEMREHRAllergyAdd() {
        wait.waitForElementClickable(btnOPDEMREHRAllergyAdd).click();
    }
    public void btnDiagnosisAdd() {
        wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    }

    //Send keys to patient input field
    public void patientOPDSearch(String patenetdetails) {
        wait.waitForElementVisible(searchPatientInputElement);
        searchPatientInputElement.clear();
        searchPatientInputElement.sendKeys(patenetdetails);
    }

    public void patientOPDEMREHRBPInput(String BP) {
        wait.waitForElementVisible(btnOPDEMREHRBPInput);
        btnOPDEMREHRBPInput.clear();
        btnOPDEMREHRBPInput.sendKeys(BP);
    }

    public void patientOPDEMREHRPulseInput(String Pulse) {
        wait.waitForElementVisible(btnOPDEMREHRPulseInput);
        btnOPDEMREHRPulseInput.clear();
        btnOPDEMREHRPulseInput.sendKeys(Pulse);
    }

    public void patientOPDEMREHRTempInput(String Temp) {
        wait.waitForElementVisible(btnOPDEMREHRTempInput);
        btnOPDEMREHRTempInput.clear();
        btnOPDEMREHRTempInput.sendKeys(Temp);
    }

    public void patientOPDEMREHRSpO2Input(String SpO2) {
        wait.waitForElementVisible(btnOPDEMREHRSpO2Input);
        btnOPDEMREHRSpO2Input.clear();
        btnOPDEMREHRSpO2Input.sendKeys(SpO2);
    }

    public void patientOPDEMREHRRRInput(String RR) {
        wait.waitForElementVisible(btnOPDEMREHRRRInput);
        btnOPDEMREHRRRInput.clear();
        btnOPDEMREHRRRInput.sendKeys(RR);
    }

    public void patientOPDEMREHRPainInput(String Pain) {
        wait.waitForElementVisible(btnOPDEMREHRPainInput);
        btnOPDEMREHRPainInput.clear();
        btnOPDEMREHRPainInput.sendKeys(Pain);
    }

    public void patientOPDEMREHRGlucoseInput(String Glucose) {
        wait.waitForElementVisible(btnOPDEMREHRGlucoseInput);
        btnOPDEMREHRGlucoseInput.clear();
        btnOPDEMREHRGlucoseInput.sendKeys(Glucose);
    }

    public void patientOPDEMREHRWeightInput(String Weight) {
        wait.waitForElementVisible(btnOPDEMREHRWeightInput);
        btnOPDEMREHRWeightInput.clear();
        btnOPDEMREHRWeightInput.sendKeys(Weight);
    }

    public void patientOPDEMREHRHeightInput(String Height) {
        wait.waitForElementVisible(btnOPDEMREHRHeightInput);
        btnOPDEMREHRHeightInput.clear();
        btnOPDEMREHRHeightInput.sendKeys(Height);
    }

    public void eMREHR_CCHP_Input(String Input) {
        wait.waitForElementVisible(eMREJRCC_HPInput);
        eMREJRCC_HPInput.clear();
        eMREJRCC_HPInput.sendKeys(Input);
    }

        public void cCHP_DurationInput(String Duration) {
        wait.waitForElementVisible(CC_HPDurationinput);
        CC_HPDurationinput.clear();
        CC_HPDurationinput.sendKeys(Duration);
    }
    public void inputAllergy_Reaction(String reaction) {
        wait.waitForElementVisible(allergyReactionElementInput);
        allergyReactionElementInput.clear();
        allergyReactionElementInput.sendKeys(reaction);
    }
    public void patientAllergenInput(String Allergen) {
        wait.waitForElementVisible(allergyAllergynElementInput);
        allergyAllergynElementInput.clear();
        allergyAllergynElementInput.sendKeys(Allergen);
    }
    // public void SelctEMREHRDignoConditionInput(String condition) {
    //     wait.waitForElementVisible(OPDDignoConditionInput);
    //     OPDDignoConditionInput.clear();
    //     OPDDignoConditionInput.sendKeys(condition);
    // }
    public void dignoEMREHRClinicalInput(String clinical) {
        wait.waitForElementVisible(OPDDignoCliniicalInput);
        OPDDignoCliniicalInput.clear();
        OPDDignoCliniicalInput.sendKeys(clinical);
    }
    public void dignoDiffrentialInput(String differential) {
        wait.waitForElementVisible(OPDDignoDifferentialInput);
        OPDDignoDifferentialInput.clear();
        OPDDignoDifferentialInput.sendKeys(differential);
    }
    // public void patientOPDEMREHRPainInput(String Pain) {
    //     wait.waitForElementVisible(btnOPDEMREHRPainInput);
    //     btnOPDEMREHRPainInput.clear();
    //     btnOPDEMREHRPainInput.sendKeys(Pain);
    // }
    // public void patientOPDEMREHRGlucoseInput(String Glucose) {
    //     wait.waitForElementVisible(btnOPDEMREHRGlucoseInput);
    //     btnOPDEMREHRGlucoseInput.clear();
    //     btnOPDEMREHRGlucoseInput.sendKeys(Glucose);
    // }
    // public void patientOPDEMREHRWeightInput(String Weight) {
    //     wait.waitForElementVisible(btnOPDEMREHRWeightInput);
    //     btnOPDEMREHRWeightInput.clear();
    //     btnOPDEMREHRWeightInput.sendKeys(Weight);
    // }
    // public void patientOPDEMREHRHeightInput(String Height) {
    //     wait.waitForElementVisible(btnOPDEMREHRHeightInput);
    //     btnOPDEMREHRHeightInput.clear();
    //     btnOPDEMREHRHeightInput.sendKeys(Height);
    // }
    // public void eMREHR_CCHP_Input(String BMI) {
    //     wait.waitForElementVisible(eMREJRCC_HPInput);
    //     eMREJRCC_HPInput.clear();
    //     eMREJRCC_HPInput.sendKeys(BMI);
    // }
    
    //Dropdown Element
    public void selectCC_HPSymptoms(String Symptoms) throws Exception {
        dropDownUtility.selectReactOption(CC_HPSymptomsinput, Symptoms);
    }
        public void selectCC_HPDays(String days) throws Exception {
        dropDownUtility.selectReactOption(CC_HP_DaysInput, days);
    }

        public void selectCC_HPOnset(String onset) throws Exception {
        dropDownUtility.selectReactOption(CC_HP_GradualInput, onset);
    }

        public void selectCC_HPProgressionDropdown(String progression) throws Exception {
        dropDownUtility.selectReactOption(CC_HP_ProgressionInput, progression);
    } 
        public void selectCC_HPSeverity(String severity) throws Exception {
        dropDownUtility.selectReactOption(CC_HP_severityInput, severity);
    }

        public void selectAllergy_Medicine(String medicine) throws Exception {
        dropDownUtility.selectReactOption(allergyMedicineElementInput, medicine);
    }
        public void selectAllergy_Severity(String Alseveriry) throws Exception {
        dropDownUtility.selectReactOption(allergySeverityElementInput, Alseveriry);
    }
        public void selectCC_DignoCondition(String condition) throws Exception {
        dropDownUtility.selectReactOption(OPDDignoConditionInput, condition);
    }
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
    // }    //     public void selectCC_HPSymptoms(String Symptoms) throws Exception {
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


    //OPDPage Methods --> OPD test reusable methods
    public void patientOPDMenuOpen() throws Exception {

        clickAllMenuButton();
        clickOPDImagebtn();
        doctorDeskMenuBtn();
        Thread.sleep(2000);

    }

    public void patientEMREHRRecord(OPD_Data Opd) throws Exception {

        patientOPDMenuOpen();
        // patientOPDSearch(Opd.getFirstName());
        patientOPDSearch("Sultan");
        clickOPDEMREHR();
//Vitals Records
        wait.waitForElementClickable(emrBtnTimePicker).click();
        wait.waitForElementClickable(emrBtnTimePickerNow).click();
        patientOPDEMREHRBPInput(Opd.getOPDEMREHRBP());
        patientOPDEMREHRPulseInput(Opd.getOPDEMREHRPulse());
        patientOPDEMREHRTempInput(Opd.getOPDEMREHRTemp());
        patientOPDEMREHRSpO2Input(Opd.getOPDEMREHRSpO2());
        patientOPDEMREHRRRInput(Opd.getOPDEMREHRRR());
        patientOPDEMREHRPainInput(Opd.getOPDEMREHRPain());
        patientOPDEMREHRGlucoseInput(Opd.getOPDEMREHRGlucose());
        patientOPDEMREHRWeightInput(Opd.getOPDEMREHRWeight());
        patientOPDEMREHRHeightInput(Opd.getOPDEMREHRHeight());
        clickEMREHRVitalAddbtn();
//CC & HP
        eMREHR_CCHP_Input("Fever");
        selectCC_HPSymptoms(Opd.getAssociatedSymptoms());
        cCHP_DurationInput(Opd.getDurationCCHP());
        selectCC_HPDays(Opd.getDaysCCHP());
        selectCC_HPOnset(Opd.getOnsetCCHP());
        selectCC_HPSeverity(Opd.getSeverity());
        selectCC_HPProgressionDropdown(Opd.getProgression());
        clickbtnCCHP_Add();
//Allergy
        selectAllergy_Medicine("Latex");
        patientAllergenInput(", Pinnuts");
        selectAllergy_Severity("Moderate");
        inputAllergy_Reaction("Skin Rash");
        clickOPDEMREHRAllergyAdd();
//Dignosis
        selectCC_DignoCondition("Cholera");
        dignoEMREHRClinicalInput("Rule Out");
        dignoDiffrentialInput("GERD");
        btnDiagnosisAdd();



    }

    // Method assertion for OPDPage can be added here
    //Asertion Methods
    // public String getEnteredFirstName() {
    //     wait.waitForElementVisible(firstNameInput);
    //     return firstNameInput.getDomProperty("value").trim();
    // }
    // Additional methods for OPDPage can be added here
}
