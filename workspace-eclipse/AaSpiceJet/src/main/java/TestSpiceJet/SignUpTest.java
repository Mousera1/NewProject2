package TestSpiceJet;

import org.testng.annotations.Test;
import Pages.SignUpPage;
import BaseTest.BaseTest;

public class SignUpTest extends BaseTest {

    @Test
    public void validateSignUpPage() {
        
        SignUpPage signUpPage = new SignUpPage(driver);

        
        signUpPage.clickSignUpButton();
        
        
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Smith");
        signUpPage.selectTitle("Mrs");
        signUpPage.enterMobileNumber("9442020202");
        signUpPage.enterEmail(""); 
        System.out.println("email");
        signUpPage.enterPassword("yes6@yesA%");
        signUpPage.enterConfirmPassword("yes6@yesA%");
        signUpPage.checkTermsAndConditions();
        
        signUpPage.clickSubmitButton();
        System.out.println("done");

        
    }
}


