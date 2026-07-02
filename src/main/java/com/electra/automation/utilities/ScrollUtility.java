package com.electra.automation.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtility {
    private final JavascriptExecutor js;

    public ScrollUtility(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
