package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.OnboardingPage;
import pageObjects.ResultsPage;

public class InterviewTestCase extends BaseTestCase {


    @Test
    public void testCase() throws InterruptedException {
        OnboardingPage o = new OnboardingPage(driver);

        //Get through the initial app onboarding
        HomePage h = o.completeOnboarding();

        //Search for a player, a team, or a league, Here we search for tennis player Andy Murray, and verify we are taken to
        //the correct page by getting his name from the title/header field
        h.clickSearch();
        ResultsPage r = h.searchFor("Andy Murray");
        String resultsName = r.getName();

        //Asserts we were taken to the correct page after searching for team/player/league
        Assert.assertEquals(resultsName, "Andy Murray");

        // verifies the correct sub-tabs are present
        // clicks on a sub-tab, and verifies the information changes
        r.verifyTabs();

        h = r.goBack();

        // Here we are verifying we were correctly taken back to the search after hitting the back button
        h.verifyTabs();
    }
}