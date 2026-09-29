package com.electra.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BedUtility {

    // ==========================================================================================
    // BedUtility class is used to select a random available bed from a list of available beds.
    // It waits for the list to be populated and then selects a random bed, clicks on it, and confirms the selection.
//=====================availableElements & confirmButton (Use to perticular Page class )========================

    private WaitUtility wait;
    public BedUtility(WebDriver driver) {
        this.wait = new WaitUtility(driver);
    }

    // Selecting Random Available Bed from the list of available beds
    public void selectRandomAvailable(
            List<WebElement> availableElements,
            WebElement confirmButton) {

        // Wait until at least one bed is available
        wait.waitUntil(() -> !availableElements.isEmpty(), 10);

        int randomIndex = RandomDataUtility.getRandomNumber(
                0,
                availableElements.size() - 1
        );

        WebElement bed = availableElements.get(randomIndex);

        wait.waitForElementClickable(bed);

        String bedNumber =
                bed.findElement(By.tagName("span")).getText();

        System.out.println("Selected Bed : " + bedNumber);

        bed.click();

        wait.waitForElementClickable(confirmButton);
        confirmButton.click();
    }

}
