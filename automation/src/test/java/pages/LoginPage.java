package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    private static AndroidDriver driver;

    // Locators for the login page
    private static By emailField = By.id("com.hostelworld.qacodechallenge:id/usernameEt");
    private By passwordField = By.id("com.hostelworld.qacodechallenge:id/passwordEt");
    private By loginButton = By.id("com.hostelworld.qacodechallenge:id/btnLogin");
    private static By loggedInScreenText = By.id("com.hostelworld.qacodechallenge:id/greetingTv");

    // Constructor to initialize the driver
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Check if email field is displayed
    public static By getemailFieldLocator() {
        return emailField;
    }

    // Method to enter login credentials
    public void enterLoginCredentials(String email, String password) {
        driver.findElement(emailField).sendKeys(email);  // Enter email
        driver.findElement(passwordField).sendKeys(password);  // Enter password
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();  // Click the login button
    }

    // Method to check if home screen is displayed after login
    public static boolean isLoggedInScreenDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInScreenText));
            return true;  // Home screen is visible, login successful
        } catch (Exception e) {
            return false;  // Home screen is not visible, login failed
        }
    }
}
