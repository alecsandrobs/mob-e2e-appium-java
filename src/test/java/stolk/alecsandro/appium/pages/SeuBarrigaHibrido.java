package stolk.alecsandro.appium.pages;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

public class SeuBarrigaHibrido extends CommonPage {

    public void digitarEmail(String email) {
        digitar(By.cssSelector("input[id='email']"), email);
    }

    public void digitarSenha(String senha) {
        digitar(By.cssSelector("input[id='senha']"), senha);
    }

    public void entrar() {
        clicar(ByAngular.buttonText("Entrar"));
    }

    public String lerMensagemBemVindo() {
        return texto(By.cssSelector("div[class='alert alert-success']"));
    }
}
