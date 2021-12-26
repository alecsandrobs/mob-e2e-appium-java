package stolk.alecsandro.appium.pages.seu_barriga_nativo;

import stolk.alecsandro.appium.core.CommonPage;

import static stolk.alecsandro.appium.pages.seu_barriga_nativo.Menu.*;

public class MenuPage extends CommonPage {

    public void acessarHome() {
        clicarNoTexto(HOME.name());
    }

    public void acessarContas() {
        clicarNoTexto(CONTAS.name());
    }

    public void acessarMovimentacoes() {
        clicarNoTexto(String.format("%s...", MOV.name()));
    }

    public void acessarResumo() {
        clicarNoTexto(RESUMO.name());
    }

    public void resetar() {
        clicarNoTexto(RESET.name());
    }

    public boolean isTelaInicial() {
        return existeElementoPeloTexto(RESET.name());
    }
}

enum Menu {

    HOME("HOME"),
    CONTAS("CONTAS"),
    MOV("MOV"),
    RESUMO("RESUMO"),
    RESET("RESET");

    Menu(String description) {}
}
