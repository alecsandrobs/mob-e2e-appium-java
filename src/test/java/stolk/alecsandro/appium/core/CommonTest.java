package stolk.alecsandro.appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static stolk.alecsandro.appium.core.DriverFactory.*;

public class CommonTest {

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void setUp() {
        System.out.println("Iniciando Setup...");
        getDriver();
    }

    @Before
    public void startTest() {
        aguardarImplicito(10);
    }

    @After
    public void AfterTest() {
//        capturarTela();
        getDriver().resetApp();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Finalizando todos os testes...");
        killDriver();
    }

    public void capturarTela() {
        File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imagem, new File(String.format("target/screenshots/%s.png", testName.getMethodName())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aguardar(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new Error(e.getMessage());
        }
    }
}

// 49s 411ms
// 30s 268ms
// 23s 713ms