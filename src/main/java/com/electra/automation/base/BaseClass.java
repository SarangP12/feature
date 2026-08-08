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
        // initialize WaitUtility for this driver
        this.wait = new WaitUtility(driver);
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

        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        // Wait until more than one window is opened
        webDriverWait.until(driver -> driver.getWindowHandles().size() > 1);

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
        switch (result.getStatus()) {
            case ITestResult.FAILURE -> {
                String screenshotPath = ScreenshotUtility.captureFailedElementScreenshot(
                        getDriver(),
                        getFailedElement(),
                        result.getMethod().getMethodName());
                ExtentReportManager.attachScreenshot(getDriver(), screenshotPath);
                Throwable throwable = result.getThrowable();
                String failureMessage = throwable != null ? throwable.getMessage() : "Test failed";
                ExtentReportManager.logFail(failureMessage);
            }
            case ITestResult.SUCCESS ->
                ExtentReportManager.logPass("Test passed");
            case ITestResult.SKIP ->
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
// Assertion method for validation messages / displayed text
    public void verifyElement(WebElement element,
            String expectedMessage,
            boolean verifyText) {

        WebElement visibleElement = this.wait.waitForVisibility(element);

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

    public void verifyAmount(WebElement amountElement, double expectedAmount) {
        WebElement visibleElement = this.wait.waitForVisibility(amountElement);
        Assert.assertTrue(visibleElement.isDisplayed(), "Amount element is not displayed.");
        String actualText = visibleElement.getText().trim().replace("₹", "").replace(",", "").trim();
        double actualAmount = Double.parseDouble(actualText);
        Assert.assertEquals(actualAmount, expectedAmount, 0.01, "Amount verification failed. Expected: [" + expectedAmount + "] but Actual: [" + actualAmount + "]");
    }

// Assertion method for input field values
    public void verifyInputValue(WebElement element, String expectedValue) {

        WebElement visibleElement = this.wait.waitForVisibility(element);

        Assert.assertTrue(
                visibleElement.isDisplayed(),
                "Input element is not displayed."
        );

        String actualValue = visibleElement.getDomProperty("value").trim();

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Input value verification failed. Expected: ["
                + expectedValue
                + "] but actual value was: ["
                + actualValue
                + "]"
        );
    }

    public void verifyToastMessage(WebElement toastElement, String expectedMessage) {
        WebElement visibleToast = this.wait.waitForVisibility(toastElement);
        Assert.assertTrue(visibleToast.isDisplayed(), "Toast message is not displayed.");
        String actualMessage = visibleToast.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "Toast message verification failed. Expected: [" + expectedMessage + "] but Actual: [" + actualMessage + "]");
    }

}
