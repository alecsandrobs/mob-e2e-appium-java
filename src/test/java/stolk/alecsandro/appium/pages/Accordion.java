package stolk.alecsandro.appium.pages;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

public class Accordion extends CommonPage {

    public void selecionarOpcao1() {
        clicarNoTexto("Opção 1");
    }

    public String textoOpcao1() {
        return texto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }

}
