package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.CreateAccountPage;
import pages.MainScreenPage;
import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class validateLoginPageTest extends BaseTest {

    private CreateAccountPage createAccountPage;
    private MainScreenPage mainScreenPage;
    private LoginPage loginPage;

    private final String testEmail = "john.doe@example.com";
    private final String testPassword = "Passw0rd!";

   @Test
    public void testLogin() {

        //Initializing the page objects inherited from the driver
       mainScreenPage = new MainScreenPage(driver);
       createAccountPage = new CreateAccountPage(driver);
       loginPage = new LoginPage(driver);


        //Step 1: Navigate to Create Account Page from Main Screen Page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainScreenPage.getCreateAccountBtn()));
        mainScreenPage.clickCreateAccount();

        // Step 2: Create a new user account
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountPage.getFirstNameFieldLocator()));
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterEmail(testEmail);
        createAccountPage.enterPassword(testPassword);
        createAccountPage.clickCreateAccount();

        // Step 3: From Main Screen navigate to Login screen
       wait.until(ExpectedConditions.visibilityOfElementLocated(MainScreenPage.getLoginBtn()));
        mainScreenPage.clickLogin();

        // Step 4: Enter valid login credentials
       wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.getemailFieldLocator()));
        loginPage.enterLoginCredentials("john.doe@example.com", "Passw0rd!");

        // Step 5: Tap the login button
        loginPage.clickLoginButton();

        // Step 6: Verify if the user is redirected to the home screen
        Assert.assertTrue(LoginPage.isLoggedInScreenDisplayed(), "User is logged in");
    }
 }
