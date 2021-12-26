package stolk.alecsandro.appium.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;
import stolk.alecsandro.appium.pages.SeuBarrigaHibrido;

import static org.junit.Assert.assertEquals;
import static stolk.alecsandro.appium.core.DriverFactory.*;

public class WebviewTest extends CommonTest {

    private Menu menu = new Menu();
    private SeuBarrigaHibrido page = new SeuBarrigaHibrido();

    @Before
    public void acessaFormulario() {
        aguardar(1);
        menu.acessarSeuBarrigaHibrido();
        aguardar(1);
        // Mudar contexto de mobile para web
        setContext(WEBVIEW_CTAPPIUM);
        aguardar(1);
    }

    @Test
    public void deve_fazer_login() {
        // preencher email
        page.digitarEmail("user.test@email.com");

        // preencher senha
        page.digitarSenha("1234567");

        // clicar em entrar
        page.entrar();

        // Verificar mensagem de sucesso
        assertEquals("Bem vindo, User Test!", page.lerMensagemBemVindo());
    }

    @After
    public void retornarContextoNative() {
        // Mudar contexto de web para mobile
        setContext(NATIVE_APP);
        aguardar(1);
    }
}
