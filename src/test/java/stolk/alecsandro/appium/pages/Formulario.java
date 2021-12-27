package stolk.alecsandro.appium.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stolk.alecsandro.appium.core.CommonPage;

import java.util.List;

import static stolk.alecsandro.appium.core.DriverFactory.getDriver;

public class Formulario extends CommonPage {

    private By byNome = MobileBy.AccessibilityId("nome");
    private By byCombo = MobileBy.AccessibilityId("console");
    private By byComboSelecionado = By.xpath("//android.widget.Spinner/android.widget.TextView");
    private By byCheck = MobileBy.AccessibilityId("check");
    private By bySwitch = MobileBy.AccessibilityId("switch");
    private By bySelecionarAno = MobileBy.id("android:id/date_picker_header_year");
    private By byAnos = MobileBy.id("android:id/text1");
    private By byMesAnterior = By.id("android:id/prev");
    private By byMesAtual = By.id("android:id/date_picker_header_date");
    private By byMesPosterior = By.id("android:id/next");

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

    public void clicarSelecionarAno() { clicar(bySelecionarAno); }

    public void selecionarAno(String ano) {
        int count = 10;
        boolean encontrou = false;
        while (count > 0 || encontrou) {
            List<MobileElement> elementos = getElements(byAnos);
            WebElement elementoOrigem = elementos.get(elementos.size() - 3);
            WebElement elementoDestino = elementos.get(2);
            WebElement elementoAno = null;
            for(int i=0; i < elementos.size(); i++){
                WebElement elemento = elementos.get(i);
                if(elemento.getText().contains(ano)) {
                    elementoAno = elemento;
                    encontrou = true;
                    break;
                }
            }
            if(encontrou) {
                elementoAno.click();
                break;
            } else {
                scroll(elementoOrigem, elementoDestino);
            }
            count--;
        }
    }

    public void repeatClick(By by, int times){
        for(int i=0; i<times; i++){
            getElement(by).click();
        }
    }

    public void selecionarMes(String mes) {
        WebElement elementoMes = getElement(byMesAtual);
        String mesInicial = "Feb";
        if(elementoMes.getText().contains(mesInicial)) {
            switch (mes){
                case "1": repeatClick(byMesAnterior, 1); break;
                case "2": break;
                case "3": repeatClick(byMesPosterior, 1); break;
                case "4": repeatClick(byMesPosterior, 2); break;
                case "5": repeatClick(byMesPosterior, 3); break;
                case "6": repeatClick(byMesPosterior, 4); break;
                case "7": repeatClick(byMesPosterior, 5); break;
                case "8": repeatClick(byMesPosterior, 6); break;
                case "9": repeatClick(byMesPosterior, 7); break;
                case "10": repeatClick(byMesPosterior, 8); break;
                case "11": repeatClick(byMesPosterior, 9); break;
                case "12": repeatClick(byMesPosterior, 10); break;
                default: break;
            }
        } else {
            Assert.fail(String.format("O mês inicial exibido não é o esperado (%s).", mesInicial));
        }
    }

    public void selecionarData(String data) {
        String dataSeparada[] = data.split("/");
        String diaInteiro = String.format("%s", Integer.parseInt(dataSeparada[0]));
        String mesInteiro = String.format("%s", Integer.parseInt(dataSeparada[1]));
        String ano = dataSeparada[2];
        clicarSelecionarAno();
        selecionarAno(ano);
        selecionarMes(mesInteiro);
        getElement(byTexto(diaInteiro)).click();
        clicarNoTexto("OK");
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
