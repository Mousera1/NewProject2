package TestSpiceJet;

import org.testng.annotations.Test;
import BaseTest.BaseTest;
import Pages.HomePage;

public class SearchFlightRoundTrip extends BaseTest {

    @Test
    public void testFlightSearch() {
        HomePage homePage = new HomePage(driver);

        homePage.searchRoundTripFlights();

        System.out.println("Round-trip flight search completed successfully.");
    }
}
