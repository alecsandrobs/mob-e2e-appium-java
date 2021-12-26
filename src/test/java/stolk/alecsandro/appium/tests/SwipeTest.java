package stolk.alecsandro.appium.tests;

import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Alerta;
import stolk.alecsandro.appium.pages.Menu;

import static org.junit.Assert.assertTrue;

public class SwipeTest extends CommonTest {

    private Menu menu = new Menu();
    private Alerta alerta = new Alerta();

    @Before
    public void acessaFormulario() {
        menu.acessarSwipe();
    }

    @Test
    public void deve_realizar_swipe() {
        // Verificar o texto "a esquerda"
        assertTrue(menu.existeElementoPeloTexto("Mova a tela para"));
        assertTrue(menu.existeElementoPeloTexto("a esquerda"));

        // swipe para direita
        menu.swipe(0.9, 0.1);

        // verificar texto "E veja se"
        assertTrue(menu.existeElementoPeloTexto("E veja se"));
        assertTrue(menu.existeElementoPeloTexto("você consegue"));

        // clicar no botão direita
        menu.clicarNoTexto("›");

        // verificar texto "chegar até o fim!"
        assertTrue(menu.existeElementoPeloTexto("Chegar até o fim!"));

        // swipe esquerda
        menu.swipe(0.1, 0.9);

        assertTrue(menu.existeElementoPeloTexto("E veja se"));
        assertTrue(menu.existeElementoPeloTexto("você consegue"));

        // clicar no botão esquerda
        menu.clicarNoTexto("‹");

        assertTrue(menu.existeElementoPeloTexto("Mova a tela para"));
        assertTrue(menu.existeElementoPeloTexto("a esquerda"));
    }
}
