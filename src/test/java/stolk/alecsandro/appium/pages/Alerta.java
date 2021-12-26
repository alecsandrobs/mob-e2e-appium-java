package stolk.alecsandro.appium.pages;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

public class Alerta extends CommonPage {

    public void clicarAlertaSimples() {
        clicarNoTexto("ALERTA SIMPLES");
    }

    public void clicarAlertaRestritivo() {
        clicarNoTexto("ALERTA RESTRITIVO");
    }

    public void clicarAlertaConfirm() {
        clicarNoTexto("ALERTA CONFIRM");
    }

    public String titulo() {
        return texto(By.id("android:id/alertTitle"));
    }

    public String texto() {
        return texto(By.id("android:id/message"));
    }

    public void confirmar() {
//        clicar(By.id("android:id/button2"));
        clicarNoTexto("CONFIRMAR");
    }

    public void negar() {
//        clicar(By.id("android:id/button1"));
        clicarNoTexto("NEGAR");
    }

    public void OK() {
        clicarNoTexto("OK");
    }

    public void sair() {
        clicarNoTexto("SAIR");
    }
}
