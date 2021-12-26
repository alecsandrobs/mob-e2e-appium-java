package stolk.alecsandro.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

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

    DesiredCapabilities capabilities = new DesiredCapabilities();
    AppiumDriver<MobileElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("Executou o Before");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulador-5554");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AppiumDriver(new URL(url), capabilities);
    }

    @Test
    public void deve_somar_dois_valores() {

        MobileElement button2 = driver.findElement(By.id(digitId(2)));
        button2.click();

        MobileElement buttonPlus = driver.findElementByAccessibilityId("plus");
        buttonPlus.click();

        button2.click();

        MobileElement fieldResult = driver.findElement(By.id(button("result")));

        System.out.println(String.format("Resultado da soma: %s", fieldResult.getText()));

        assertEquals("4", fieldResult.getText());
    }

    @After
    public void tearDown() {
        System.out.println("Executou o After");
        driver.quit();
    }
}
