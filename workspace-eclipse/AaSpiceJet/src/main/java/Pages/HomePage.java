
package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";

    @FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-ubezar']") // Locator for the Login button
    private WebElement loginButton;

    @FindBy(xpath = "//input[@type='number']") // Locator for the mobile number field 
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@type='password']") // Locator for the password field 
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(@class, 'css-1dbjc4n') and contains(@data-testid, 'login-cta')]") // Locator for the Login button in the popup
    private WebElement LoginsubmitButton;
    
    @FindBy(xpath = "//div[contains(@class, 'css-76zvg2') and contains(text(), 'From')]") // Locator for From field
    private WebElement fromField;

    @FindBy(xpath = "//div[contains(text(), 'Bengaluru')]") // Locator for Bengaluru option
    private WebElement bengaluruOption;

    @FindBy(xpath = "//div[contains(@data-testid,'to-testID-destination')]") // Locator for To field
    private WebElement toField;

    @FindBy(xpath = "//div[contains(text(), 'Delhi')]") // Locator for Delhi option
    private WebElement delhiOption;

    @FindBy(xpath = "//div[contains(@class, 'css-1dbjc4n')]") // Locator for calendar icon
    private WebElement calendarIcon;

    @FindBy(xpath = "//div[contains(@class, 'css-76zvg2') and contains(text(), '9')]") // Locator for the date 9
    private WebElement departureDate;
    
    @FindBy(xpath = "//div[contains(@class, 'css-76zvg2') and contains(text(), 'Return Date')]") // Locator for Return Date field
    private WebElement returnDateField;	
    
    @FindBy(xpath = "//div[contains(@class, 'css-76zvg2') and contains(text(), '10')]") // Locator for Return Date 10 October
    private WebElement returnDate;

    @FindBy(xpath = "//div[contains(@class, 'css-76zvg2') and contains(text(), 'Passengers')]") // Locator for Passengers dropdown
    private WebElement passengersDropdown;

    @FindBy(css = "[data-testid='home-page-flight-cta']") // Locator for the Search Flights button
    private WebElement searchFlightsButton;


    @FindBy(xpath = "//div[contains(text(), 'Hi')]") // Locator for the greeting message
    private WebElement greetingMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    // Method to click the Login button on the top of the page
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // Method to fill the login form in the popup
    public void login(String mobileNumber, String password) {
        wait.until(ExpectedConditions.visibilityOf(mobileNumberField)).sendKeys(mobileNumber);
        passwordField.sendKeys(password);
        //popupLoginButton.click();
    }
    
    public void clickLoginSubmitButton() {
    	wait.until(ExpectedConditions.visibilityOf(LoginsubmitButton));
        wait.until(ExpectedConditions.elementToBeClickable(LoginsubmitButton)).click();
    }


    // Method to get the greeting message
    public String getGreetingMessage() {
        wait.until(ExpectedConditions.visibilityOf(greetingMessage));
        return greetingMessage.getText();}
    
        public void searchFlights() {
            wait.until(ExpectedConditions.elementToBeClickable(fromField)).click();
            wait.until(ExpectedConditions.elementToBeClickable(bengaluruOption)).click();
            wait.until(ExpectedConditions.elementToBeClickable(toField)).click();
            wait.until(ExpectedConditions.elementToBeClickable(delhiOption)).click();
            wait.until(ExpectedConditions.elementToBeClickable(calendarIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
            wait.until(ExpectedConditions.elementToBeClickable(passengersDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton)).click();
        }
        
        public void searchRoundTripFlights() {
            // Select Round Trip option
            WebElement roundTripOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-testid, 'round-trip-radio-button')]")));
            roundTripOption.click();
            

            // Fill 'From' field
            wait.until(ExpectedConditions.elementToBeClickable(fromField)).click();
            wait.until(ExpectedConditions.elementToBeClickable(bengaluruOption)).click();
           

            // Fill 'To' field
            wait.until(ExpectedConditions.elementToBeClickable(toField)).click();
            wait.until(ExpectedConditions.elementToBeClickable(delhiOption)).click();
            

            // Select departure date
            wait.until(ExpectedConditions.elementToBeClickable(calendarIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
            

            // Select return date
            wait.until(ExpectedConditions.elementToBeClickable(returnDateField)).click();
            wait.until(ExpectedConditions.elementToBeClickable(returnDate)).click();
            

            // Click on Passengers dropdown
            wait.until(ExpectedConditions.elementToBeClickable(passengersDropdown)).click();
            // Add code to select passengers if needed
            
            // Click the "Search Flights" button
            wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton)).click();
            System.out.println("Search completed");
        }
    }
    
