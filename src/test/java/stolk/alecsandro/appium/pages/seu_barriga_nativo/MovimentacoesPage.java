package stolk.alecsandro.appium.pages.seu_barriga_nativo;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

import static stolk.alecsandro.appium.pages.seu_barriga_nativo.Tipo.DESPESA;
import static stolk.alecsandro.appium.pages.seu_barriga_nativo.Tipo.RECEITA;

public class MovimentacoesPage extends CommonPage {

    private By combo = By.id("android:id/text1");
    private By conciliado = By.className("android.widget.Switch");

    public void setTipo(Tipo tipo) {
        selecionarCombo(combo, tipo.getDescription());
    }

    public void setTipoReceita() {
        setTipo(RECEITA);
    }

    public void setTipoDespesa() {
        setTipo(DESPESA);
    }

    public void setConciliado() {
        if (!isAtivo(conciliado)) clicar(conciliado);
    }

    public void setNaoConciliado() {
        if (isAtivo(conciliado)) clicar(conciliado);
    }

    public void setDataMovimentacao(String data) {
    }

    public void setDataPagamento(String data) {
    }

    public void setDescricao(String descricao) {
        digitar(byTexto("Descrição"), descricao);
    }

    public void setInteressado(String interessado) {
        digitar(byTexto("Interessado"), interessado);
    }

    public void setValor(String valor) {
        digitar(byTexto("Valor"), valor);
    }

    public void setConta(String conta) {
        selecionarCombo(getElement(combo, 2), conta);
    }

    public void salvar() {
        clicarNoTexto("SALVAR");
    }

    public boolean isMovCadastrado() {
        return existeElementoPeloTexto("Movimentação cadastrada com sucesso");
    }

    public boolean isMovDescricaoAusente() {
        return existeElementoPeloTexto("Descrição é um campo obrigatório");
    }

    public boolean isMovInteressadoAusente() {
        return existeElementoPeloTexto("Interessado é um campo obrigatório");
    }

    public boolean isMovValorAusente() {
        return existeElementoPeloTexto("Valor é um campo obrigatório");
    }
    public boolean isMovContaAusente() {
        return existeElementoPeloTexto("Conta é um campo obrigatório");
    }
}

enum Tipo {

    DESPESA("Despesa"),
    RECEITA("Receita");

    private String description;

    Tipo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
