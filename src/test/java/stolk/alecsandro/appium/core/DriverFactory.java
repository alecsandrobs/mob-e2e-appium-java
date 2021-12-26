package stolk.alecsandro.appium.core;

import com.paulhammant.ngwebdriver.NgWebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class DriverFactory {

    private static AppiumDriver driver;
    private static NgWebDriver ngDriver;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static final String NATIVE_APP = "NATIVE_APP";
    public static final String WEBVIEW_CHROME = "WEBVIEW_chrome";
    public static final String WEBVIEW_CTAPPIUM = "WEBVIEW_com.ctappium";
    public static final String PWD = System.getenv().get("PWD");
    public static final String RESOURCES_DIR = "src/test/resources";
    public static final String APP_DIR = String.format("%s/%s/CTAppium_1_2.apk", PWD, RESOURCES_DIR);
    public static final String CHROME_DIR = String.format("%s/%s/chromedriver_2-44", PWD, RESOURCES_DIR);

    public static AppiumDriver getDriver() {
        if (driver == null) createDriver();
        return driver;
    }

    private static void createDriver() {
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, APP_DIR);
        capabilities.setCapability("chromedriverExecutable", CHROME_DIR);

        try {
            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
            ngDriver = new NgWebDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        aguardarImplicito(10);
    }

    public static void aguardarImplicito(long tempo) {
        driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
    }

    public static void aguardarPeloElementoPresente(By by, long tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void aguardarPeloElementoVisivel(By by, long tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void setContext(String context) {
        getDriver().context(context);
    }

    public static void setContext(int contextOrder) {
        getDriver().context((String) getDriver().getContextHandles().toArray()[contextOrder]);
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
