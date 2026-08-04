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
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;



public class RegisterPage extends BaseClass {

    private WebDriver driver;
    private SwitchButton switchbutton;
    private SetupMasterPage SetupMasterPage;
    private WaitUtility wait;

//Page Factory constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
        SetupMasterPage  = new SetupMasterPage(driver);
        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);
    }
//     private WebDriverWait waitForDriver() {
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
//     private WebElement waitForClickableElement(WebElement element) {
//     return waitForDriver().until(ExpectedConditions.elementToBeClickable(element));
// }
//     private WebElement waitForVisibleElement(WebElement element) {
//         return waitForDriver().until(ExpectedConditions.visibilityOf(element));
//     }
// Click Action button Master
    @FindBy(xpath="//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement btnAllMenuElement;

    @FindBy(xpath = "//img[@alt=\"Registrations\"]")
    private WebElement btnRegImgAll;

    @FindBy(xpath="//span[text()=\"Patients\"]")
    private WebElement btnClickPatients;

    // @FindBy(xpath="//li[31]//button[1]")
    // public WebElement btnSetup; 

    // @FindBy(xpath="//span[text()=\"Settings\"]")
    // public WebElement btnSetting;

    @FindBy(xpath="//span[text()=\"Patient Management\"]")
    public WebElement btnPatManagemnt; 

    // @FindBy(xpath="//div[@title='Registration With Appointment']/ancestor::div[contains(@class,'space-y-2')]//label")
    // public WebElement switchButton; 

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

    // @FindBy(xpath="//button[normalize-space()='Save']")
    // public WebElement btnPatMngtSave;

    @FindBy(xpath="//button[normalize-space()='Other Details']")
    public WebElement btnOtherDetails;

    @FindBy(xpath="//div[@class=\"w-4 h-4 rounded-sm border-2 border-gray-300 flex items-center justify-center transition-all duration-300 ease-in-out peer-checked:border-[#476cb7] peer-checked:bg-green-500 peer-checked:scale-110 peer-focus:ring-2 peer-focus:ring-green-300\"]")
    public WebElement btnSameAsCurrentAddress;

    @FindBy(xpath="//button[@title='Switch to List']//div[@class='flex items-center justify-center w-6 h-6']//*[name()='svg']")
    public WebElement btnSwitchtoListDetails;

    @FindBy(xpath="//a[@href=\"/registrations/c3111952-6888-461d-9e90-7d6cd5067299\"]")
    public WebElement btnAppointment;

    @FindBy(xpath="//span[text()=\"Bookings\"]")
    public WebElement btnBookings;

    // @FindBy(xpath="//span[text()="Bookings"]")
    // public WebElement btnBookings;


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

    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[3]")  //Register with Appointment Doctor Dropdown
    public WebElement regwithAppointmentDoctorInput; 

    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[2]")   //Seperate Appointment Doctor Dropdown 
    public WebElement onlyAppointmentDoctorInput;

    @FindBy(xpath="(//input[starts-with(@id,'react-select-')])[1]")   //Seperate Booking Doctor Dropdown 
    public WebElement onlyBookingDoctorInput;

    @FindBy(xpath="//input[@id=\"visit_type\"]")
    public WebElement appointmentVisitTypeInput;

    @FindBy(xpath="//input[@id=\"first_name\"]")
    public WebElement firstNameInput;

    @FindBy(xpath="//input[@id=\"patient_name\"]")
    public WebElement patientNameInput;

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
    public WebElement patientDepartmentinput;

    @FindBy(xpath="//input[@id=\"unit_id\"]")
    public WebElement patientUnitinput;  

    @FindBy(xpath="//input[@id=\"languages_known\"]")
    public WebElement regLanguageInput;

    @FindBy(xpath="//input[@id=\"nationality\"]")
    public WebElement patientNationalityInput;

    @FindBy(xpath="//input[@id=\"religion\"]")
    public WebElement patientReligionInput; 

    @FindBy(xpath="//input[@id=\"age\"]")
    public WebElement patBookingAgeInput;

    @FindBy(xpath="//input[@id=\"gender\"]")
    public WebElement patBookingGenderInput;

    @FindBy(xpath="//div[@class=\"react-select__input-container css-1deasmo\"]//input[@class=\"react-select__input\"]/parent::div//input[starts-with(@id,'react-select-')]")
    public WebElement appointmentSearchPatienetInput;

    //Search Input Click field////////////////////////////  

    @FindBy(xpath="//input[@placeholder='Search by patient name, UHID, mobile no...']")
    public WebElement searchInput;

    @FindBy(xpath="//button[@title='Search']//div[@class='flex items-center justify-center w-6 h-6']//*[name()='svg']")
    private WebElement btnSearch;

/////////////////////////////////////////

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
//     By.xpath("//div[contains(@class,'react-select__option')]")));
//     patientCityInput.sendKeys(city);
//     patientCityInput.sendKeys(Keys.ENTER);
// }
    //     waitForVisibility(patientCityInput).clear();
    //     patientCityInput.sendKeys(city);
    //     Thread.sleep(2000); // Wait for the dropdown to update
    //     patientCityInput.sendKeys(Keys.ENTER);
    //     Thread.sleep(4000);
    // }
    public void selectRegAppointmentDoctor(String category) throws Exception{ //With registration
    DropDownUtility.selectReactOption(driver, regwithAppointmentDoctorInput, category);
}
    public void selectAppointmentDoctor(String category) throws Exception{   //without registration
    DropDownUtility.selectReactOption(driver, onlyAppointmentDoctorInput, category);
}
    public void selectBookingDoctor(String category) throws Exception{   //Booking registration
    DropDownUtility.selectReactOption(driver, onlyBookingDoctorInput, category);
}

    public void selectAppointmentVisitType(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, appointmentVisitTypeInput, category);
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
    public void selectAppointmentSearch(String category) throws Exception{
    DropDownUtility.selectReactOption(driver, appointmentSearchPatienetInput, category);
}
//     public void selectAppointmentDepartment(String category) throws Exception{
//     DropDownUtility.selectReactOption(driver, patientDepartmentinput, category);
// }

//Button Methods 
    public void clickSearch() {
        wait.clickElement(btnSearch);
    }
    public void clickBooking() {
        wait.clickElement(btnBookings);
    }
    public void clickAppointment() {
        wait.clickElement(btnAppointment);
    }
    public void clickSwitchtoList() {
        wait.clickElement(btnSwitchtoListDetails);
    }
    public void clickLogInExitLocation() {
        wait.clickElement(logInExitLocation);
    }
    public void clickAllMenuButton() {
        wait.waitForElementClickable(btnAllMenuElement).click();
    }
    //     public void clickPatMngtSave() {
    //      wait.clickElement(btnPatMngtSave);
    // }
    //     public void clickMenuSetup() {
    //     wait.waitForElementClickable(btnSetup).click();
    // }
    //     public void clickMenuSetting() {
    //     wait.waitForElementClickable(btnSetting).click();
    // }
    //     public void clickMenuPatMngmt() {
    //     wait.waitForElementClickable(btnPatManagemnt).click();
    // }
        public void enableRegistrationWithAppointment() {
        switchbutton.setSwitch("Registration With Appointment", true);
    }
    //     public void disableRegistrationWithAppointment() {
    //     switchbutton.setSwitch("Registration With Appointment", false);
    // }
        
    public void clickRegistrationImagebtn() {
        wait.waitForElementClickable(btnRegImgAll).click();
    }

    public void ClickPatientsRegistration() {
        wait.waitForElementClickable(btnClickPatients).click();
    }
    // public void AddPatientClick() {
    //     waitForVisibleElement(btnAddpatient).click();

    // }
    public void AddPatientClick() {
        wait.waitForElementClickable(btnAddpatient).click();
    }
    public void clickSubmit() {
        wait.clickElement(btnSubmit);
    }
    public void clickOtherDetails() {
        wait.clickElement(btnOtherDetails);
    }
    public void clickSameAsCurrentAddress() {
       wait.clickElement(btnSameAsCurrentAddress); 
    }
    //Input Texts Methods 
    public void patientFirstName(String Fname){
        wait.waitForElementVisible(firstNameInput);
        firstNameInput.clear();
        firstNameInput.sendKeys(Fname);
    }
    public void patientGender(String gender){
        wait.waitForElementVisible(patBookingGenderInput);
        patBookingGenderInput.clear();
        patBookingGenderInput.sendKeys(gender);
    }
        public void bookingPatAge(String age){
        wait.waitForElementVisible(patBookingAgeInput);
        patBookingAgeInput.clear();
        patBookingAgeInput.sendKeys(age);
    }
    public void patienttName(String Fname){
        wait.waitForElementVisible(patientNameInput);
        patientNameInput.clear();
        patientNameInput.sendKeys(Fname);
    }
        public void patientLastName(String Lname){
        wait.waitForElementVisible(lastNameInput);
        lastNameInput.clear();
        lastNameInput.sendKeys(Lname);
    }
        public void patientBirthYear(String year){
        wait.waitForElementVisible(patientBirthYearinput);
        patientBirthYearinput.clear();
        patientBirthYearinput.sendKeys(year);
    }
        public void patientmobile(String mobile){
        wait.waitForElementVisible(patientMobileinput);
        patientMobileinput.clear();
        patientMobileinput.sendKeys(mobile);
    }
        public void patientAdress(String adress){
        wait.waitForElementVisible(patient_addressinput);
        patient_addressinput.clear();
        patient_addressinput.sendKeys(adress);
    }
    public void patientEmail(String email){
        wait.waitForElementVisible(patientEmailInput);
        patientEmailInput.clear();
        patientEmailInput.sendKeys(email);
    }
    public void patientEmail1(String email){
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(email);
    }
    public void patientFirstName1(String Fname){
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(Fname);
    }
    public void patientLastName1(String Lname){
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(Lname);
    }
    public void patientBirthYear1(String year){
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(year);
    }
    public void patientMobile(String mobile) {
    wait.waitForElementVisible(searchInput);
    searchInput.clear();
    searchInput.sendKeys(mobile);
}
    //reduce test code Methods 
    public void searchPatient(PatientData patient) throws Exception {
        
        clickSearch();
        
        patientFirstName1(patient.getFirstName());
        
        clickSearch();
        Thread.sleep(2000);

    // Assert.assertEquals(searchPage.getFirstName(), patient.getFirstName(),
    //     "Patient First Name does not match.");

    // patientLastName(patient.getLastName());

    // patientBirthYear(patient.getBirthYear());

    // patientMobile(patient.getMobile());

    // patientEmail1(patient.getEmail());
}
    public void appointmentsDropdown(PatientData patient) throws Exception {

        clickAppointment();

        Thread.sleep(2000);
        
        AddPatientClick();

        selectAppointmentSearch(patient.getFirstName());
        
        selectAppointmentDepartment(patient.getDepartment());

        selectAppointmentUnit(patient.getUnit());

        selectAppointmentDoctor(patient.getDoctor());

        selectAppointmentVisitType(patient.getVisitType());

        clickSubmit();
        
    }
    public void duplicateRegister(PatientData patient) throws Exception {

        AddPatientClick();

        registerPatient(patient);

    // clickSubmit();
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

    // clickSubmit();
}
public void registerBooking(PatientData patient) throws Exception {

        clickBooking();

        Thread.sleep(2000);

        AddPatientClick();

        selectPatientSalutation(patient.getSalutation());
        patienttName(patient.getFirstName());
        bookingPatAge(patient.getAge()); 
        patientGender(patient.getGender());
        patientmobile(patient.getMobile());
        selectAppointmentDepartment(patient.getDepartment());
        selectAppointmentUnit(patient.getUnit());
        selectBookingDoctor(patient.getDoctor());
        clickSubmit();
}
public void patientRegistrationMenu() throws Exception {

        // Thread.sleep(2000);
        // clickAllMenuButton();
        
        // clickMenuSetup();

        // Thread.sleep(2000);
        // clickMenuSetting();

        // Thread.sleep(3000);
        // clickMenuPatMngmt();

        // Thread.sleep(3000);
        // disableRegistrationWithAppointment();

        // clickPatMngtSave();

        clickAllMenuButton();
        clickRegistrationImagebtn();
        ClickPatientsRegistration();

        Thread.sleep(2000);
        AddPatientClick();

}
public void registerWithAppointment(PatientData patient) throws Exception {


    // Thread.sleep(2000);
    // clickAllMenuButton();
        
    // clickMenuSetup();

    // Thread.sleep(2000);
    // clickMenuSetting();

    // Thread.sleep(3000);
    // clickMenuPatMngmt();

    // Thread.sleep(3000);
    // enableRegistrationWithAppointment();

    // clickPatMngtSave();
    // clickAllMenuButton();
    // clickRegistrationImagebtn();
    // ClickPatientsRegistration();

    // Thread.sleep(2000);
    // AddPatientClick();
    Thread.sleep(25000);

    registerPatient(patient);

    selectAppointmentDepartment(patient.getDepartment());
    selectAppointmentUnit(patient.getUnit());
    selectRegAppointmentDoctor(patient.getDoctor());
    // selectAppointmentVisitType(patient.getVisitType());
    // clickSubmit();

}

    public void searchFirstPatient(PatientData patient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
