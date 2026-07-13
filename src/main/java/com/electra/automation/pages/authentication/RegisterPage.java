package com.electra.automation.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @FindBy(xpath="//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement AllMenuElement;

    @FindBy(xpath = "//img[@alt=\"Registrations\"]")
    private WebElement RegImgAll;

    @FindBy(xpath="//span[text()=\"Patients\"]")
    private WebElement ClickPatients;

    @FindBy(xpath="//*[@title=\"Switch to Add\"]")
    private WebElement Addpatient;
//Validation massage
    @FindBy (xpath="//p[text()=\"Applicable Tariff is required.\"]")
    public WebElement firstNameValidation;

    @FindBy (xpath="//p[text()=\"Gender is required.\"]")
    public WebElement genderValidation;

    @FindBy(xpath= "//p[text()=\"Date of Birth is required.\"]")
    public WebElement dobValidation;

    // @FindBy (xpath= "//p[text()="Mobile No is required."]")
    // public WebElement mobileValidation;

    //

    @FindBy(id = "addressError")
    public WebElement addressValidation;

    @FindBy(id = "tariffError")
    public WebElement tariffValidation;

    @FindBy(id = "btnSave")
    public WebElement btnSave;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Given Webelement Access Methods
    public void clickAllMenuButton() {
        AllMenuElement.click();
    }
    public void clickRegistrationImage() {
        RegImgAll.click();
    }
    public void ClickPatientsRegistration() {
        ClickPatients.click();
    }
    public void AddPatientClick() {
        Addpatient.click();
    }

    public void clickSave() {
        btnSave.click();
    }
}
