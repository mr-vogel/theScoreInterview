package tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestCase {
    AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:platformVersion", "14.0");
        capabilities.setCapability("appium:deviceName","Pixel 8 API 34");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/mrv/Downloads/theScore Sports News & Scores_24.6.0_Apkpure.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    //Properly shut down the appium driver
    @AfterMethod()
    public void shutDown(){
        driver.quit();
    }
}