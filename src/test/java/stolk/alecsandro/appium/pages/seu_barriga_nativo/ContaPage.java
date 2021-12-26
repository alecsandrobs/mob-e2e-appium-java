package stolk.alecsandro.appium.pages.seu_barriga_nativo;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

public class ContaPage extends CommonPage {

    public void setNome(String nome) {
//        digitar(By.xpath("//android.widget.EditText[0]"), nome);
        digitar(By.className("android.widget.EditText"), nome);
    }

    public void salvar() {
        clicarNoTexto("SALVAR");
    }

    public void excluir() {
        clicarNoTexto("EXCLUIR");
    }

    public void editar(String nome){
        clicarLongo(byTexto(nome));
    }

    public boolean isContaCadastrada(){
        return existeElementoPeloTexto("Conta adicionada com sucesso");
    }

    public boolean isContaAtualizada(){
        return existeElementoPeloTexto("Conta atualizada com sucesso");
    }

    public boolean isContaExcluida(){
        return existeElementoPeloTexto("Conta excluída com sucesso");
    }

    public boolean isContaComMovimento(){
        return existeElementoPeloTexto("Conta em uso nas movimentações");
    }

    public boolean isProblemaComunicacao(){
        return existeElementoPeloTexto("Problemas de comunicação");
    }

    public boolean isContaComNome(String nome) {
        return existeElementoPeloTexto(nome);
    }
}
