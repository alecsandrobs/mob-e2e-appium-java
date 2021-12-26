package stolk.alecsandro.appium.tests;

import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Abas;
import stolk.alecsandro.appium.pages.Menu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbasTest extends CommonTest {

    private Menu menu = new Menu();
    private Abas abas = new Abas();

    @Before
    public void iniciar_teste() {
        // Acessar menu abas
        menu.acessarAbas();
    }

    @Test
    public void deve_interagir_com_abas() {
        // Verificar que está na aba 1
        assertTrue(abas.isAba1());
//        assertFalse(abas.isAba2());

        // Acessr aba 2
        abas.clicarAba2();

        // Verificar que está na aba 2
//        assertFalse(abas.isAba1());
        assertTrue(abas.isAba2());

        abas.clicarAba1();

        assertTrue(abas.isAba1());
//        assertFalse(abas.isAba2());
    }
}
