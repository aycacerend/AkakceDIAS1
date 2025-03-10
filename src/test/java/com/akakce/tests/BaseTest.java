package com.akakce.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected static AppiumDriver driver;  // WebDriver yerine AppiumDriver kullanıyoruz

    public void setup() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554") // Fiziksel cihaz için adb devices ile ID al
                .setApp(System.getProperty("user.dir") + "/Users/aycacerend/Downloads/akakce.apk")
                .setAutomationName("UiAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(6000))
                .autoGrantPermissions();  // Android izinlerini otomatik verir
               // caps.setCapability(MobileCapabilityType.APP, "/Users/aycacerend/Downloads/akakce.apk");


        try {
            driver = new AndroidDriver(new URL("http://0.0.0.1:4723/wd/hub"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("Appium bağlantısı başarılı!");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium Server URL hatalı!", e);
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test tamamlandı, driver kapatıldı.");
        }
    }
}
