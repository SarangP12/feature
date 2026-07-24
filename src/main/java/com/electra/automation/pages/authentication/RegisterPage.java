package com.electra.automation.pages.authentication;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.utilities.DropDownUtility;



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
    public WebElement btnAddpatient;

    @FindBy(xpath="//button[@type=\"submit\"]")
    public WebElement btnSubmit;

    @FindBy(xpath="//button[normalize-space()='Other Details']")
    public WebElement btnOtherDetails;

    @FindBy(xpath="//div[@class=\"w-4 h-4 rounded-sm border-2 border-gray-300 flex items-center justify-center transition-all duration-300 ease-in-out peer-checked:border-[#476cb7] peer-checked:bg-green-500 peer-checked:scale-110 peer-focus:ring-2 peer-focus:ring-green-300\"]")
    public WebElement btnSameAsCurrentAddress;

// All Text fields 
    @FindBy(xpath="//input[@id=\"patient_category_type\"]")
    public WebElement patientCatTypeDropdown;
    
    @FindBy(xpath="(//input[@id='patient_category_id'])[1]")
    public WebElement patientCatIdDropdown;
    
    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[1]")
    public WebElement patientTariffDropdown;

    @FindBy(xpath="//input[@id=\"salutation\"]")
    public WebElement patientsalutationDropdown;

    @FindBy(xpath="//label[normalize-space()='City']/parent::div//input[starts-with(@id,'react-select-')][1]")  //city dropdown
    public WebElement patientCityInput; //label[normalize-space()='City']/parent::div//input[starts-with(@id,'react-select-')][1]

    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[3]")   //Appointment Doctor Dropdown
    public WebElement ptAppointmentDoctorInput; //label[@for='doctor_id']/preceding::div[contains(@class,'react-select__control')][1]

    @FindBy(xpath="//input[@id=\"first_name\"]")
    public WebElement firstNameInput;

    @FindBy(xpath="//input[@id=\"last_name\"]")
    public WebElement lastNameInput;

    @FindBy(xpath="//input[@placeholder=\"Y\"]")
    public WebElement patientBirthYearinput;

    @FindBy(xpath="//input[@type=\"tel\"]")
    public WebElement patientMobileinput;

    @FindBy(xpath="//input[@id='email']")
    public WebElement patientEmailInput;

    @FindBy(xpath="//input[@id=\"current_address\"]")
    public WebElement patient_addressinput;

    @FindBy(xpath="//label[@for='department_id']/parent::div//input[starts-with(@id,'department_id')]")
    public WebElement patientDepartmentinput; //label[@for='department_id']/parent::div//input[starts-with(@id,'department_id')]

    @FindBy(xpath="//input[@id=\"unit_id\"]")
    public WebElement patientUnitinput;  

    @FindBy(xpath="//input[@id=\"languages_known\"]")
    public WebElement regLanguageInput;

    @FindBy(xpath="//input[@id=\"nationality\"]")
    public WebElement patientNationalityInput;

    @FindBy(xpath="//input[@id=\"religion\"]")
    public WebElement patientReligionInput;

    //@FindBy(xpath="//input[@id=\"unit_id\"]")
    // public WebElement patientUnitinput;

    @FindBy(xpath="//button[@class='shrink-0 p-1 rounded-full transition-colors hover:bg-gray-100 dark:hover:bg-gray-800 text-gray-500']//*[name()='svg']")
    public WebElement logInExitLocation;

    //Assertion element Or Pop Up element ( Toast react PopUpUp)
    @FindBy(xpath="//span[text()=\"Patient Info\"]")
    public WebElement PatientInfoPage;

    @FindBy(xpath="//div[text()=\"Patient already exists\"]")
    public WebElement PatientDuplicateToast;

//Given is Webelement Access Methods
// Dropdown Selection Methods - React option selection define in the DropDown Utility class
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
//     public void selectPatientCity(String category) throws Exception{
//     DropDownUtility.selectReactOption(driver, patientCityInput, category);
// }
    public void selectPatientCity(String city)throws Exception{  
    patientCityInput.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    patientCityInput.sendKeys(city);
    //String listBoxId = patientCityInput.getAttribute("aria-controls");
    String listBoxId = patientCityInput.getDomAttribute("aria-controls");
    String prefix = listBoxId.replace("-listbox", "");
    By option = By.xpath("//div[contains(@id,'-option-') and normalize-space()='" + city + "']");
    wait.until(ExpectedConditions.elementToBeClickable(option)).click();

    // // Wait until dropdown menu is visible
    // wait.until(ExpectedConditions.visibilityOfElementLocated(
    //         By.xpath("//div[contains(@id,'listbox')]")));
    // patientCityInput.sendKeys(city);
    // Thread.sleep(10000);
    // patientCityInput.sendKeys(Keys.ENTER);
}
//     patientCityInput.click();

//     // Wait until at least one dropdown option is visible
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//     wait.until(ExpectedConditions.visibilityOfElementLocated(
//             By.xpath("//div[contains(@class,'react-select__option')]")));
//     patientCityInput.sendKeys(city);
//     patientCityInput.sendKeys(Keys.ENTER);
// }
    //     waitForVisibility(patientCityInput).clear();
    //     patientCityInput.sendKeys(city);
    //     Thread.sleep(2000); // Wait for the dropdown to update
    //     patientCityInput.sendKeys(Keys.ENTER);
    //     Thread.sleep(4000);
    // }
    public void selectAppointmentDoctor(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, ptAppointmentDoctorInput, category);
}
    public void selectAppointmentDepartment(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientDepartmentinput, category);
}
    public void selectAppointmentUnit(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientUnitinput, category);
}
    public void selectRegLanguage(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, regLanguageInput, category);
}
    public void selectPatientNationality(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientNationalityInput, category);
}
    public void selectPatientReligion(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, patientReligionInput, category);
}
//     public void selectAppointmentDoctor(String category) throws Exception{
//     DropDownUtility.selectReactOption(driver, ptAppointmentDoctorInput, category);
// }
//     public void selectAppointmentDepartment(String category) throws Exception{
//     DropDownUtility.selectReactOption(driver, patientDepartmentinput, category);
// }


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
    }
    public void clickSubmit() {
       clickElement(btnSubmit);
    }
    public void clickOtherDetails() {
       clickElement(btnOtherDetails);
    }
    public void clickSameAsCurrentAddress() {
       clickElement(btnSameAsCurrentAddress); 
    }
    //     public void selectPatientCity(String City) throws Exception{
    //     waitForVisibleElement(patientCityInput).clear();
    //     patientCityInput.sendKeys(City);
    //     waitForVisibleElement(patientCityInput);
    //     Thread.sleep(20000);
    //     patientCityInput.click();
    // }    //     public void selectPatientCity(String City) throws Exception{
    //     waitForVisibleElement(patientCityInput).clear();
    //     patientCityInput.sendKeys(City);
    //     waitForVisibleElement(patientCityInput);
    //     Thread.sleep(20000);
    //     patientCityInput.click();
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
    public void patientEmail(String email){
        waitForVisibleElement(patientEmailInput).clear();
        patientEmailInput.sendKeys(email);
    }
public void registerPatient(PatientData patient) throws Exception {

    selectPatientCategoryType(patient.getCategoryType());

    selectPatientCategoryID(patient.getCategoryID());

    selectPatientTariff(patient.getTariff());

    selectPatientSalutation(patient.getSalutation());

    patientFirstName(patient.getFirstName());

    patientLastName(patient.getLastName());

    patientBirthYear(patient.getBirthYear());

    patientmobile(patient.getMobile());

    patientEmail(patient.getEmail());

    patientAdress(patient.getAddress());

    clickSubmit();
}

//     public void registerPatient(String patientName,
//                             String mobile, String email) {
//     patientFirstName(patientName);
//     patientmobile(mobile);
//     patientAdress(email);

//     clickSubmit();
// }
}
