package com.electra.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchButton {

//     private WebDriver driver;
//     private WebDriverWait wait;

//     public SwitchButton(WebDriver driver) {
//         this.driver = driver;
//         this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//     }

//     private By switchInput(String settingName) {

//         return By.xpath(
//                 "//*[contains(text(),'" + settingName + "')]" +
//                 "//ancestor::div[contains(@class,'space-y-2')]" +
//                 "//input[@role='switch']");
//     }

//     private By switchLabel(String settingName) {

//         return By.xpath(
//                 "//*[contains(text(),'" + settingName + "')]" +
//                 "//ancestor::div[contains(@class,'space-y-2')]" +
//                 "//label");
//     }

//     /**
//      * Turn ON/OFF any switch
//      */
//     public void setSwitch(String settingName, boolean expectedState) {

//         WebElement input = wait.until(
//                 ExpectedConditions.visibilityOfElementLocated(
//                         switchInput(settingName)));

//         WebElement label = wait.until(
//                 ExpectedConditions.elementToBeClickable(
//                         switchLabel(settingName)));

//         boolean currentState = Boolean.parseBoolean(
//                 input.getAttribute("data-checked"));

//         if (currentState != expectedState) {

//             label.click();

//             wait.until(driver ->
//                     Boolean.parseBoolean(
//                             input.getAttribute("data-checked"))
//                             == expectedState);
//         }
//     }

//     /**
//      * Returns current switch status
//      */
//     public boolean isSwitchEnabled(String settingName) {

//         return Boolean.parseBoolean(
//                 driver.findElement(switchInput(settingName))
//                         .getAttribute("data-checked"));
//     }

// }
// public class SwitchButton {

//     private WebDriver driver;
//     private WebDriverWait wait;

//     public SwitchButton(WebDriver driver) {
//         this.driver = driver;
//         this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//     }

//     /**
//      * Find switch input using setting name.
//      *
//      * Example:
//      * Enable Registration
//      * Registration With Appointment
//      * Enable Payments
//      */
//     private By switchInput(String settingName) {

//         return By.xpath(
//             "//div[contains(@class,'space-y-2')]" +
//             "[.//div[@title=\"" + settingName + "\"]]" +
//             "//input[@role='switch']"
//         );
//     }

//     /**
//      * Find switch label using setting name.
//      */
//     private By switchLabel(String settingName) {

//         return By.xpath(
//             "//div[contains(@class,'space-y-2')]" +
//             "[.//div[@title=\"" + settingName + "\"]]" +
//             "//label[contains(@class,'mantine-Switch-body')]"
//         );
//     }

//     /**
//      * Set switch ON/OFF.
//      *
//      * true  = ON
//      * false = OFF
//      */
//     public void setSwitch(String settingName, boolean expectedState) {

//         WebElement input = wait.until(
//             ExpectedConditions.presenceOfElementLocated(
//                 switchInput(settingName)
//             )
//         );

//         boolean currentState = Boolean.parseBoolean(
//             input.getAttribute("data-checked")
//         );

//         System.out.println(
//             "Switch: " + settingName +
//             " | Current: " + currentState +
//             " | Expected: " + expectedState
//         );

//         // Click only when current state is different
//         if (currentState != expectedState) {

//             WebElement label = wait.until(
//                 ExpectedConditions.elementToBeClickable(
//                     switchLabel(settingName)
//                 )
//             );

//             label.click();

//             // Wait until switch reaches expected state
//             wait.until(driver -> {

//                 WebElement updatedInput =
//                     driver.findElement(switchInput(settingName));

//                 boolean actualState = Boolean.parseBoolean(
//                     updatedInput.getAttribute("data-checked")
//                 );

//                 return actualState == expectedState;
//             });
//         }
//     }

//     /**
//      * Get current switch status.
//      *
//      * @return true = ON
//      *         false = OFF
//      */
//     public boolean isSwitchEnabled(String settingName) {

//         WebElement input = wait.until(
//             ExpectedConditions.presenceOfElementLocated(
//                 switchInput(settingName)
//             )
//         );

//         return Boolean.parseBoolean(
//             input.getAttribute("data-checked")
//         );
//     }
// }
// public class SwitchButton {

//     private WebDriver driver;
//     private WebDriverWait wait;

//     public SwitchButton(WebDriver driver) {
//         this.driver = driver;
//         this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//     }

//     /**
//      * Find switch input using setting name.
//      *
//      * Example:
//      * Enable Registration
//      * Registration With Appointment
//      * Enable Payments
//      */
//     private By switchInput(String settingName) {

//         return By.xpath(
//             "//div[contains(@class,'space-y-2')]" +
//             "[.//div[@title=\"" + settingName + "\"]]" +
//             "//input[@role='switch']"
//         );
//     }

//     /**
//      * Find switch label using setting name.
//      */
//     private By switchLabel(String settingName) {

//         return By.xpath(
//             "//div[contains(@class,'space-y-2')]" +
//             "[.//div[@title=\"" + settingName + "\"]]" +
//             "//label[contains(@class,'mantine-Switch-body')]"
//         );
//     }

//     /**
//      * Ensure switch is ON.
//      *
//      * If switch is already ON:
//      *     Do nothing and continue.
//      *
//      * If switch is OFF:
//      *     Click switch, wait until it becomes ON,
//      *     then continue.
//      */
//     public void ensureSwitchOn(String settingName) {

//         WebElement input = wait.until(
//             ExpectedConditions.presenceOfElementLocated(
//                 switchInput(settingName)
//             )
//         );

//         boolean currentState = Boolean.parseBoolean(
//             input.getAttribute("data-checked")
//         );

//         System.out.println(
//             "Switch: " + settingName +
//             " | Current State: " + currentState
//         );

//         // Already ON
//         if (currentState) {

//             System.out.println(
//                 "Switch already ON → Continue"
//             );

//             return;
//         }

//         // Switch is OFF → Turn ON
//         System.out.println(
//             "Switch is OFF → Turning ON"
//         );

//         WebElement label = wait.until(
//             ExpectedConditions.elementToBeClickable(
//                 switchLabel(settingName)
//             )
//         );

//         label.click();

//         // Verify switch is ON
//         wait.until(driver -> {

//             WebElement updatedInput =
//                 driver.findElement(
//                     switchInput(settingName)
//                 );

//             boolean actualState = Boolean.parseBoolean(
//                 updatedInput.getAttribute("data-checked")
//             );

//             return actualState;
//         });

//         System.out.println(
//             "Switch turned ON successfully → Continue"
//         );
//     }

//     /**
//      * Get current switch status.
//      *
//      * @return true  = ON
//      * @return false = OFF
//      */
//     public boolean isSwitchEnabled(String settingName) {

//         WebElement input = wait.until(
//             ExpectedConditions.presenceOfElementLocated(
//                 switchInput(settingName)
//             )
//         );

//         return Boolean.parseBoolean(
//             input.getAttribute("data-checked")
//         );
//     }

//     /**
//      * Turn switch OFF.
//      *
//      * If already OFF, nothing will happen.
//      */
//     public void ensureSwitchOff(String settingName) {

//         WebElement input = wait.until(
//             ExpectedConditions.presenceOfElementLocated(
//                 switchInput(settingName)
//             )
//         );

//         boolean currentState = Boolean.parseBoolean(
//             input.getAttribute("data-checked")
//         );

//         System.out.println(
//             "Switch: " + settingName +
//             " | Current State: " + currentState
//         );

//         // Already OFF
//         if (!currentState) {

//             System.out.println(
//                 "Switch already OFF → Continue"
//             );

//             return;
//         }

//         // Switch is ON → Turn OFF
//         System.out.println(
//             "Switch is ON → Turning OFF"
//         );

//         WebElement label = wait.until(
//             ExpectedConditions.elementToBeClickable(
//                 switchLabel(settingName)
//             )
//         );

//         label.click();

//         // Verify switch is OFF
//         wait.until(driver -> {

//             WebElement updatedInput =
//                 driver.findElement(
//                     switchInput(settingName)
//                 );

//             boolean actualState = Boolean.parseBoolean(
//                 updatedInput.getAttribute("data-checked")
//             );

//             return !actualState;
//         });

//         System.out.println(
//             "Switch turned OFF successfully → Continue"
//         );
//     }

//     /**
//      * Set switch to required state.
//      *
//      * true  = ON
//      * false = OFF
//      *
//      * Use this method only when you specifically
//      * want to control the state.
//      */
//     public void setSwitch(
//             String settingName,
//             boolean expectedState) {

//         WebElement input = wait.until(
//             ExpectedConditions.presenceOfElementLocated(
//                 switchInput(settingName)
//             )
//         );

//         boolean currentState = Boolean.parseBoolean(
//             input.getAttribute("data-checked")
//         );

//         System.out.println(
//             "Switch: " + settingName +
//             " | Current: " + currentState +
//             " | Expected: " + expectedState
//         );

//         // Already in expected state
//         if (currentState == expectedState) {

//             System.out.println(
//                 "Switch already in expected state → Continue"
//             );

//             return;
//         }

//         // Change switch state
//         WebElement label = wait.until(
//             ExpectedConditions.elementToBeClickable(
//                 switchLabel(settingName)
//             )
//         );

//         label.click();

//         // Verify expected state
//         wait.until(driver -> {

//             WebElement updatedInput =
//                 driver.findElement(
//                     switchInput(settingName)
//                 );

//             boolean actualState = Boolean.parseBoolean(
//                 updatedInput.getAttribute("data-checked")
//             );

//             return actualState == expectedState;
//         });

//         System.out.println(
//             "Switch state changed successfully → Continue"
//         );
//     }
// }

    private WebDriver driver;
    private WebDriverWait wait;

    public SwitchButton(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    /**
     * Find switch input using setting name.
     *
     * Example:
     * Enable Registration
     * Registration With Appointment
     * Enable Payments
     */
    private By switchInput(String settingName) {

        return By.xpath(
            "//div[contains(@class,'space-y-2')]" +
            "[.//div[@title=\"" + settingName + "\"]]" +
            "//input[@role='switch']"
        );
    }

    /**
     * Find switch label using setting name.
     */
    private By switchLabel(String settingName) {

        return By.xpath(
            "//div[contains(@class,'space-y-2')]" +
            "[.//div[@title=\"" + settingName + "\"]]" +
            "//label[contains(@class,'mantine-Switch-body')]"
        );
    }

    /**
     * Ensure switch is ON.
     *
     * If switch is already ON:
     *     Do nothing and continue.
     *
     * If switch is OFF:
     *     Click switch, wait until it becomes ON,
     *     then continue.
     */
    public void ensureSwitchOn(String settingName) {

        WebElement input = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                switchInput(settingName)
            )
        );

        boolean currentState = input.isSelected();

        System.out.println(
            "Switch: " + settingName +
            " | Current State: " + currentState
        );

        // Already ON
        if (currentState) {

            System.out.println(
                "Switch already ON → Continue"
            );

            return;
        }

        // Switch is OFF → Turn ON
        System.out.println(
            "Switch is OFF → Turning ON"
        );

        WebElement label = wait.until(
            ExpectedConditions.elementToBeClickable(
                switchLabel(settingName)
            )
        );

        label.click();

        // Verify switch is ON
        wait.until(driver -> {

            WebElement updatedInput =
                driver.findElement(
                    switchInput(settingName)
                );

            return updatedInput.isSelected();
        });

        System.out.println(
            "Switch turned ON successfully → Continue"
        );
    }

    /**
     * Get current switch status.
     *
     * @return true  = ON
     *         false = OFF
     */
    public boolean isSwitchEnabled(String settingName) {

        WebElement input = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                switchInput(settingName)
            )
        );

        return input.isSelected();
    }

    /**
     * Ensure switch is OFF.
     *
     * If switch is already OFF:
     *     Do nothing and continue.
     *
     * If switch is ON:
     *     Click switch, wait until it becomes OFF,
     *     then continue.
     */
    public void ensureSwitchOff(String settingName) {

        WebElement input = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                switchInput(settingName)
            )
        );

        boolean currentState = input.isSelected();

        System.out.println(
            "Switch: " + settingName +
            " | Current State: " + currentState
        );

        // Already OFF
        if (!currentState) {

            System.out.println(
                "Switch already OFF → Continue"
            );

            return;
        }

        // Switch is ON → Turn OFF
        System.out.println(
            "Switch is ON → Turning OFF"
        );

        WebElement label = wait.until(
            ExpectedConditions.elementToBeClickable(
                switchLabel(settingName)
            )
        );

        label.click();

        // Verify switch is OFF
        wait.until(driver -> {

            WebElement updatedInput =
                driver.findElement(
                    switchInput(settingName)
                );

            return !updatedInput.isSelected();
        });

        System.out.println(
            "Switch turned OFF successfully → Continue"
        );
    }

    /**
     * Set switch to required state.
     *
     * true  = ON
     * false = OFF
     *
     * Use this method when you specifically
     * want to control the switch state.
     */
    public void setSwitch(
            String settingName,
            boolean expectedState) {

        WebElement input = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                switchInput(settingName)
            )
        );

        boolean currentState = input.isSelected();

        System.out.println(
            "Switch: " + settingName +
            " | Current: " + currentState +
            " | Expected: " + expectedState
        );

        // Already in expected state
        if (currentState == expectedState) {

            System.out.println(
                "Switch already in expected state → Continue"
            );

            return;
        }

        // Change switch state
        WebElement label = wait.until(
            ExpectedConditions.elementToBeClickable(
                switchLabel(settingName)
            )
        );

        label.click();

        // Verify expected state
        wait.until(driver -> {

            WebElement updatedInput =
                driver.findElement(
                    switchInput(settingName)
                );

            return updatedInput.isSelected()
                    == expectedState;
        });

        System.out.println(
            "Switch state changed successfully → Continue"
        );
    }
}
