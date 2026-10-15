package com.electra.automation.utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxUtility {

    private WebDriver driver;

    private WaitUtility waitUtility;

    public CheckboxUtility(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
    }

    /**
     * Check checkbox using WebElement (@FindBy)
     */
    public void checkCheckbox(WebElement checkbox) {

        WebElement element
                = waitUtility.waitForElementClickable(checkbox, 10);

        String checkedState = element.getAttribute("aria-checked");

        if ("false".equalsIgnoreCase(checkedState)) {
            element.click();
        } else if (checkedState == null && !element.isSelected()) {
            element.click();
        }
    }

    /**
     * Uncheck checkbox using WebElement (@FindBy)
     */
    public void uncheckCheckbox(WebElement checkbox) {

        WebElement element
                = waitUtility.waitForElementClickable(checkbox, 10);

        String checkedState = element.getAttribute("aria-checked");

        if ("true".equalsIgnoreCase(checkedState)) {
            element.click();
        } else if (checkedState == null && element.isSelected()) {
            element.click();
        }
    }

    /**
     * Set checkbox state using WebElement
     */
    public void setCheckboxState(
            WebElement checkbox, boolean requiredState) {

        if (requiredState) {
            checkCheckbox(checkbox);
        } else {
            uncheckCheckbox(checkbox);
        }
    }

}
