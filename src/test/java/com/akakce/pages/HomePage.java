package com.akakce.pages;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private AndroidDriver driver;

    // Constructor
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // clickByText method to click an element by its text
    public void clickByText(String text) {
        // Using XPath to find the element by its text
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        element.click();
    }

    // Other methods for actions on the homepage, like 'continueWithoutLogin'
    public void continueWithoutLogin() {
        // Example of another action (e.g., clicking a continue button)
        WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue without login']"));
        continueButton.click();
    }
}
