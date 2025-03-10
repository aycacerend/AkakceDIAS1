package com.akakce.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(AppiumBy.id("com.akakce:id/add_to_cart_button"));
        addToCartButton.click();
    }

    public void goToSeller() {
        WebElement sellerButton = driver.findElement(AppiumBy.id("com.akakce:id/go_to_seller_button"));
        sellerButton.click();
    }
}
