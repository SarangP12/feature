package com.electra.automation.utilities;

import com.electra.automation.constants.FrameworkConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
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

public static String captureFailedElementScreenshot(
        WebDriver driver,
        WebElement failedElement,
        String testName) {

    if (driver == null) {
        return "";
    }

    String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

    String fileName = sanitizeFileName(testName) + "_" + timestamp + ".png";
    Path destinationPath = Paths.get(FrameworkConstants.SCREENSHOT_PATH, fileName);

    try {

        Files.createDirectories(destinationPath.getParent());

        if (failedElement == null) {
            return captureScreenshot(driver, testName);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Find a visible element to highlight
        WebElement elementToHighlight = failedElement;

        try {

            if (!failedElement.isDisplayed()) {

                // Try visible LABEL
                elementToHighlight = failedElement.findElement(By.xpath("./ancestor::label[1]"));

            }

        } catch (Exception e) {

            try {

                // If no label exists, try nearest visible DIV
                elementToHighlight = failedElement.findElement(By.xpath("./ancestor::div[1]"));

            } catch (Exception ex) {

                // Use original element
                elementToHighlight = failedElement;
            }
        }

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'instant',block:'center'});",
                elementToHighlight);

        String oldStyle = (String) js.executeScript(

                "var e = arguments[0];" +
                "var old = e.getAttribute('style') || '';" +
                "e.style.outline='4px solid red';" +
                "e.style.backgroundColor='rgba(255,255,0,0.35)';" +
                "e.style.boxShadow='0 0 10px red';" +
                "return old;",

                elementToHighlight);

        Thread.sleep(500);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, destinationPath.toFile());

        js.executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                elementToHighlight,
                oldStyle);

        return destinationPath.toString();

    } catch (Exception e) {

        e.printStackTrace();

        return captureScreenshot(driver, testName);
    }
}
//     public static String captureFailedElementScreenshot(WebDriver driver, WebElement failedElement, String testName) throws Exception {
//         if (driver == null) {
//             return "";
//         }

//         String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
//         String fileName = sanitizeFileName(testName) + "_" + timestamp + ".png";
//         Path destinationPath = Paths.get(FrameworkConstants.SCREENSHOT_PATH, fileName);

//         try {
//             Files.createDirectories(destinationPath.getParent());

//             if (failedElement == null) {
//                 return captureScreenshot(driver, testName);
//             }

//             JavascriptExecutor js = (JavascriptExecutor) driver;
//             // js.executeScript(
//             //         "arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
//             //         failedElement);
//     //Upper code not working properly, so changed to below code
//             try {
//     js.executeScript(
//         "arguments[0].scrollIntoView({block:'center'});",
//         failedElement
//  );
// }
// catch(Exception e){
//     return captureScreenshot(driver,testName);
// }

//         String originalStyle = (String) js.executeScript(
//                 "var element = arguments[0];" +
//                 "var previous = element.getAttribute('style') || '';" +
//                 "element.style.outline='4px solid red';" +
//                 "element.style.backgroundColor='rgba(255,255,0,0.3)';" +
//                 "return previous;",
//                 failedElement);

//                     Thread.sleep(500); // Wait for the style to be applied before taking the screenshot

//             try {
//                 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                 FileUtils.copyFile(screenshotFile, destinationPath.toFile());
//             } finally {
//                 js.executeScript(
//                         "var element = arguments[0];" +
//                                 "var previous = arguments[1];" +
//                                 "if (previous === '') { element.removeAttribute('style'); } else { element.setAttribute('style', previous); }",
//                         failedElement, originalStyle);
//             }

//             return destinationPath.toString();
//         } catch (IOException e) {
//             throw new RuntimeException("Unable to capture failed element screenshot", e);
//         }
//     }

    private static String sanitizeFileName(String testName) {
        return testName == null || testName.isBlank()
                ? "screenshot"
                : testName.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
}
