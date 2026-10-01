package com.electra.automation.pages.authentication;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.electra.automation.base.BaseClass;
import com.electra.automation.models.OPD_Data;
import com.electra.automation.utilities.BedUtility;
import com.electra.automation.utilities.DropDownUtility;
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;

public class OPDPage extends BaseClass {

    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;
    private BedUtility bedUtility;
    private DropDownUtility dropDownUtility;

    //Page Factory constructor
    public OPDPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);
        this.bedUtility = new BedUtility(driver);
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
    
    @FindBy(xpath = "//div[@id='sec-lab']//input[starts-with(@id,'react-select-')]")
    private WebElement LABTestNameInput;
    
    @FindBy(xpath = "//div[@id='sec-lab']//tbody/tr[1]//td[2]//input[@role='combobox']")
    private WebElement LabSpecimentInput;
   
    @FindBy(xpath = "//div[@id='sec-lab']//tbody/tr[1]//td[3]//input[@role='combobox']")
    private WebElement LabPriorityInput;
    
    @FindBy(xpath = "//div[@id='sec-lab']//input[@placeholder='e.g., Fasting hrs, early morning sample']")
    private WebElement LabInstructionInput;
    
    @FindBy(xpath = "//div[@id='sec-lab']//button[@title=\"Add row\"]")
    private WebElement btnLabAddRow;

    @FindBy(xpath = "//div[@id='sec-rad']//input[starts-with(@id,'radstudy-')]")
    private WebElement RadiologyTestInput;
    
    @FindBy(xpath = "//div[@id='sec-rad']//input[starts-with(@placeholder,'e.g., Chest, Abdomen, Knee')]")
    private WebElement RadBodyPartInput;
    
    @FindBy(xpath = "//div[@id='sec-rad']//input[starts-with(@id,'select-')]")
    private WebElement RadPriorityInput;
    
    @FindBy(xpath = "//div[@id='sec-rad']//input[starts-with(@placeholder,'e.g., Rule out pneumonia, fracture')]")
    private WebElement RadIndicationInput;
    
    @FindBy(xpath = "//div[@id='sec-rad']//button[@title=\"Add row\"]")
    private WebElement btnRadAddRow;
   
    @FindBy(xpath = "//div[@id='sec-rx']//input[starts-with(@id,'rx-')]")
    private WebElement PharmadrugInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//input[starts-with(@placeholder,'e.g., 500 mg')]")
    private WebElement PharmadoseInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//div[normalize-space()='Tablet']//input[starts-with(@id,'select-')]")
    private WebElement PharmaTypeInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//div[normalize-space()='Oral']//input[starts-with(@id,'select-')]")
    private WebElement PharmaRouteInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//div[normalize-space()='Frequency…']//input[starts-with(@id,'select-')]")
    private WebElement PharmaFrequencyInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//input[starts-with(@placeholder,'e.g., 5 days, 1 month')]")
    private WebElement PharmaDurationInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//input[starts-with(@placeholder,'e.g., 10')]")
    private WebElement PharmaQuantityInput;
    
    @FindBy(xpath = "//div[@id='sec-rx']//input[starts-with(@placeholder,'e.g., After meals avoid alcohol')]")
    private WebElement PharmaInstructionsInput;

    @FindBy(xpath = "//div[@id='sec-rx']//button[@title=\"Add row\"]")
    private WebElement btnRxAddRow;
    
    @FindBy(xpath = "//div[@id='sec-proc']//input[starts-with(@id,'procselect-')]")
    private WebElement ProcedureInput;
    
    @FindBy(xpath = "//div[@id='sec-proc']//input[starts-with(@placeholder,'e.g., Right arm Left knee')]")
    private WebElement ProcedureLateralityInput;
    
    @FindBy(xpath = "//div[@id='sec-proc']//input[starts-with(@id,'select-')]")
    private WebElement ProcedurePriorityInput;
    
    @FindBy(xpath = "//div[@id='sec-proc']//input[starts-with(@Placeholder,'e.g., Diagnostic, therapeutic')]")
    private WebElement ProcedureIndicationInput;
    
    @FindBy(xpath = "//div[@id='sec-proc']//button[@title=\"Add row\"]")
    private WebElement btnProcedureAddRow;
    
    @FindBy(xpath = "//div[@id='sec-diet']//input[starts-with(@id,'select-')]")
    private WebElement DietOrderInput;

    @FindBy(xpath = "//div[@id='sec-diet']//input[starts-with(@placeholder,'e.g., 3×/day')]")
    private WebElement DietMealFrequencyInput;
   
    @FindBy(xpath = "//div[@id='sec-diet']//input[starts-with(@placeholder,'e.g., 1800 (kcal/day)')]")
    private WebElement DietCalorieInput;
    
    @FindBy(xpath = "//div[@id='sec-diet']//input[starts-with(@placeholder,'e.g., 1500 (mL/day)')]")
    private WebElement DietFluidInput;
   
    @FindBy(xpath = "//div[@id='sec-diet']//input[starts-with(@placeholder,'e.g., Low sodium no spicy food diabetic diet')]")
    private WebElement DietSpecialInstructionsInput;
    
    @FindBy(xpath = "//div[@id='sec-diet']//button[@title=\"Add diet row\"]")
    private WebElement btnDietAddRow;
    
    @FindBy(xpath = "//button[text()=\"Transfer\"]")
    private WebElement EMRTransferBtn;
    
    @FindBy(xpath = "//div[@id='sec-adtf']//input[@id=\"transferDept\"]")
    private WebElement ADTFTransferDeptInput;
   
    @FindBy(xpath = "//div[@id='sec-adtf']//input[@id=\"transferUnit\"]")
    private WebElement ADTFTransferUnitInput;

    @FindBy(xpath = "//div[@id='sec-adtf']//input[@id=\"transferDoctor\"]")
    private WebElement ADTFTransferDoctorInput; 
    
    @FindBy(xpath = "//span[normalize-space()='Select bed...']/parent::div")
    private WebElement ADTFSelectBedInput;
    
    @FindBy(xpath = "//input[@id='bed_modal_ward']")
    private WebElement ADTFSelectBedWardInput;
    
    @FindBy(xpath = "//div[contains(@class,'cursor-pointer')][.//span[normalize-space()='Free']]")
    private List<WebElement> availableElements;
    
    @FindBy(xpath = "//button[text()=\"Confirm Selection\"]")
    private WebElement confirmButton;
    
    @FindBy(xpath = "//input[@id='transferReason']")
    private WebElement ADTFTransferReasonInput;
    
    @FindBy(xpath = "//textarea[@id='transferRemark']")
    private WebElement ADTFTransferRemarkInput;
   
    @FindBy(xpath = "//button[text()=\"Discharge\"]")
    private WebElement EMRDischargeBtn;
    
    @FindBy(xpath = "//input[@id=\"dischargeReason\"]")
    private WebElement EMRDischargeReasonInput;
    
    @FindBy(xpath = "//button[text()=\"Referral\"]")
    private WebElement EMRReferralBtn;
   
    @FindBy(xpath = "//th[normalize-space()='Referral Type']/ancestor::table//input[@role='combobox']")
    private WebElement EMRReferralTypeInput;
    
    @FindBy(xpath = "//textarea[@placeholder=\"Instructions for referral follow-through…\"]")
    private WebElement EMRReferralDispositionInput;
   
    @FindBy(xpath = "//textarea[@placeholder='Clinical reason, handover notes…']")
    private WebElement EMRReferralRemarkInput;
   
    @FindBy(xpath = "//div[@id=\"sec-adtf\"]//input[@id=\"referralDepartment\"]")
    private WebElement EMRReferralDepartmentInput;
    
    @FindBy(xpath = "//div[@id=\"sec-adtf\"]//input[@id=\"referralUnit\"]")
    private WebElement EMRReferralUnitInput;
    
    @FindBy(xpath = "//div[@id=\"sec-adtf\"]//input[@id=\"referralDoctor\"]")
    private WebElement EMRReferralDoctorInput;
    
    @FindBy(xpath = "//div[@id=\"sec-soap\"]//textarea[@placeholder=\"Patient's complaints, history, HPI…\"]")
    private WebElement EMRSoapSubjectiveInput;
    
    @FindBy(xpath = "//div[@id=\"sec-soap\"]//textarea[@placeholder=\"Vitals, examination findings, investigations…\"]")
    private WebElement EMRSoapObjectiveInput;
    
    @FindBy(xpath = "//div[@id=\"sec-soap\"]//textarea[@placeholder=\"Working diagnosis, clinical impression…\"]")
    private WebElement EMRSoapAssessmentInput;
    
    @FindBy(xpath = "//div[@id=\"sec-soap\"]//textarea[@placeholder=\"Treatment plan, medications, follow-up…\"]")
    private WebElement EMRSoapPlanInput;
    
    @FindBy(xpath = "//div[@id=\"sec-soap\"]//input[@placeholder=\"Dr Full Name\"]")
    private WebElement EMRSoapDoctorInput;
    
    @FindBy(xpath = "//div[@id=\"sec-soap\"]//input[@placeholder=\"e.g., MCI-12345\"]")
    private WebElement EMRSoapMCIInput;
    
    @FindBy(xpath = "e.g., General Medicine MBBS MD")
    private WebElement EMRSoapDepartmentInput;

    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
    // // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // // private WebElement btnOPDImgAll;
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
        public void btnLabAdd() {
        wait.waitForElementClickable(btnLabAddRow).click();
    }
        public void btnRadAddRow() {
        wait.waitForElementClickable(btnRadAddRow).click();
    }
        public void btnRxAddRow() {
        wait.waitForElementClickable(btnRxAddRow).click();
    }
        public void btnProcedureAdd() {
        wait.waitForElementClickable(btnProcedureAddRow).click();
    }
        public void btnDiet_AddRow() {
        wait.waitForElementClickable(btnDietAddRow).click();
    }
        public void btnEMRTransfer() {
        wait.waitForElementClickable(EMRTransferBtn).click();
    }
        public void selectADTF_SelectBed() {
        wait.waitForElementClickable(ADTFSelectBedInput).click();
    }
        public void btnEMRDischarge() {
        wait.waitForElementClickable(EMRDischargeBtn).click();
    }
        public void btnEMRReferral() {
        wait.waitForElementClickable(EMRReferralBtn).click();
    }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }
    //     public void btnDiagnosisAdd() {
    //     wait.waitForElementClickable(btnOPDElementDiagnosisAdd).click();
    // }


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
    public void lanInstructionInput(String instruction) {
        wait.waitForElementVisible(LabInstructionInput);
        LabInstructionInput.clear();
        LabInstructionInput.sendKeys(instruction);
    }
    public void radBodyPart_Input(String bodyPart) {
        wait.waitForElementVisible(RadBodyPartInput);
        RadBodyPartInput.clear();
        RadBodyPartInput.sendKeys(bodyPart);
    }
    public void rad_IndicationInput(String indication) {
        wait.waitForElementVisible(RadIndicationInput);
        RadIndicationInput.clear();
        RadIndicationInput.sendKeys(indication);
    }
    public void pharma_DoseInput(String dose) {
        wait.waitForElementVisible(PharmadoseInput);
        PharmadoseInput.clear();
        PharmadoseInput.sendKeys(dose);
    }
    public void pharmaDuration_Input(String duration) {
        wait.waitForElementVisible(PharmaDurationInput);
        PharmaDurationInput.clear();
        PharmaDurationInput.sendKeys(duration);
    }
    public void pharmaQuantity_Input(String quantity) {
        wait.waitForElementVisible(PharmaQuantityInput);
        PharmaQuantityInput.clear();
        PharmaQuantityInput.sendKeys(quantity);
    }
    public void pharmaInstructions_Input(String instructions) {
        wait.waitForElementVisible(PharmaInstructionsInput);
        PharmaInstructionsInput.clear();
        PharmaInstructionsInput.sendKeys(instructions);
    }
    public void procedure_LateralityInput(String laterality) {
        wait.waitForElementVisible(ProcedureLateralityInput);
        ProcedureLateralityInput.clear();
        ProcedureLateralityInput.sendKeys(laterality);
    }
        public void procedure_IndicationInput(String indication) {
        wait.waitForElementVisible(ProcedureIndicationInput);
        ProcedureIndicationInput.clear();
        ProcedureIndicationInput.sendKeys(indication);
    }
    public void dietMealFrequencyInput(String MealFrequency) {
        wait.waitForElementVisible(DietMealFrequencyInput);
        DietMealFrequencyInput.clear();
        DietMealFrequencyInput.sendKeys(MealFrequency);
    }
    public void dietCalorieInput(String Calorie) {
        wait.waitForElementVisible(DietCalorieInput);
        DietCalorieInput.clear();
        DietCalorieInput.sendKeys(Calorie);
    }
    public void dietFluidInput(String fluid) {
        wait.waitForElementVisible(DietFluidInput);
        DietFluidInput.clear();
        DietFluidInput.sendKeys(fluid);
    }
        public void dietSpecialInstructionsInput(String SpecialInstructions) {
        wait.waitForElementVisible(DietSpecialInstructionsInput);
        DietSpecialInstructionsInput.clear();
        DietSpecialInstructionsInput.sendKeys(SpecialInstructions);
    }
    public void ADTFTransferReasonInput(String reason) {
        wait.waitForElementVisible(ADTFTransferReasonInput);
        ADTFTransferReasonInput.clear();
        ADTFTransferReasonInput.sendKeys(reason);
    }
    public void ADTFTransferRemarkInput(String remark) {
        wait.waitForElementVisible(ADTFTransferRemarkInput);
        ADTFTransferRemarkInput.clear();
        ADTFTransferRemarkInput.sendKeys(remark);
    }
    public void EMRReferralDispositionInput(String disposition) {
        wait.waitForElementVisible(EMRReferralDispositionInput);
        EMRReferralDispositionInput.clear();
        EMRReferralDispositionInput.sendKeys(disposition);
    }
    public void EMRReferralRemarkInput(String remark) {
        wait.waitForElementVisible(EMRReferralRemarkInput);
        EMRReferralRemarkInput.clear();
        EMRReferralRemarkInput.sendKeys(remark);
    }
    public void EMRSoapSubjectiveInput(String condition) {
        wait.waitForElementVisible(EMRSoapSubjectiveInput);
        EMRSoapSubjectiveInput.clear();
        EMRSoapSubjectiveInput.sendKeys(condition);
    }
    public void EMRSoapObjectiveInput(String objective) {
        wait.waitForElementVisible(EMRSoapObjectiveInput);
        EMRSoapObjectiveInput.clear();
        EMRSoapObjectiveInput.sendKeys(objective);
    }
    public void EMRSoapAssessmentInput(String assessment) {
        wait.waitForElementVisible(EMRSoapAssessmentInput);
        EMRSoapAssessmentInput.clear();
        EMRSoapAssessmentInput.sendKeys(assessment);
    }
        public void EMRSoapPlanInput(String Plan) {
        wait.waitForElementVisible(EMRSoapPlanInput);
        EMRSoapPlanInput.clear();
        EMRSoapPlanInput.sendKeys(Plan);
    }
    public void EMRSoapDoctorInput(String doctorSoap) {
        wait.waitForElementVisible(EMRSoapDoctorInput);
        EMRSoapDoctorInput.clear();
        EMRSoapDoctorInput.sendKeys(doctorSoap);
    }
    public void EMRSoapMCIInput(String MCI) {
        wait.waitForElementVisible(EMRSoapMCIInput);
        EMRSoapMCIInput.clear();
        EMRSoapMCIInput.sendKeys(MCI);
    }
    public void EMRSoapDepartmentInput(String SoapDepartment) {
        wait.waitForElementVisible(EMRSoapDepartmentInput);
        EMRSoapDepartmentInput.clear();
        EMRSoapDepartmentInput.sendKeys(SoapDepartment);
    }
    // public void eMREHR_CCHP_Input(String BMI) {
    //     wait.waitForElementVisible(eMREJRCC_HPInput);
    //     eMREJRCC_HPInput.clear();
    //     eMREJRCC_HPInput.sendKeys(BMI);
    // }
    // public void SelctEMREHRDignoConditionInput(String condition) {
    //     wait.waitForElementVisible(OPDDignoConditionInput);
    //     OPDDignoConditionInput.clear();
    //     OPDDignoConditionInput.sendKeys(condition);
    // }
    // public void eMREHR_CCHP_Input(String BMI) {
    //     wait.waitForElementVisible(eMREJRCC_HPInput);
    //     eMREJRCC_HPInput.clear();
    //     eMREJRCC_HPInput.sendKeys(BMI);
    // }
    // public void SelctEMREHRDignoConditionInput(String condition) {
    //     wait.waitForElementVisible(OPDDignoConditionInput);
    //     OPDDignoConditionInput.clear();
    //     OPDDignoConditionInput.sendKeys(condition);
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
        public void selectLab_Test(String test) throws Exception {
        dropDownUtility.selectReactOption(LABTestNameInput, test);
    }
        public void selectLab_Specimen(String specimen) throws Exception {
        dropDownUtility.selectReactOption(LabSpecimentInput, specimen);
    }
        public void selectLab_Priority(String priority) throws Exception {
        dropDownUtility.selectReactOption(LabPriorityInput, priority);
    }
            public void selectRad_TestInput(String test) throws Exception {
        dropDownUtility.selectReactOption(RadiologyTestInput, test);
    }
        public void selectRad_Priority(String priority) throws Exception {
        dropDownUtility.selectReactOption(RadPriorityInput, priority);
    }
        public void selectPharma_DrugInput(String drug) throws Exception {
        dropDownUtility.selectReactOption(PharmadrugInput, drug);
    }
        public void selectPharma_TypeInput(String type) throws Exception {
        dropDownUtility.selectReactOption(PharmaTypeInput, type);
    }
        public void selectPharma_RouteInput(String route) throws Exception {
        dropDownUtility.selectReactOption(PharmaRouteInput, route);
    }
        public void selectPharma_FrequencyInput(String frequency) throws Exception {
        dropDownUtility.selectReactOption(PharmaFrequencyInput, frequency);
    }
        public void selectProcedure_Input(String procedure) throws Exception {
        dropDownUtility.selectReactOption(ProcedureInput, procedure);
    }
        public void selectProcedure_Priority(String prPriority) throws Exception {
        dropDownUtility.selectReactOption(ProcedurePriorityInput, prPriority);
    }
        public void selectDiet_Order(String dietOrder) throws Exception {
        dropDownUtility.selectReactOption(DietOrderInput, dietOrder);
    }
        public void selectADTFTransferDept(String depart) throws Exception {
        dropDownUtility.selectReactOption(ADTFTransferDeptInput, depart);
    }

        public void selectADTF_TransferUnit(String unit) throws Exception {
        dropDownUtility.selectReactOption(ADTFTransferUnitInput, unit);
    }
        public void selectADTF_TransferDoctor(String doctor) throws Exception {
        dropDownUtility.selectReactOption(ADTFTransferDoctorInput, doctor);
    }
        public void selectADTF_SelectBedWard(String ward) throws Exception {
        dropDownUtility.selectReactOption(ADTFSelectBedWardInput, ward);
    }
        public void selectEMRDischargeReason(String DichargeReason) throws Exception {
        dropDownUtility.selectReactOption(EMRDischargeReasonInput, DichargeReason);
    }    
        public void selectEMRReferralType(String RType) throws Exception {
       dropDownUtility.selectReactOption(EMRReferralTypeInput, RType);
    }
        public void selectReferralDepartment(String department) throws Exception {
        dropDownUtility.selectReactOption(EMRReferralDepartmentInput, department);
    }
            public void selectReferralUnit(String unit) throws Exception {
        dropDownUtility.selectReactOption(EMRReferralUnitInput, unit);
    }
        public void selectReferralDoctor(String doctor) throws Exception {
        dropDownUtility.selectReactOption(EMRReferralDoctorInput, doctor);
    }
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
        patientOPDSearch("Veera");
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
//Lab Test
        selectLab_Test("Liver Function Test");
        selectLab_Specimen("Blood");
        selectLab_Priority("Urgent");
        lanInstructionInput("Fasting hrs, early morning sample");
        btnLabAdd();
//Radiology
        // selectRad_TestInput("MRI BRAIN");
        radBodyPart_Input("Brain");
        selectRad_Priority("Urgent");
        rad_IndicationInput("fracture");
        btnRadAddRow();
//Pharmacy -Prescription
        selectPharma_DrugInput("Dolo 650mg");
        pharma_DoseInput("650");
        selectPharma_TypeInput("Capsule");
        selectPharma_RouteInput("Oral");
        selectPharma_FrequencyInput("1-1");
        pharmaDuration_Input("5 days");
        pharmaQuantity_Input("10");
        pharmaInstructions_Input("After meals avoid alcohol");
        btnRxAddRow();
//Procedure
        //selectProcedure_Input("ENT Surgery");
        procedure_LateralityInput("Right arm");
        selectProcedure_Priority("Urgent");
        procedure_IndicationInput("Diagnostic");
        btnProcedureAdd();
//Diet Order
        selectDiet_Order("Non-Veg");
        dietMealFrequencyInput("3 times/day");
        dietCalorieInput("1800 (kcal/day)");
        dietFluidInput("1500 (mL/day)");
        dietSpecialInstructionsInput("Low sodium no spicy food diabetic diet");
        btnDiet_AddRow();
//ADTF Transfer
        btnEMRTransfer();
        selectADTFTransferDept("General Medicine");
        selectADTF_TransferUnit("General Medicine - Unit A");
        selectADTF_TransferDoctor("Dr Sarang D Pawar");
        selectADTF_SelectBed();
        selectADTF_SelectBedWard("Orthopedic Ward Male");
        selectRandomAvailableBeds();
        ADTFTransferReasonInput("Patient requires specialized care in the orthopedic ward.");
        ADTFTransferRemarkInput("Patient has a history of orthopedic issues and needs further evaluation and treatment in the orthopedic ward.");
//ADTF Dicharge
        btnEMRDischarge();
        selectEMRDischargeReason("LAMA");
//ADTF Referral
        btnEMRReferral();
        selectEMRReferralType("External");
        EMRReferralDispositionInput("Patient is being referred to an external specialist for further evaluation and management of their condition.");
        EMRReferralRemarkInput("Patient requires specialized care and follow-up with an external specialist to ensure optimal management of their condition.");
        selectReferralDepartment("General Medicine");
        selectReferralUnit("General Medicine - Unit A");
        selectReferralDoctor("Dr Sarang D Pawar");
        Thread.sleep(3000);
//Clinical Notes - SOAP
        EMRSoapSubjectiveInput("Patient presents with complaints of fever, fatigue");
        EMRSoapObjectiveInput("Vitals: BP 120/80 mmHg, Pulse 80 bpm, Temp 101°F, SpO2 98%, RR 18/min,");
        EMRSoapAssessmentInput("Working diagnosis: Viral infection, clinical impression: Monitor and manage symptoms");
        EMRSoapPlanInput("Treatment plan: Prescribe antipyretics, advise rest and hydration, follow-up in 3 days");
        EMRSoapDoctorInput("Dr Sarang D Pawar");
        EMRSoapMCIInput("MCI-12345");
        EMRSoapDepartmentInput("General Medicine");
    
    
    
    
    }

    public void selectRandomAvailableBeds() {

    bedUtility.selectRandomAvailable(
            availableElements,
            confirmButton
    );
}
    // Method assertion for OPDPage can be added here
    //Asertion Methods
    // public String getEnteredFirstName() {
    //     wait.waitForElementVisible(firstNameInput);
    //     return firstNameInput.getDomProperty("value").trim();
    // }
    // Additional methods for OPDPage can be added here
}
