package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.electra.automation.models.PatientData;
import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;

public class OPDPage {

    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;

    //Page Factory constructor
    public OPDPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);
    }
    //Webelement for OPD All Buttons fields

    @FindBy(xpath = "//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement allMenuElementBtn;

    @FindBy(xpath = "//img[@alt=\"OPD\"]")
    private WebElement OPDMenuImgAllElement;

    @FindBy(xpath = "//span[text()=\"Doctor Desk\"]")
    private WebElement doctorDeskMenuElement;

    @FindBy(xpath = "//button[normalize-space()=\"EMR/EHR\"]")
    private WebElement btnOPDEMREHR;

    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    //@FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    // @FindBy(xpath = "//img[@alt=\"OPD\"]")
    // private WebElement btnOPDImgAll;
    //Webelements for OPDPage_ Input Fields
    @FindBy(xpath = "//input[@placeholder=\"Search by name, UHID, mobile, OP/IP no...\"]")
    private WebElement searchPatientInputElement;

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
    // public void clickOPDImagebtn() {
    //     wait.waitForElementClickable(btnOPDImgAll).click();
    // }
    // public void clickOPDImagebtn() {
    //     wait.waitForElementClickable(btnOPDImgAll).click();
    // }

    //Send keys to search patient input field
    public void patientOPDSearch(String address) {
        wait.waitForElementVisible(searchPatientInputElement);
        searchPatientInputElement.clear();
        searchPatientInputElement.sendKeys(address);
    }

    //OPDPage Methods --> OPD test reusable methods
    public void patientOPDMenu() throws Exception {

        clickAllMenuButton();
        clickOPDImagebtn();
        doctorDeskMenuBtn();
        Thread.sleep(2000);
        ;
    }

    public void patientEMREHRRecord(PatientData patient) throws Exception {

        patientOPDMenu();
        patientOPDSearch(patient.getFirstName());
        clickOPDEMREHR();

    }

    // Method assertion for OPDPage can be added here
    //Asertion Methods
    // public String getEnteredFirstName() {
    //     wait.waitForElementVisible(firstNameInput);
    //     return firstNameInput.getDomProperty("value").trim();
    // }
    // Additional methods for OPDPage can be added here
}
