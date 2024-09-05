package TestSpiceJet;


import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.HomePage;

public class SearchFlightOneWay extends BaseTest {

    @Test
    public void testFlightSearch() {
        HomePage homePage = new HomePage(driver);

        
        //homePage.clickLoginButton();
        //homePage.login("9442630232", "HANA2@legend");
        //homePage.clickLoginSubmitButton();

        
        homePage.searchFlights();

        System.out.println("Flight search completed successfully.");
    }
}
