package com.electra.automation.base;

import com.electra.automation.reports.ExtentReportManager;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
}
