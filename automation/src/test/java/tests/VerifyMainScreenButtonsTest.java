package tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainScreenPage;

import java.time.Duration;

public class VerifyMainScreenButtonsTest extends BaseTest {

    @Test
    public void verifyMainScreenButtons() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the buttons to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainScreenPage.getCreateAccountBtn()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainScreenPage.getLoginBtn()));

        MainScreenPage mainScreen = new MainScreenPage(driver);

        // Validate that the buttons are displayed on the Main Screen Page
        Assert.assertTrue(mainScreen.isCreateAccountDisplayed(), "'Create Account' button is not visible.");
        Assert.assertTrue(mainScreen.isLoginDisplayed(), "'Login' button is not visible.");

        System.out.println("✅ 'Create Account' and 'Login' buttons are successfully displayed.");

    }

}
