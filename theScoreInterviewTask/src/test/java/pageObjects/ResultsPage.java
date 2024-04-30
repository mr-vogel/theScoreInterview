package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ResultsPage extends BasePage{
    public ResultsPage(AppiumDriver driver) {
        super(driver);
    }

    public String getName(){
        return getElement(By.id("com.fivemobile.thescore:id/txt_player_name")).getText();
    }

    //Check out tab information to make sure they display correctly
    //Clicks on the player info tab and verifies the displayed information has changed
    public void verifyTabs(){
        String tab1text = getElement(By.xpath("//android.widget.TextView[@text=\"NEWS\"]")).getText();
        String tab2text = getElement(By.xpath("//android.widget.TextView[@text=\"SEASON\"]")).getText();
        String tab3text = getElement(By.xpath("//android.widget.TextView[@text=\"RESULTS\"]")).getText();
        String tab4text = getElement(By.xpath("//android.widget.TextView[@text=\"INFO\"]")).getText();

        Assert.assertEquals(tab1text, "NEWS");
        Assert.assertEquals(tab2text, "SEASON");
        Assert.assertEquals(tab3text, "RESULTS");
        Assert.assertEquals(tab4text, "INFO");


        click(By.xpath("//android.widget.TextView[@text=\"INFO\"]"));
        String tabName = getElement(By.id("com.fivemobile.thescore:id/title")).getText();
        Assert.assertEquals(tabName, "Age");
    }

    public HomePage goBack(){
        click(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        return new HomePage(driver);
    }
}