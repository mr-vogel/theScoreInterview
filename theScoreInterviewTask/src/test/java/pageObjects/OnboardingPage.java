package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPage extends BasePage{

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    //This simply click through the initial app onboarding flow
    public HomePage completeOnboarding() throws InterruptedException {

        click(By.id("com.fivemobile.thescore:id/btn_primary"));
        click(By.id("com.fivemobile.thescore:id/btn_primary"));
        click(By.id("com.fivemobile.thescore:id/btn_disallow"));
        click(By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/follow_icon\"])[1]"));
        click(By.id("com.fivemobile.thescore:id/btn_primary"));
        click(By.id("com.fivemobile.thescore:id/btn_primary"));
        click(By.id("com.fivemobile.thescore:id/btn_secondary"));
        click(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        return new HomePage(driver);
    }
}