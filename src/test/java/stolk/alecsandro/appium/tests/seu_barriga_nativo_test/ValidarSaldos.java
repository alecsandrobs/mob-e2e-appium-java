package stolk.alecsandro.appium.tests.seu_barriga_nativo_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.HomePage;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.MenuPage;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.MovimentacoesPage;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.ResumoPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidarSaldos extends CommonTest {

    private Menu app = new Menu();
    private MenuPage menu = new MenuPage();
    private MovimentacoesPage mov = new MovimentacoesPage();
    private HomePage home = new HomePage();
    private ResumoPage resumo = new ResumoPage();

    @Before
    public void acessaFuncionalidade() {
        app.acessarSeuBarrigaNativo();
        LoginTest loginTest = new LoginTest();
        loginTest.deve_efetuar_login_com_sucesso();
        aguardar(1);
    }

    @Test
    public void deve_mostrar_saldo_correto_remover_movimento() {
        // Verificar saldo "Conta para saldo" = 534,00
        assertEquals("534.00", home.getSaldoConta("Conta para saldo"));

        // Ir para o resumo
        menu.acessarResumo();

        // Excluir movimentação 3
        resumo.removerMovimentacao("Movimentacao 3, calculo saldo");

        app.clicarNoTexto("Del");

        // Validar a mensagem
        assertTrue(app.existeElementoPeloTexto("Movimentação removida com sucesso!"));

        // Voltar para home
        menu.acessarHome();

        // Atualizar saldo
        aguardar(1);
        app.scroll(0.25, 0.90);

        // Validar saldo
        assertEquals("-1000.00", home.getSaldoConta("Conta para saldo"));
    }

    @After
    public void resetar() {
        capturarTela();
        menu.acessarHome();
        menu.resetar();
        assertTrue(app.existeElementoPeloTexto("Dados resetados com sucesso!"));
    }
}
