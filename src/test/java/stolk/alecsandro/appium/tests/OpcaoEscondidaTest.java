package stolk.alecsandro.appium.tests;

import org.junit.Assert;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Alerta;
import stolk.alecsandro.appium.pages.Menu;

public class OpcaoEscondidaTest extends CommonTest {

    private Menu menu = new Menu();
    private Alerta alerta = new Alerta();

    @Test
    public void deve_encontrar_opcao_escondida() {
        // Scroll down
        aguardar(1);
        menu.scroll(0.9, 0.1);

        // clicar menu
        menu.acessarOperacaoBemEscondida();

        // Verificar mensagem
        Assert.assertEquals("Você achou essa opção", alerta.texto());

        // Sair
        alerta.tap(alerta.byTexto("OK"));
//        alerta.OK();
    }
}
