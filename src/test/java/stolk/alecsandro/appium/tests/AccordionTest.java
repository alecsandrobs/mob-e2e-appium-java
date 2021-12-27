package stolk.alecsandro.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Accordion;
import stolk.alecsandro.appium.pages.Menu;

public class AccordionTest extends CommonTest {

    private Menu menu = new Menu();
    private Accordion accordion = new Accordion();

    @Before
    public void iniciar_teste() {
        // Acessar menu abas
        menu.acessarAccordion();
        aguardar(1);
    }

    @Test
    public void deve_interagir_com_abas() {
        // Clicar na opção 1
        accordion.selecionarOpcao1();

        // Verificar texto da opçao 1
        aguardar(1);
        Assert.assertEquals("Esta é a descrição da opção 1", accordion.textoOpcao1());

    }
}
