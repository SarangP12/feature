package com.electra.automation.reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;

import java.io.File;

public final class ExtentReportManager {
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    private ExtentReportManager() {}

    public static void createTest(String testName) {
        TEST.set(ExtentManager.getInstance().createTest(testName));
    }

    public static ExtentTest getTest() {
        return TEST.get();
    }

    public static void logPass(String message) {
        if (getTest() != null) getTest().pass(message);
    }

    public static void logFail(String message) {
        if (getTest() != null) getTest().fail(message);
    }

    public static void logInfo(String message) {
        if (getTest() != null) getTest().info(message);
    }

    public static void logSkip(String message) {
        if (getTest() != null) getTest().skip(message);
    }

    public static void attachScreenshot(WebDriver driver, String screenshotPath) {
        if (getTest() != null && new File(screenshotPath).exists()) {
            getTest().info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    public static void flush() {
        if (ExtentManager.getInstance() != null) {
            ExtentManager.getInstance().flush();
        }
    }
}
