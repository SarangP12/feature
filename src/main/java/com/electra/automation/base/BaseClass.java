package com.electra.automation.base;

import com.electra.automation.pages.authentication.LoginPage;
import com.electra.automation.reports.ExtentReportManager;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.ScreenshotUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class BaseClass {
    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod(alwaysRun = true)
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
    @BeforeMethod(alwaysRun = true)
    @Test(description = "Validates login page loads and login form is visible")
    public void verifyLoginPageLoads() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginFormVisible(), "Login form should be visible");
        loginPage.enterUsername(ConfigReader.getValue("qa.username"));
        loginPage.enterPassword(ConfigReader.getValue("qa.password")); 
        loginPage.clickLogin();
        Thread.sleep(2000); // Wait for login to process
        closeExtraTabs();  // 
}
// Close Extra tab after the Log In 
public void closeExtraTabs() {

    String parentWindow = getDriver().getWindowHandle();

    for (String windowHandle : getDriver().getWindowHandles()) {
        if (!windowHandle.equals(parentWindow)) {
            getDriver().switchTo().window(windowHandle);
            getDriver().close();
        }
    }

    getDriver().switchTo().window(parentWindow);
}

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtility.captureScreenshot(getDriver(), result.getMethod().getMethodName());
            ExtentReportManager.attachScreenshot(getDriver(), screenshotPath);
            ExtentReportManager.logFail(result.getThrowable() != null ? result.getThrowable().getMessage() : "Test failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportManager.logPass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.logSkip("Test skipped");
        }
        if (getDriver() != null) {
            getDriver().quit();
        }
        ExtentReportManager.flush();
    }
// For validation massage check
public void verifyValidationMessage(WebElement element, String expectedMessage) {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    

    String actualMessage = wait.until(ExpectedConditions
            .visibilityOf(element))
            .getText()
            .trim();

    Assert.assertEquals(actualMessage, expectedMessage,
            "Validation message mismatch");
}



}
