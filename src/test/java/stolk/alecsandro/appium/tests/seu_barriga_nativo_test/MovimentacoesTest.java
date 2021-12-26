package stolk.alecsandro.appium.tests.seu_barriga_nativo_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.MenuPage;
import stolk.alecsandro.appium.pages.seu_barriga_nativo.MovimentacoesPage;

import static org.junit.Assert.assertTrue;

public class MovimentacoesTest extends CommonTest {

    Menu app = new Menu();
    MenuPage menu = new MenuPage();
    MovimentacoesPage mov = new MovimentacoesPage();

    @Before
    public void acessaFuncionalidade() {
        app.acessarSeuBarrigaNativo();
        LoginTest loginTest = new LoginTest();
        loginTest.deve_efetuar_login_com_sucesso();
        menu.acessarMovimentacoes();
        aguardar(1);
    }

    @Test
    public void deve_cadastrar_movimentacao_de_receita_conciliada_com_sucesso() {
        String descricao = "Recebimento de importãncia";
        String interessado = "Cliente Teste";
        String valor = "123,45";
        String conta = "Conta para movimentacoes";

        mov.setTipoReceita();
        mov.setConciliado();
        mov.setDescricao(descricao);
        mov.setInteressado(interessado);
        mov.setValor(valor);
        mov.setConta(conta);
        mov.salvar();

        assertTrue(mov.isMovCadastrado());
    }

    @Test
    public void deve_cadastrar_movimentacao_de_despesa_nao_conciliada_com_sucesso() {
        String descricao = "Pagamento de importância";
        String interessado = "Fornecedor Teste";
        String valor = "123,45";
        String conta = "Conta para movimentacoes";

        mov.setTipoDespesa();
        mov.setNaoConciliado();
        mov.setDescricao(descricao);
        mov.setInteressado(interessado);
        mov.setValor(valor);
        mov.setConta(conta);
        mov.salvar();

        assertTrue(mov.isMovCadastrado());
    }

    @Test
    public void deve_validar_campo_descricao() {
        mov.salvar();
        assertTrue(mov.isMovDescricaoAusente());
    }

    @Test
    public void deve_validar_campo_interessado() {
        mov.setDescricao("descrição");
        mov.salvar();
        assertTrue(mov.isMovInteressadoAusente());
    }

    @Test
    public void deve_validar_campo_valor() {
        mov.setDescricao("descrição");
        mov.setInteressado("interessado");
        mov.salvar();
        assertTrue(mov.isMovValorAusente());
    }

    @Test
    public void deve_validar_campo_conta() {
        mov.setDescricao("descrição");
        mov.setInteressado("interessado");
        mov.setValor("123,45");
        mov.salvar();
        assertTrue(mov.isMovContaAusente());
    }

    @After
    public void resetar() {
        capturarTela();
        menu.acessarHome();
        menu.resetar();
    }
}
