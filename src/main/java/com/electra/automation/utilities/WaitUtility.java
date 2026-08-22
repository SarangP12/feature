package com.electra.automation.utilities;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.BooleanSupplier;

public class WaitUtility {

    private final WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 80;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // By Locator Methods
    // ==========================
    public WebElement waitForElementVisible(By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementPresent(By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // ==========================
    // WebElement Methods
    // ==========================
    public WebElement waitForElementVisible(WebElement element, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Default timeout methods
    public WebElement waitForElementVisible(WebElement element) {
        return waitForElementVisible(element, DEFAULT_TIMEOUT);
    }

    public WebElement waitForElementClickable(WebElement element) {
        return waitForElementClickable(element, DEFAULT_TIMEOUT);
    }

    // Wait until element is clickable
    // Used before click action
    public WebElement waitForClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait until element disappears
    // Used for loader/spinner/popup
    public boolean waitForInvisibility(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // ==========================
    // Click Methods
    // ==========================
    public void clickElement(WebElement element) {
        clickElement(element, DEFAULT_TIMEOUT);
    }

    public void clickElement(WebElement element, int timeoutSeconds) {
        try {
            waitForElementClickable(element, timeoutSeconds).click();
        } catch (Exception e) {
            waitForElementVisible(element, timeoutSeconds);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    // ==========================
    // Text Methods
    // ==========================
    public void enterText(WebElement element, String text) {
        enterText(element, text, DEFAULT_TIMEOUT);
    }

    public void enterText(WebElement element, String text, int timeoutSeconds) {
        waitForElementVisible(element, timeoutSeconds);
        element.clear();
        element.sendKeys(text);
    }

    // ==========================
    // Custom Fluent Wait
    // ==========================
    public <T> T waitForCondition(Function<WebDriver, T> condition, int timeoutSeconds) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500));

        return fluentWait.until(condition);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    // Wait until element is visible
    // Used for reading text, validation messages, typing fields
    public WebElement waitForVisibility(WebElement element) {

        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntil(BooleanSupplier condition, int timeoutSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        wait.until(d -> {
            try {
                return condition.getAsBoolean();
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        });
    }

    // Wait until page loading is complete
    public void waitForPageLoad() {

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(d
                        -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
                );
    }
    // Wait until element disappears using By locator

    public boolean waitForInvisibility(By locator, int timeoutSeconds) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutSeconds)
        ).until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    public boolean waitForInvisibility(By locator) {
        return waitForInvisibility(locator, DEFAULT_TIMEOUT);
    }

}
