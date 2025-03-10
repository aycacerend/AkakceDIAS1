package com.akakce.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private AndroidDriver driver;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        WebElement searchBox = driver.findElement(AppiumBy.id("com.akakce:id/search_box"));
        searchBox.click();
        searchBox.sendKeys(productName);
        driver.findElement(AppiumBy.id("com.akakce:id/search_button")).click();
    }

    public void selectCategory(String categoryName) {
        WebElement category = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + categoryName + "\")"));
        category.click();
    }
}
