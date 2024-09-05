
package TestSpiceJet;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.HomePage;

public class NavigationTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        HomePage homePage = new HomePage(driver);

       
        String actualTitle = homePage.getHomePageTitle();
        String expectedTitle = homePage.getExpectedTitle();

        
        Assert.assertEquals(actualTitle, expectedTitle, "Home page title does not match the expected value.");
        System.out.println("Navigated to SpiceJet");
    }
}
