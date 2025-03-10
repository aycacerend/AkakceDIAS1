package com.akakce.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage {
    private AndroidDriver driver;

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortBy(String sortingOption) {
        WebElement sorting = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + sortingOption + "\")"));
        sorting.click();
    }

    public void selectProduct(int productIndex) {
        List<WebElement> products = driver.findElements(AppiumBy.className("android.widget.TextView"));
        if (products.size() >= productIndex) {
            products.get(productIndex - 1).click();
        } else {
            throw new RuntimeException("Yeterli ürün bulunamadı!");
        }
    }
}
