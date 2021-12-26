package stolk.alecsandro.appium.pages;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

import static stolk.alecsandro.appium.core.DriverFactory.aguardarImplicito;
import static stolk.alecsandro.appium.core.DriverFactory.aguardarPeloElementoVisivel;

public class Splash extends CommonPage {

    public Boolean isTelaSplashVisivel() {
        return existeElementoPeloTexto("Splash!");
    }

    public void aguardarSplashSumir() {
        aguardarImplicito(0);
        aguardarPeloElementoVisivel(By.xpath(String.format("//*[@text='Splash!']")), 10);
    }
}
