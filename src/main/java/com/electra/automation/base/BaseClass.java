package com.electra.automation.base;
import com.electra.automation.reports.ExtentReportManager;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.ScreenshotUtility;
import com.electra.automation.utilities.WaitUtility;

// import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

import java.time.Duration;


public class BaseClass {
    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private final ThreadLocal<WebElement> failedElementThreadLocal = new ThreadLocal<>();

    private WaitUtility wait;

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    protected WebElement getFailedElement() {
        return failedElementThreadLocal.get();
    }

    protected void markFailedElement(WebElement element) {
        failedElementThreadLocal.set(element);
    }

    protected void clearFailedElement() {
        failedElementThreadLocal.remove();
    }

    @BeforeSuite(alwaysRun = true)
    public void cleanOldScreenshots() {
        ScreenshotUtility.clearScreenshotDirectory();
    }

    public void click(WebElement element) {
    wait.waitForElementClickable(element).click();
    }

//  // Wait until element is visible [When you want to read text, verify validation messages, or type into a field]
//     public WebElement waitForVisibility(WebElement element) {
//         return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
//                 .until(ExpectedConditions.visibilityOf(element));
//     }
// // Wait until element is clickable [Before clicking a button, link, dropdown, checkbox, radio button]
//     public WebElement waitForClickable(WebElement element) {
//         return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
//                 .until(ExpectedConditions.elementToBeClickable(element));
//     }
// // Wait until element disappears [Wait for a loader/spinner or popup to disappear]
//     public boolean waitForInvisibility(WebElement element) {
//         return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
//                 .until(ExpectedConditions.invisibilityOf(element));
//     }
// // Wait until page loading is complete [After navigation or page refresh]
//     public void waitForPageLoad() {
//         new WebDriverWait(getDriver(), Duration.ofSeconds(20))
//                 .until(driver -> ((JavascriptExecutor) driver)
//                 .executeScript("return document.readyState")
//                 .equals("complete"));
//     }

//Browser Method Define
    @BeforeClass(alwaysRun = true)//--------------------Change BeforeMethod
    @Parameters({"browser", "environment"})
    public void setUp(@Optional("chrome") String browser, @Optional("qa") String environment) {
        WebDriver driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(ConfigReader.getValue("base.url"));
        driverThreadLocal.set(driver);
        ExtentReportManager.createTest(getClass().getSimpleName() + " :: " + browser);
    }

// // Agar exactly 2 seconds baad close karna hai
// public void closeExtraTabs() {

//     WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

//     // Wait until new tab opens
//     wait.until(driver -> driver.getWindowHandles().size() > 1);

//     // Keep the tab open for 2 seconds
//     try {
//         Thread.sleep(2000);
//     } catch (InterruptedException e) {
//         Thread.currentThread().interrupt();
//     }

//     String parentWindow = getDriver().getWindowHandle();

//     for (String windowHandle : getDriver().getWindowHandles()) {

//         if (!windowHandle.equals(parentWindow)) {

//             getDriver().switchTo().window(windowHandle);
//             getDriver().close();
//         }
//     }

//     getDriver().switchTo().window(parentWindow);
// }

//Immediatly remove new open tab 
public void closeExtraTabs() {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

    // Wait until more than one window is opened
    wait.until(driver -> driver.getWindowHandles().size() > 1);

    String parentWindow = getDriver().getWindowHandle();

    for (String windowHandle : getDriver().getWindowHandles()) {

        if (!windowHandle.equals(parentWindow)) {

            getDriver().switchTo().window(windowHandle);
            getDriver().close();
        }
    }

    getDriver().switchTo().window(parentWindow);
}
// Captured Screenshot for failed test cases
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE){
            String screenshotPath = ScreenshotUtility.captureFailedElementScreenshot(
                    getDriver(),
                    getFailedElement(),
                    result.getMethod().getMethodName());
            ExtentReportManager.attachScreenshot(getDriver(), screenshotPath);
            ExtentReportManager.logFail(result.getThrowable() != null ? result.getThrowable().getMessage() : "Test failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportManager.logPass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.logSkip("Test skipped");
        }
        clearFailedElement();
        ExtentReportManager.clearTest();
    }
    //Close Browser after test/class execution
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
    if (getDriver() != null) {
        getDriver().quit();
    }
}
// // Reusable methods Validation massages for all Assertion 
//     public void verifyElement(WebElement element,
//                           String expectedMessage,
//                           boolean verifyText) {
//         WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

//     WebElement visibleElement = wait.until(
//             ExpectedConditions.visibilityOf(element));

//     // Verify element is displayed
//     Assert.assertTrue(
//             visibleElement.isDisplayed(),
//             "Element is not displayed.");

//     // Verify text only when required
//     if (verifyText) {

//         String actualText = visibleElement.getText().trim();

//         Assert.assertEquals(
//                 actualText,
//                 expectedMessage,
//                 "Text verification failed.");
//     }
// }

public void verifyElement(WebElement element,
                          String expectedMessage,
                          boolean verifyText) {

    WaitUtility wait = new WaitUtility(getDriver());

    WebElement visibleElement = wait.waitForVisibility(element);

    // Verify element is displayed
    Assert.assertTrue(
            visibleElement.isDisplayed(),
            "Element is not displayed."
    );

    // Verify text only when required
    if (verifyText) {

        Assert.assertEquals(
                visibleElement.getText().trim(),
                expectedMessage,
                "Text verification failed."
        );
    }
}

}
