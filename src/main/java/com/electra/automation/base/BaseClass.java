package com.electra.automation.base;

import com.electra.automation.reports.ExtentReportManager;
import com.electra.automation.utilities.ConfigReader;
import com.electra.automation.utilities.ScreenshotUtility;
import com.electra.automation.utilities.WaitUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.TimeoutException;

public class BaseClass {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
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
    @BeforeSuite(alwaysRun = true)//-----Change @BeforeMethod >> Chage @BeforeClass >> @BeforeSuite(TestNG.XML)
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
        System.out.println("===== Chrome Browser Started =====");
    }

    //Close Browser after test/class execution
    @AfterSuite(alwaysRun = true)//---Change @BeforeMethod >> Chage @BeforeClass >> @BeforeSuite(TestNG.XML)
    public void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        System.out.println("===== Chrome Browser Closed =====");
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

   public void closeExtraTabs() {

    String parentWindow = getDriver().getWindowHandle();

    WebDriverWait wait =
            new WebDriverWait(getDriver(), Duration.ofSeconds(20));

    try {

        // Maximum 20 sec wait karo extra tab ke liye
        wait.until(driver -> driver.getWindowHandles().size() > 1);

    } catch (TimeoutException e) {

        // 20 sec mein extra tab nahi aaya
        // Koi error nahi, next process continue
        return;
    }

    // Ab saare currently opened windows lo
    Set<String> allWindows =
            new HashSet<>(getDriver().getWindowHandles());

    // Saare extra tabs close karo
    for (String windowHandle : allWindows) {

        if (!windowHandle.equals(parentWindow)) {

            getDriver().switchTo().window(windowHandle);
            getDriver().close();
        }
    }

    // Main/parent tab par wapas
    getDriver().switchTo().window(parentWindow);

    // Tabs close hone ke baad 20 sec wait
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
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

}
