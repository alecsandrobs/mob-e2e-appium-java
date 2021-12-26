package stolk.alecsandro.appium.tests.seu_barriga_nativo_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.ContaPage;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.MenuPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContaTest extends CommonTest {

    Menu app = new Menu();
    ContaPage page = new ContaPage();
    MenuPage menu = new MenuPage();

    @Before
    public void acessaFuncionalidade() {
        app.acessarSeuBarrigaNativo();
        LoginTest loginTest = new LoginTest();
        loginTest.deve_efetuar_login_com_sucesso();
        menu.acessarContas();
        aguardar(1);
    }

    @Test
    public void deve_cadastrar_conta_com_sucesso() {
        String nomeConta = "Conta do Impostor";
        page.setNome(nomeConta);
        page.salvar();
        assertTrue(page.isContaCadastrada());
//        assertFalse(page.isContaAtualizada());
//        assertFalse(page.isContaExcluida());
//        assertFalse(page.isContaComMovimento());
//        assertFalse(page.isProblemaComunicacao());
        assertTrue(page.isContaComNome(nomeConta));
    }

    @Test
    public void deve_editar_conta_com_sucesso() {
        String nomeContaAlterar = "Conta para alterar";
        page.editar(nomeContaAlterar);
        String nomeConta = "Conta alterada";
        page.setNome(nomeConta);
        page.salvar();
//        assertFalse(page.isContaCadastrada());
        assertTrue(page.isContaAtualizada());
//        assertFalse(page.isContaExcluida());
//        assertFalse(page.isContaComMovimento());
//        assertFalse(page.isProblemaComunicacao());
        assertTrue(page.isContaComNome(nomeConta));
        assertFalse(page.isContaComNome(nomeContaAlterar));
    }

    @Test
    public void deve_excluir_conta_com_sucesso() {
        String nomeConta = "Conta para alterar";
        page.editar(nomeConta);
        page.excluir();
//        assertFalse(page.isContaCadastrada());
//        assertFalse(page.isContaAtualizada());
        assertTrue(page.isContaExcluida());
//        assertFalse(page.isContaComMovimento());
//        assertFalse(page.isProblemaComunicacao());
        assertFalse(page.isContaComNome(nomeConta));
    }

    @Test
    public void deve_impedir_cadastrar_conta_duplicada() {
        String nomeConta = "Conta mesmo nome";
        page.setNome(nomeConta);
        page.salvar();
//        assertFalse(page.isContaCadastrada());
//        assertFalse(page.isContaAtualizada());
//        assertFalse(page.isContaExcluida());
//        assertFalse(page.isContaComMovimento());
        assertTrue(page.isProblemaComunicacao());
        assertTrue(page.isContaComNome(nomeConta));
    }

    @Test
    public void deve_impedir_editar_conta_duplicada() {
        String nomeContaAlterar = "Conta para movimentacoes";
        page.editar(nomeContaAlterar);
        String nomeConta = "Conta mesmo nome";
        page.setNome(nomeConta);
        page.salvar();
//        assertFalse(page.isContaCadastrada());
//        assertFalse(page.isContaAtualizada());
//        assertFalse(page.isContaExcluida());
//        assertFalse(page.isContaComMovimento());
        assertTrue(page.isProblemaComunicacao());
        assertTrue(page.isContaComNome(nomeConta));
        assertTrue(page.isContaComNome(nomeContaAlterar));
    }

    @Test
    public void deve_impedir_excluir_conta_com_movimento() {
        String nomeConta = "Conta com movimentacao";
        page.editar(nomeConta);
        page.excluir();
//        assertFalse(page.isContaCadastrada());
//        assertFalse(page.isContaAtualizada());
//        assertFalse(page.isContaExcluida());
        assertTrue(page.isContaComMovimento());
//        assertFalse(page.isProblemaComunicacao());
        assertTrue(page.isContaComNome(nomeConta));
    }

    @After
    public void resetar() {
        capturarTela();
        menu.acessarHome();
        menu.resetar();
    }
}
