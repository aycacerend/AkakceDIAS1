package com.akakce.pages;

import io.appium.java_client.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;



public class BasePage {

    protected AndroidDriver<MobileElement> driver;

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    // Sayfa üzerinde genel bir element bulma metodu
    protected MobileElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Sayfa üzerinde elemente tıklama metodu
    protected void clickElement(By locator) {
        findElement(locator).click();
    }

    // Sayfa üzerinde metin girme metodu
    protected void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }
}
