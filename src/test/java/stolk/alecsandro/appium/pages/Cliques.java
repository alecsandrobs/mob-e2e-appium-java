package stolk.alecsandro.appium.pages;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

import static stolk.alecsandro.appium.core.DriverFactory.getDriver;

public class Cliques extends CommonPage {

    public void cliqueLongo() {
        clicarLongo(byTexto("Clique Longo"));
    }

    public void cliqueDuplo() {
        tap(byTexto("Clique duplo"));
        tap(byTexto("Clique duplo"));
    }

    public String textoCampo() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }

}
