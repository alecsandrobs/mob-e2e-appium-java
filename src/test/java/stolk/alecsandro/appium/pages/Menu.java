package stolk.alecsandro.appium.pages;

import stolk.alecsandro.appium.core.CommonPage;

public class Menu extends CommonPage {

    public void acessarAbout() { clicarNoTexto("About...");}

    public void acessarFormulario() {
        clicarNoTexto("Formulário");
    }

    public void acessarSeuBarrigaNativo() { clicarNoTexto("SeuBarriga Nativo");}

    public void acessarSeuBarrigaHibrido() { clicarNoTexto("SeuBarriga Híbrido");}

    public void acessarAlertas() { clicarNoTexto("Alertas"); }

    public void acessarSplash() {
        clicarNoTexto("Splash");
    }

    public void acessarAbas() { clicarNoTexto("Abas"); }

    public void acessarAccordion() { clicarNoTexto("Accordion"); }

    public void acessarCliques() { clicarNoTexto("Cliques"); }

    public void acessarSwipe() { clicarNoTexto("Swipe"); }

    public void acessarSwipeList() { clicarNoTexto("Swipe List"); }

    public void acessarDragAndDrop() { clicarNoTexto("Drag and drop"); }

    public void acessarOperacaoBemEscondida() { clicarNoTexto("Opção bem escondida"); }
}
