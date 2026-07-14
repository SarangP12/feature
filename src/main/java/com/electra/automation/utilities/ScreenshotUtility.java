package com.electra.automation.utilities;

import com.electra.automation.constants.FrameworkConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtility {
    public static void clearScreenshotDirectory() {
        File screenshotDir = new File(FrameworkConstants.SCREENSHOT_PATH);
        try {
            if (screenshotDir.exists()) {
                FileUtils.cleanDirectory(screenshotDir);
            } else {
                Files.createDirectories(screenshotDir.toPath());
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to clear screenshot directory", e);
        }
    }

    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return "";
        }
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = sanitizeFileName(testName) + "_" + timestamp + ".png";
        Path destinationPath = Paths.get(FrameworkConstants.SCREENSHOT_PATH, fileName);
        try {
            Files.createDirectories(destinationPath.getParent());
            FileUtils.copyFile(srcFile, destinationPath.toFile());
            return destinationPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Unable to capture screenshot", e);
        }
    }

    public static String captureFailedElementScreenshot(WebDriver driver, WebElement failedElement, String testName) {
        if (driver == null) {
            return "";
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = sanitizeFileName(testName) + "_" + timestamp + ".png";
        Path destinationPath = Paths.get(FrameworkConstants.SCREENSHOT_PATH, fileName);

        try {
            Files.createDirectories(destinationPath.getParent());

            if (failedElement == null) {
                return captureScreenshot(driver, testName);
            }

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
                    failedElement);

            String originalStyle = (String) js.executeScript(
                    "const element = arguments[0];" +
                            "const previous = element.getAttribute('style') || '';" +
                            "element.style.border = '4px solid yellow';" +
                            "element.style.boxSizing = 'border-box';" +
                            "return previous;",
                    failedElement);

            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotFile, destinationPath.toFile());
            } finally {
                js.executeScript(
                        "const element = arguments[0];" +
                                "const previous = arguments[1];" +
                                "if (previous === '') { element.removeAttribute('style'); } else { element.setAttribute('style', previous); }",
                        failedElement, originalStyle);
            }

            return destinationPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Unable to capture failed element screenshot", e);
        }
    }

    private static String sanitizeFileName(String testName) {
        return testName == null || testName.isBlank()
                ? "screenshot"
                : testName.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
}
