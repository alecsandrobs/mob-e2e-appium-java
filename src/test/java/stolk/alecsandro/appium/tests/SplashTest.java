package stolk.alecsandro.appium.tests;

import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;
import stolk.alecsandro.appium.pages.Splash;

import static org.junit.Assert.assertTrue;

public class SplashTest extends CommonTest {

    private Menu menu = new Menu();
    private Splash splash = new Splash();

    @Before
    public void acessarMenu() {
        // Accesar menu splash
        menu.acessarSplash();
    }

    @Test
    public void deve_aguardar_splash_sumir() {
        // Verificar que o splash está sendo exibido
        splash.isTelaSplashVisivel();

        // aguardar a saída do splash
        splash.aguardarSplashSumir();

        // Verificar que o formulário está aparecendo
        assertTrue(splash.existeElementoPeloTexto("Formulário"));
    }
}
