package stolk.alecsandro.appium.pages.seu_barriga_nativo;

import stolk.alecsandro.appium.core.CommonPage;

public class LoginPage extends CommonPage {

    public void setEmail(String email) {
        digitar(byTexto("Nome"), email);
    }

    public void setSenha(String senha) {
        digitar(byTexto("Senha"), senha);
    }

    public void entrar() {
        clicar(byTexto("ENTRAR"));
    }

    public boolean isProblemaLogin() {
        return existeElementoPeloTexto("Problemas com o login");
    }

    public boolean isUsuarioOuSenhaInvalido() {
        return existeElementoPeloTexto("Usuário ou senha inválido");
    }
}
