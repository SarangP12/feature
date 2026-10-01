package com.electra.automation.base;

import com.electra.automation.enums.BrowserType;
import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class DriverFactory {
    static {
        // Selenium's CDP warnings are emitted through JUL, so we raise the JUL
        // threshold before any driver is created.
        configureRootJulLogging();
        configureJulLogging("org.openqa.selenium");
        configureJulLogging("org.openqa.selenium.devtools");
        configureJulLogging("org.openqa.selenium.chromium");
        configureJulLogging("org.openqa.selenium.devtools.CdpVersionFinder");
        configureJulLogging("org.openqa.selenium.chromium.ChromiumDriver");
    }

    private static void configureRootJulLogging() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.SEVERE);
        for (Handler handler : rootLogger.getHandlers()) {
            handler.setLevel(Level.SEVERE);
        }
    }

    private static void configureJulLogging(String loggerName) {
        Logger logger = Logger.getLogger(loggerName);
        logger.setLevel(Level.SEVERE);
    }

    public static WebDriver createDriver(String browserName) {
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        WebDriver delegate = switch (browserType) {
            case CHROME -> createChromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case EDGE -> createEdgeDriver();
        };
        if (!Boolean.parseBoolean(System.getProperty("healenium.enabled", "false"))) {
            return delegate;
        }
        try {
            return SelfHealingDriver.create(delegate);
        } catch (RuntimeException | Error e) {
            try {
                delegate.quit();
            } catch (Exception quitException) {
                e.addSuppressed(quitException);
            }
            throw e;
        }
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        return new EdgeDriver(options);
    }
}
