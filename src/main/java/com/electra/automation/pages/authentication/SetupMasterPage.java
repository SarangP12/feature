package com.electra.automation.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.electra.automation.utilities.SwitchButton;
import com.electra.automation.utilities.WaitUtility;

public class SetupMasterPage {
    
    private WebDriver driver;
    private SwitchButton switchbutton;
    private WaitUtility wait;

//Page Factory constructor
    public SetupMasterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
        switchbutton = new SwitchButton(driver);
        this.wait = new WaitUtility(driver);
    }

    // Click Action button Master
    @FindBy(xpath="//button[@class=\"flex items-center p-1 rounded-lg text-base dark:bg-dark/40 hover:text-teal-500 dark:hover:bg-dark/60 cursor-pointer\"]")
    private WebElement btnAllMenuElement;

    @FindBy(xpath="//li[31]//button[1]")
    public WebElement btnSetup; 

    @FindBy(xpath="//span[text()=\"Settings\"]")
    public WebElement btnSetting;

    @FindBy(xpath="//span[text()=\"Patient Management\"]")
    public WebElement btnPatManagemnt;

    @FindBy(xpath="//button[normalize-space()='Save']")
    public WebElement btnPatMngtSave;

    //Setup Master Page Methods
        public void clickAllMenuButton() {
        wait.waitForElementClickable(btnAllMenuElement).click();
    }
        public void clickPatMngtSave() {
         wait.clickElement(btnPatMngtSave);
    }
        public void clickMenuPatMngmt() {
        wait.waitForElementClickable(btnPatManagemnt).click();
    }
            public void clickMenuSetting() {
        wait.waitForElementClickable(btnSetting).click();
    }
        public void clickMenuSetup() {
        wait.waitForElementClickable(btnSetup).click();
    }
        public void enableRegistrationWithAppointment() {
        switchbutton.setSwitch("Registration With Appointment", true);
    }
        public void disableRegistrationWithAppointment() {
        switchbutton.setSwitch("Registration With Appointment", false);
    }

    public void appointmentTabSwitchDisable() throws Exception {

        Thread.sleep(2000);
        clickAllMenuButton();
        
        clickMenuSetup();

        Thread.sleep(2000);
        clickMenuSetting();

        Thread.sleep(3000);
        clickMenuPatMngmt();

        Thread.sleep(3000);
        disableRegistrationWithAppointment();

        clickPatMngtSave();
    }
    public void appointmentTabSwitchEnable() throws Exception {

    Thread.sleep(2000);
    clickAllMenuButton();
        
    clickMenuSetup();

    Thread.sleep(2000);
    clickMenuSetting();

    Thread.sleep(3000);
    clickMenuPatMngmt();

    Thread.sleep(3000);
    enableRegistrationWithAppointment();

    clickPatMngtSave();

    }

}
