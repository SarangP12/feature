package com.electra.automation.listeners;

import com.electra.automation.base.BaseClass;
import com.electra.automation.reports.ExtentReportManager;
import com.electra.automation.utilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.logInfo("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logPass("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseClass baseClass) {
            WebDriver driver = baseClass.getDriver();
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getMethod().getMethodName());
            ExtentReportManager.attachScreenshot(driver, screenshotPath);
        }
        ExtentReportManager.logFail("Test failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.logSkip("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}
