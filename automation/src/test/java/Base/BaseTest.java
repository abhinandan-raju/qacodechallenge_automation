package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setApp("C:/apk/app-debug-androidTest.apk")
                .setAppPackage("com.hostelworld.qacodechallenge") // Set the app package
                .setAppActivity("com.hostelworld.qacodechallenge.MainActivity"); // Set the main activity

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
