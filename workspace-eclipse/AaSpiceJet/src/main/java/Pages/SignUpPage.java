package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    @FindBy(linkText = "Signup")
    private WebElement signupButton;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(xpath = "//select[@class='form-control form-select ']")
    private WebElement titleDropdown;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='+91 01234 56789']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@id='email_id']")
    private WebElement emailField;

    @FindBy(id = "new-password")
    private WebElement passwordField;

    @FindBy(id = "c-password")
    private WebElement confirmPasswordField;
    
    @FindBy(xpath = "//button[@class='btn btn-red']")
    private WebElement submitButton;
    
    @FindBy(id = "defaultCheck1")
    private WebElement termsCheckbox;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with 10 seconds timeout
        PageFactory.initElements(driver, this);
    }
    
    // Method to click the Signup button
    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }
    
    // Methods to interact with page elements
    public void enterFirstName(String firstName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        element.clear(); // Clear any existing text
        element.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        
        element.sendKeys(lastName);
    }

    public void selectTitle(String title) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(titleDropdown)));
        dropdown.selectByVisibleText(title);
    }
    
    public void enterMobileNumber(String mobileNumber) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
        
        element.sendKeys(mobileNumber);
    }

    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailField));
       
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(passwordField));
        
        element.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        
        element.sendKeys(confirmPassword);
    }
    
    public void clickSubmitButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        button.click();
    }
    
    public void checkTermsAndConditions() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Terms and conditions checkbox is now selected.");
        } else {
            System.out.println("Terms and conditions checkbox was already selected.");
        }
    }
}

