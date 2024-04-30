package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        waitFor(locator);
        driver.findElement(locator).click();
    }

    public WebElement getElement(By by) {
        waitFor(by);
        return driver.findElement(by);
    }

    public void waitFor(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeVisible(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElementToBePresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}