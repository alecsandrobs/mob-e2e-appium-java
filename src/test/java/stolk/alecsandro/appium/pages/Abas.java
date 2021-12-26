package stolk.alecsandro.appium.pages;

import stolk.alecsandro.appium.core.CommonPage;

public class Abas extends CommonPage {

    public void clicarAba1() {
        clicarNoTexto("ABA 1");
    }

    public void clicarAba2() {
        clicarNoTexto("ABA 2");
    }

    public Boolean isAba1() {
        return existeElementoPeloTexto("Este é o conteúdo da Aba 1");
    }

    public Boolean isAba2() {
        return existeElementoPeloTexto("Este é o conteúdo da Aba 2");
    }
}
