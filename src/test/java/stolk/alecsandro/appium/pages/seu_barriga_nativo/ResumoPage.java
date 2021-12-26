package stolk.alecsandro.appium.pages.seu_barriga_nativo;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

import static stolk.alecsandro.appium.core.DriverFactory.getDriver;

public class ResumoPage extends CommonPage {

    public void removerMovimentacao(String descricao) {
        MobileElement element = (MobileElement) getDriver().findElement(By.xpath(String.format("//*[@text='%s']/..", descricao)));
        swipeElement(element, 0.90, 0.10);
        clicarNoTexto("Del");
    }
}
