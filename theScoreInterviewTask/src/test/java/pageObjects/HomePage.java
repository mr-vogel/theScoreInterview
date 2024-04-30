package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickSearch(){
        click(By.id("com.fivemobile.thescore:id/search_bar_text_view"));
    }

    public ResultsPage searchFor(String searchTerm){

        WebElement searchBox = getElement(By.id("com.fivemobile.thescore:id/search_src_text"));
        searchBox.sendKeys(searchTerm);

        WebElement result = getElement(By.xpath(" //androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.fivemobile.thescore:id/recyclerView\"]/android.widget.LinearLayout"));
        result.click();
        return new ResultsPage(driver);
    }

    public void verifyTabs(){
        String tab1text = getElement(By.xpath("//android.widget.TextView[@text=\"ALL\"]")).getText();
        String tab2text = getElement(By.xpath("//android.widget.TextView[@text=\"TEAMS\"]")).getText();
        String tab3text = getElement(By.xpath("//android.widget.TextView[@text=\"PLAYERS\"]")).getText();
        String tab4text = getElement(By.xpath("//android.widget.TextView[@text=\"NEWS\"]")).getText();

        Assert.assertEquals(tab1text, "ALL");
        Assert.assertEquals(tab2text, "TEAMS");
        Assert.assertEquals(tab3text, "PLAYERS");
        Assert.assertEquals(tab4text, "NEWS");
    }
}