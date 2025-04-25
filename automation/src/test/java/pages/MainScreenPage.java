package pages;

// MainScreenPage.java
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainScreenPage {
    private AndroidDriver driver;

    // Locators
    private static final By createAccountBtn = By.id("com.hostelworld.qacodechallenge:id/btnCreateAccount");
    private static final By loginBtn = By.id("com.hostelworld.qacodechallenge:id/btnLogin");

    public MainScreenPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isCreateAccountDisplayed() {
        return driver.findElement(createAccountBtn).isDisplayed();
    }

    public boolean isLoginDisplayed() {
        return driver.findElement(loginBtn).isDisplayed();

    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public static By getCreateAccountBtn() {
        return createAccountBtn;
    }

    public static By getLoginBtn() {
        return loginBtn;
    }
}
