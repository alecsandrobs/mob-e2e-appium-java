package stolk.alecsandro.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTest {

    public static String url = "http://localhost:4723/wd/hub";

    public static String mapCalcById() {
        return "com.android.calculator2:id";
    }

    public static String button(String button) {
        return String.format("%s/%s", mapCalcById(), button);
    }

    public static String digitId(int number) {
        return String.format("%s/digit_%d", mapCalcById(), number);
    }

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulador-5554");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AppiumDriver driver = new AppiumDriver(new URL(url), capabilities);

        driver.findElement(By.id(digitId(2))).click();

        driver.findElementByAccessibilityId("plus").click();

        driver.findElement(By.id(digitId(2))).click();

        driver.quit();
    }
}
