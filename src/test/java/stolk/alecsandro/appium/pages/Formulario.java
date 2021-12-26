package stolk.alecsandro.appium.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stolk.alecsandro.appium.core.CommonPage;

import static stolk.alecsandro.appium.core.DriverFactory.getDriver;

public class Formulario extends CommonPage {

    private By byNome = MobileBy.AccessibilityId("nome");
    private By byCombo = MobileBy.AccessibilityId("console");
    private By byComboSelecionado = By.xpath("//android.widget.Spinner/android.widget.TextView");
    private By byCheck = MobileBy.AccessibilityId("check");
    private By bySwitch = MobileBy.AccessibilityId("switch");

    private By textoSalvo(String texto) {
        return By.xpath(String.format("//*[starts-with(@text, '%s:')]", texto));
    }

    public void digitarNome(String nome) {
        digitar(byNome, nome);
    }

    public String lerNome() {
        return texto(byNome);
    }

    public void selecionarCombo(String opcao) {
        selecionarCombo(byCombo, opcao);
    }

    public String lerComboSelecionado() {
        return texto(byComboSelecionado);
    }

    public void clicarSeekBar(double posicao) {
        int delta = 50;
        WebElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));

        int xInicial = seek.getLocation().x + delta;
        int x = (int) (xInicial + ((seek.getSize().width - 2 * delta) * posicao));
        int y = seek.getLocation().y + (seek.getSize().height / 2);

        System.out.println("-------");
        System.out.println(x);
        System.out.println(y);
        System.out.println("-------");

        tap(x, y);
    }

    public void clicarCheck() {
        clicar(byCheck);
    }

    public Boolean isCheckMarcado() {
        return isAtivo(byCheck);
    }

    public void clicarSwitch() {
        clicar(bySwitch);
    }

    public Boolean isSwitchAtivo() {
        return isAtivo(bySwitch);
    }

    public void salvar() {
        clicarNoTexto("SALVAR");
    }

    public void salvarDemorado() {
        clicarNoTexto("SALVAR DEMORADO");
    }

    public String lerCampoSalvoNome() {
        return texto(textoSalvo("Nome"));
    }

    public String lerCampoSalvoConsole() {
        return texto(textoSalvo("Console"));
    }

    public String lerCampoSalvoSlider() {
        return texto(textoSalvo("Slider"));
    }

    public String lerCampoSalvoSwitch() {
        return texto(textoSalvo("Switch"));
    }

    public String lerCampoSalvoCheck() {
        return texto(textoSalvo("Checkbox"));
    }

    public String lerCampoSalvoData() {
        return texto(textoSalvo("Data"));
    }
}
