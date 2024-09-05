
package TestSpiceJet;

import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import Pages.ConfigReader;
import Pages.HomePage;

public class LoginTest extends BaseTest {
	ConfigReader config = new ConfigReader();

 @Test
 public void loginTest() {
     HomePage homePage = new HomePage(driver);

     
     homePage.clickLoginButton();

     
    // homePage.login("9442630232", "HANA2@legend");
     
     String mobileNumber = config.getProperty("login.mobileNumber");
     String password = config.getProperty("login.password");
     homePage.login(mobileNumber, password);
     
     homePage.clickLoginSubmitButton();
     System.out.println("submitted");

     
     String greetingText = homePage.getGreetingMessage();
     System.out.println("greeting done");
     System.out.println(greetingText);
     

     
     Assert.assertTrue(greetingText.contains("Hi Mourice"), "Greeting message not found or incorrect");
 }
}

