package com.akakce.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekleme süresi
    }

    // Elementi bulunana kadar bekler ve geri döner
    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Buton tıklamak için yardımcı metod
    protected void clickElement(By locator) {
        WebElement element = waitForElement(locator);
        element.click();
    }

    // Text kutularını veya metinleri doğrulamak için metod
    protected String getElementText(By locator) {
        WebElement element = waitForElement(locator);
        return element.getText();
    }

    // Elementi görünür olana kadar bekleyip bir metin girmek için yardımcı metod
    protected void sendKeysToElement(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.sendKeys(text);
    }

    // Elementin varlığını doğrulamak için yardımcı metod
    protected boolean isElementDisplayed(By locator) {
        WebElement element = waitForElement(locator);
        return element.isDisplayed();
    }
}
