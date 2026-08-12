package com.electra.automation.pages.authentication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.electra.automation.base.BaseClass;
import com.electra.automation.models.PatientData;
import com.electra.automation.utilities.DropDownUtility;
import com.electra.automation.utilities.RandomDataUtility;
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;

public class RegisterPage extends BaseClass {

    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;
    private DropDownUtility dropDownUtility;


    //Page Factory constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        switchbutton = new SwitchButton(driver);
        this.dropDownUtility = new DropDownUtility(driver);
        this.wait = new WaitUtility(driver);
    }
    // Click Action button Master
    @FindBy(xpath = "//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement btnAllMenuElement;

    @FindBy(xpath = "//img[@alt=\"Registrations\"]")//img[@alt="OPD"]
    private WebElement btnRegImgAll;

    @FindBy(xpath = "//span[text()=\"Patients\"]")
    private WebElement btnClickPatients;

    @FindBy(xpath = "//div[@class=\"content-center\"]//label[@class=\"inline-flex items-center cursor-pointer\"]")
    private WebElement btnClickEmergency;

    //Validation message
    @FindBy(xpath = "//p[text()=\"First Name is required.\"]")
    public WebElement firstNameValidation;

    @FindBy(xpath = "//p[text()=\"Gender is required.\"]")
    public WebElement genderValidation;

    @FindBy(xpath = "//p[text()=\"Date of Birth is required.\"]")
    public WebElement dobValidation;

    @FindBy(xpath = "//p[text()=\"Mobile No is required.\"]")
    public WebElement mobileValidation;

    @FindBy(xpath = "//p[text()=\"Address is required.\"]")
    public WebElement addressValidation;

    @FindBy(xpath = "//p[text()=\"Applicable Tariff is required.\"]")
    public WebElement tariffValidation;

    // All Action Btton 
    @FindBy(xpath = "//*[@title=\"Switch to Add\"]")
    public WebElement btnAddpatient;

    @FindBy(xpath = "//*[name()='button' and contains(@class,'bg-[#00aab')]")
    public WebElement btnElementToastOK;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement btnSubmit;

    @FindBy(xpath = "//button[normalize-space()='Other Details']")
    public WebElement btnOtherDetails;

    @FindBy(xpath = "//div[@class=\"w-4 h-4 rounded-sm border-2 border-gray-300 flex items-center justify-center transition-all duration-300 ease-in-out peer-checked:border-[#476cb7] peer-checked:bg-green-500 peer-checked:scale-110 peer-focus:ring-2 peer-focus:ring-green-300\"]")
    public WebElement btnSameAsCurrentAddress;

    @FindBy(xpath = "//button[@title='Switch to List']//div[@class='flex items-center justify-center w-6 h-6']//*[name()='svg']")
    public WebElement btnSwitchtoListDetails;

    @FindBy(xpath = "//a[@href=\"/registrations/c3111952-6888-461d-9e90-7d6cd5067299\"]")
    public WebElement btnAppointment;

    @FindBy(xpath = "//span[text()=\"Bookings\"]")
    public WebElement btnBookings;

    // All Text fields 
    @FindBy(xpath = "//input[@id=\"patient_category_type\"]")
    public WebElement patientCatTypeDropdown;

    @FindBy(xpath = "(//input[@id='patient_category_id'])[1]")
    public WebElement patientCatIdDropdown;

    @FindBy(xpath = "(//input[starts-with(@id,'react-select-')])[1]")
    public WebElement patientTariffDropdown;

    @FindBy(xpath = "//input[@id=\"salutation\"]")
    public WebElement patientsalutationDropdown;

    @FindBy(xpath = "//label[normalize-space()='City']/parent::div//input[starts-with(@id,'react-select-')][1]")  //city dropdown
    public WebElement patientCityInput; //label[normalize-space()='City']/parent::div//input[starts-with(@id,'react-select-')][1]

    @FindBy(xpath = "(//input[starts-with(@id,'react-select-')])[3]")  //Register with Appointment Doctor Dropdown
    public WebElement regwithAppointmentDoctorInput;

    @FindBy(xpath = "(//input[starts-with(@id,'react-select-')])[2]")   //Seperate Appointment Doctor Dropdown 
    public WebElement onlyAppointmentDoctorInput;

    @FindBy(xpath = "(//input[starts-with(@id,'react-select-')])[1]")   //Seperate Booking Doctor Dropdown 
    public WebElement onlyBookingDoctorInput;

    @FindBy(xpath = "//input[@id=\"visit_type\"]")
    public WebElement appointmentVisitTypeInput;

    @FindBy(xpath = "//input[@id=\"first_name\"]")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"patient_name\"]")
    public WebElement patientNameInput;

    @FindBy(xpath = "//input[@id=\"last_name\"]")
    public WebElement lastNameInput;

    @FindBy(xpath = "//*[name()='input' and contains(@placeholder,'Y')]")
    public WebElement patientBirthYearinput;

    @FindBy(xpath = "//input[@type=\"tel\"]")
    public WebElement patientMobileinput;

    @FindBy(xpath = "//*[name()='input' and @id='file_path']")
    public WebElement patientImageinput;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement patientEmailInput;

    @FindBy(xpath = "//*[name()='input' and @id='current_address']")
    public WebElement patient_addressinput;

    @FindBy(xpath = "//label[@for='department_id']/parent::div//input[starts-with(@id,'department_id')]")
    public WebElement patientDepartmentinput;

    @FindBy(xpath = "//input[@id=\"unit_id\"]")
    public WebElement patientUnitinput;

    @FindBy(xpath = "//input[@id=\"languages_known\"]")
    public WebElement regLanguageInput;

    @FindBy(xpath = "//input[@id=\"nationality\"]")
    public WebElement patientNationalityInput;

    @FindBy(xpath = "//input[@id=\"religion\"]")
    public WebElement patientReligionInput;

    @FindBy(xpath = "//input[@id=\"age\"]")
    public WebElement patBookingAgeInput;

    @FindBy(xpath = "//input[@id=\"gender\"]")
    public WebElement patBookingGenderInput;

    @FindBy(xpath = "//div[@class=\"react-select__input-container css-1deasmo\"]//input[@class=\"react-select__input\"]/parent::div//input[starts-with(@id,'react-select-')]")
    public WebElement appointmentSearchPatienetInput;

    @FindBy(xpath = "//input[@id=\"next_to_kin\"]")
    public WebElement patEMRNextToKinInput;

    @FindBy(xpath = "//input[@id=\"kins_relation\"]")
    public WebElement patEMRKinsRelationInput;

    @FindBy(xpath = "//input[@id=\"kins_contact\"]")
    public WebElement patEMRKinsContactInput;

    @FindBy(xpath = "//input[@id=\"kins_address\"]")
    public WebElement patEMRKinsAdressInput;

    @FindBy(xpath = "//input[@id=\"emergency_contact_no\"]")
    public WebElement patEMRKinsContactNumberInput;

    //Search Input Click field////////////////////////////  
    @FindBy(xpath = "//input[@placeholder='Search by patient name, UHID, mobile no...']")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@title='Search']//div[@class='flex items-center justify-center w-6 h-6']//*[name()='svg']")
    private WebElement btnSearch;

    /////////////////////////////////////////

    @FindBy(xpath = "//button[@class='shrink-0 p-1 rounded-full transition-colors hover:bg-gray-100 dark:hover:bg-gray-800 text-gray-500']//*[name()='svg']")
    public WebElement logInExitLocation;

    //Assertion element Or Pop Up element ( Toast react PopUpUp)
    @FindBy(xpath = "//span[text()=\"Patient Info\"]")
    public WebElement PatientInfoPage;

    @FindBy(xpath = "//div[text()=\"Patient already exists\"]")
    public WebElement PatientDuplicateToast;

    /////////////////////////////////////////////////
    /// Locate all element in the lists 
    @FindBy(xpath = "//button[not(@disabled) and .//div[normalize-space()='Available']]")
    private List<WebElement> availableSlots;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[@class='appointment-success']")
    private WebElement successMessage;

    //Given is Webelement Access Methods 
    // Dropdown Selection Methods - React option selection define in the DropDown Utility class
    public void patientEMRKinsRelation(String relation) throws Exception {
        dropDownUtility.selectReactOption(patEMRKinsRelationInput, relation);
    }

    public void selectPatientCategoryType(String category) throws Exception {
        dropDownUtility.selectReactOption(patientCatTypeDropdown, category);
    }

    public void selectPatientCategoryID(String category) throws Exception {
        dropDownUtility.selectReactOption(patientCatIdDropdown, category);
        // DropDownUtility.selectReactOption(driver, patientCatIdDropdown, category);
    }

    public void selectPatientTariff(String category) throws Exception {
        dropDownUtility.selectReactOption(patientTariffDropdown, category);
    }

    public void selectPatientSalutation(String category) throws Exception {
        dropDownUtility.selectReactOption(patientsalutationDropdown, category);
    }

    public void selectPatientCity(String city) throws Exception {
        patientCityInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        patientCityInput.sendKeys(city);
    }

    //String listBoxId = patientCityInput.getAttribute("aria-controls");
    // String listBoxId = patientCityInput.getDomAttribute("aria-controls");
    // String prefix = listBoxId.replace("-listbox", "");
    // By option = By.xpath("//div[contains(@id,'-option-') and normalize-space()='" + city + "']");
    // wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    public void selectRegAppointmentDoctor(String category) throws Exception { //With registration
        dropDownUtility.selectReactOption(regwithAppointmentDoctorInput, category);
    }

    public void selectAppointmentDoctor(String category) throws Exception {   //without registration
        dropDownUtility.selectReactOption(onlyAppointmentDoctorInput, category);
    }

    public void selectBookingDoctor(String category) throws Exception {   //Booking registration
        dropDownUtility.selectReactOption(onlyBookingDoctorInput, category);
    }

    public void selectAppointmentVisitType(String category) throws Exception {
        dropDownUtility.selectReactOption(appointmentVisitTypeInput, category);
    }

    public void selectAppointmentDepartment(String category) throws Exception {
        dropDownUtility.selectReactOption(patientDepartmentinput, category);
    }

    public void selectAppointmentUnit(String category) throws Exception {
        // DropDownUtility.selectReactOption(driver, patientUnitinput, category);
        dropDownUtility.selectReactOption(patientUnitinput, category);
    }

    public void selectRegLanguage(String category) throws Exception {
        dropDownUtility.selectReactOption(regLanguageInput, category);
    }

    public void selectPatientNationality(String category) throws Exception {
        dropDownUtility.selectReactOption(patientNationalityInput, category);
    }

    public void selectPatientReligion(String category) throws Exception {
        dropDownUtility.selectReactOption(patientReligionInput, category);
    }

    public void selectAppointmentSearch(String category) throws Exception {
        dropDownUtility.selectReactOption(appointmentSearchPatienetInput, category);
    }
//Button Methods 

    public void clickSearch() {
        // wait.clickElement(btnSearch);
        wait.waitForElementClickable(btnSearch).click();
    }

    public void clickCheckboxEmergency() {
        wait.waitForElementClickable(btnClickEmergency).click();
    }

    public void clickBooking() {
        // wait.clickElement(btnBookings);
        wait.waitForElementClickable(btnBookings).click();
    }

    public void clickAppointment() {
        // wait.clickElement(btnAppointment);
        wait.waitForElementClickable(btnAppointment).click();
    }

    public void clickSwitchtoList() {
        // wait.clickElement(btnSwitchtoListDetails);
        wait.waitForElementClickable(btnSwitchtoListDetails).click();
    }

    public void clickLogInExitLocation() {
        // wait.clickElement(logInExitLocation);
        wait.waitForElementClickable(logInExitLocation).click();
    }

    public void clickAllMenuButton() {
        wait.waitForElementClickable(btnAllMenuElement).click();
    }

    public void enableRegistrationWithAppointment() {
        switchbutton.setSwitch("Registration With Appointment", true);
    }

    public void clickRegistrationImagebtn() {
        wait.waitForElementClickable(btnRegImgAll).click();
    }

    public void ClickPatientsRegistration() {
        wait.waitForElementClickable(btnClickPatients).click();
    }

    public void clickConfirm() {
        wait.waitForElementClickable(confirmButton).click();

    }

    public void AddPatientClick() {
        wait.waitForElementClickable(btnAddpatient).click();
    }

    public void clickSubmit() {
        // wait.clickElement(btnSubmit);
        wait.waitForElementClickable(btnSubmit).click();
    }

    public void clickOtherDetails() {
        // wait.clickElement(btnOtherDetails);
        wait.waitForElementClickable(btnOtherDetails).click();
    }

    public void clickSameAsCurrentAddress() {
        //    wait.clickElement(btnSameAsCurrentAddress);
        wait.waitForElementClickable(btnSameAsCurrentAddress).click();
    }

    //Input Texts Methods 
    public void patientFirstName(String Fname) {
        wait.waitForElementVisible(firstNameInput);
        firstNameInput.clear();
        firstNameInput.sendKeys(Fname);
    }

    public void patientGender(String gender) {
        wait.waitForElementVisible(patBookingGenderInput);
        patBookingGenderInput.clear();
        patBookingGenderInput.sendKeys(gender);
    }

    public void bookingPatAge(String age) {
        wait.waitForElementVisible(patBookingAgeInput);
        patBookingAgeInput.clear();
        patBookingAgeInput.sendKeys(age);
    }

    public void patienttName(String Fname) {
        wait.waitForElementVisible(patientNameInput);
        patientNameInput.clear();
        patientNameInput.sendKeys(Fname);
    }

    public void patientLastName(String Lname) {
        wait.waitForElementVisible(lastNameInput);
        lastNameInput.clear();
        lastNameInput.sendKeys(Lname);
    }

    public void patientBirthYear(String year) {
        wait.waitForElementVisible(patientBirthYearinput);
        patientBirthYearinput.clear();
        patientBirthYearinput.sendKeys(year);
    }

    public void patientmobile(String mobile) {
        wait.waitForElementVisible(patientMobileinput);
        patientMobileinput.clear();
        patientMobileinput.sendKeys(mobile);
    }

    public void patientAdress(String adress) {
        wait.waitForElementVisible(patient_addressinput);
        patient_addressinput.clear();
        patient_addressinput.sendKeys(adress);
    }

    public void patientEmail(String email) {
        wait.waitForElementVisible(patientEmailInput);
        patientEmailInput.clear();
        patientEmailInput.sendKeys(email);
    }

    public void patientEmail1(String email) {
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(email);
    }

    public void patientFirstName1(String Fname) {
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(Fname);
    }

    public void patientLastName1(String Lname) {
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(Lname);
    }

    public void patientBirthYear1(String year) {
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(year);
    }

    public void patientMobile(String mobile) {
        wait.waitForElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(mobile);
    }

    public void patientEMRNextToKin(String kin) {
        wait.waitForElementVisible(patEMRNextToKinInput);
        patEMRNextToKinInput.clear();
        patEMRNextToKinInput.sendKeys(kin);
    }

    public void patientEMRKinsContact(String contact) {
        wait.waitForElementVisible(patEMRKinsContactInput);
        patEMRKinsContactInput.clear();
        patEMRKinsContactInput.sendKeys(contact);
    }

    public void patientEMRKinsAddress(String address) {
        wait.waitForElementVisible(patEMRKinsAdressInput);
        patEMRKinsAdressInput.clear();
        patEMRKinsAdressInput.sendKeys(address);
    }

    public void patientKinsContactNumber(String contactNumber) {
        wait.waitForElementVisible(patEMRKinsContactNumberInput);
        patEMRKinsContactNumberInput.clear();
        patEMRKinsContactNumberInput.sendKeys(contactNumber);
    }
//Click on the Registration Menu and open the Patient Registration Page

    public void patientRegistrationMenu() throws Exception {

        clickAllMenuButton();
        clickRegistrationImagebtn();
        ClickPatientsRegistration();
        Thread.sleep(2000);
        AddPatientClick();
    }

// Selecting Random Available Slot from the list of available slots
    public void selectRandomAvailableSlot() {

        // Wait until at least one slot is available
        wait.waitUntil(() -> !availableSlots.isEmpty(), 10);

        int randomIndex = RandomDataUtility.getRandomNumber(0, availableSlots.size() - 1);

        WebElement slot = availableSlots.get(randomIndex);

        wait.waitForElementClickable(slot);

        String slotTime = slot.findElement(By.tagName("span")).getText();

        System.out.println("Selected Slot : " + slotTime);

        slot.click();

        wait.waitForElementClickable(confirmButton);
        confirmButton.click();
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

        Thread.sleep(10000);

        selectRandomAvailableSlot();

        // clickConfirm();
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

    public void registerWithAppointment(PatientData patient) throws Exception {

        Thread.sleep(25000);

        registerPatient(patient);

        selectAppointmentDepartment(patient.getDepartment());
        selectAppointmentUnit(patient.getUnit());
        selectRegAppointmentDoctor(patient.getDoctor());

    }

    public void registerWithEmergency(PatientData patient) throws Exception {

        patientRegistrationMenu();
        Thread.sleep(2500);
        // clickCheckboxEmergency();
        selectPatientCategoryType(patient.getCategoryType());

        selectPatientCategoryID(patient.getCategoryID());

        selectPatientTariff(patient.getTariff());

        clickCheckboxEmergency();

        Thread.sleep(2500);

        selectPatientSalutation(patient.getSalutation());

        patientBirthYear(patient.getBirthYear());

        patientmobile(patient.getMobile());

        patientEMRNextToKin(patient.getNextToKin());
        patientEMRKinsRelation(patient.getKinsRelation());
        patientEMRKinsContact(patient.getKinsContact());
        patientEMRKinsAddress(patient.getKinsAddress());
        patientKinsContactNumber(patient.getKinsContactNumber());

    }
//Asertion Methods

    public String getEnteredFirstName() {
        wait.waitForElementVisible(firstNameInput);
        return firstNameInput.getDomProperty("value").trim();
    }
}
