package stolk.alecsandro.appium.tests.seu_barriga_nativo_test;

import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.LoginPage;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.MenuPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest extends CommonTest {

    Menu app = new Menu();
    LoginPage page = new LoginPage();
    MenuPage menu = new MenuPage();

    @Before
    public void acessaMenu() {
        app.acessarSeuBarrigaNativo();
    }

    @Test
    public void deve_efetuar_login_com_sucesso() {
        page.setEmail("impostor@email.com");
        page.setSenha("1234567");
        page.entrar();
//        assertFalse(page.isProblemaLogin());
//        assertFalse(page.isUsuarioOuSenhaInvalido());
        assertTrue(menu.isTelaInicial());
    }

    @Test
    public void deve_efetuar_login_senha_invalida() {
        page.setEmail("impostor@email.com");
        page.setSenha("7654321");
        page.entrar();
//        assertFalse(page.isProblemaLogin());
        assertTrue(page.isUsuarioOuSenhaInvalido());
//        assertFalse(menu.isTelaInicial());
    }

    @Test
    public void deve_efetuar_login_usuario_invalido() {
        page.setEmail("impostorr@email.com");
        page.setSenha("1234567");
        page.entrar();
        assertTrue(page.isProblemaLogin());
//        assertFalse(page.isUsuarioOuSenhaInvalido());
        assertFalse(menu.isTelaInicial());
    }
}
