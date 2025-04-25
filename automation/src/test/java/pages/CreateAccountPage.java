package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class CreateAccountPage {

    private AndroidDriver driver;

    // Locators for Create Account screen elements
    private static final By firstNameField = By.id("com.hostelworld.qacodechallenge:id/firstNameEt");
    private static final By lastNameField = By.id("com.hostelworld.qacodechallenge:id/lastNameEt");
    private static final By emailField = By.id("com.hostelworld.qacodechallenge:id/emailEt");
    private static final By passwordField = By.id("com.hostelworld.qacodechallenge:id/passwordEt");
    private static final By createAccountButton = By.id("com.hostelworld.qacodechallenge:id/btnCreateAccount");

    // Locators for error messages
    private static final By firstNameError = By.id("com.hostelworld.qacodechallenge:id/firstNameErrorText");
    private static final By lastNameError = By.id("com.hostelworld.qacodechallenge:id/lastNameErrorText");
    private static final By emailError = By.id("com.hostelworld.qacodechallenge:id/emailErrorText");
    private static final By passwordError = By.id("com.hostelworld.qacodechallenge:id/passwordErrorText");

    public CreateAccountPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static By getFirstNameFieldLocator() {
        return firstNameField;
    }

    // Methods to interact with input fields
    public void enterFirstName(String firstName) {
        WebElement element = driver.findElement(firstNameField);
        element.clear();
        element.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement element = driver.findElement(lastNameField);
        element.clear();
        element.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement element = driver.findElement(emailField);
        element.clear();
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.clear();
        element.sendKeys(password);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    // Validation checks using error messages visibility

    public boolean isFirstNameInvalid() {
        return isErrorMessageDisplayed(firstNameError, "First name is required");
    }

    public boolean isLastNameInvalid() {
        return isErrorMessageDisplayed(lastNameError, "Last name is required");
    }

    public boolean isEmailInvalid() {
        return isErrorMessageDisplayed(emailError, "Please enter a valid email address");
    }

    public boolean isPasswordInvalid() {
        return isErrorMessageDisplayed(passwordError, "Password is required");
    }

    // Helper method to check if the error message is displayed and matches the expected text
    private boolean isErrorMessageDisplayed(By errorLocator, String expectedMessage) {
        try {
            WebElement errorMessage = driver.findElement(errorLocator);
            return errorMessage.isDisplayed() && errorMessage.getText().equals(expectedMessage);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Helper method to clear all fields
    public void clearAllFields() {
        enterFirstName("");
        enterLastName("");
        enterEmail("");
        enterPassword("");
    }
}