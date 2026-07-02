package com.electra.automation.utilities;

import com.electra.automation.constants.FrameworkConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtility {
    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return "";
        }
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = testName.replaceAll("[^a-zA-Z0-9.-]", "_") + "_" + timestamp + ".png";
        Path destinationPath = Paths.get(FrameworkConstants.SCREENSHOT_PATH, fileName);
        try {
            Files.createDirectories(destinationPath.getParent());
            FileUtils.copyFile(srcFile, destinationPath.toFile());
            return destinationPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Unable to capture screenshot", e);
        }
    }
}
