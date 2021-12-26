package stolk.alecsandro.appium.tests;

import io.appium.java_client.MobileBy;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Formulario;
import stolk.alecsandro.appium.pages.Menu;

import static org.junit.Assert.*;
import static stolk.alecsandro.appium.core.DriverFactory.aguardarImplicito;
import static stolk.alecsandro.appium.core.DriverFactory.aguardarPeloElementoPresente;

public class FormularioTeste extends CommonTest {

    private Menu menu = new Menu();
    private Formulario formulario = new Formulario();

    @Before
    public void acessaFormulario() {
        menu.acessarFormulario();
    }

    @Test
    public void deve_preencher_campo_nome() {
        String nome = "Joe Montana";
        formulario.digitarNome(nome);
        assertEquals(nome, formulario.lerNome());
    }

    @Test
    public void deve_inderagir_com_combo() {
        String opcao = "Nintendo Switch";
        formulario.selecionarCombo(opcao);
        assertEquals(opcao, formulario.lerComboSelecionado());
    }

    @Test
    public void deve_inderagir_com_switch_e_checkbox() {
        assertFalse(formulario.isCheckMarcado());
        assertTrue(formulario.isSwitchAtivo());

        formulario.clicarCheck();
        formulario.clicarSwitch();

        assertTrue(formulario.isCheckMarcado());
        assertFalse(formulario.isSwitchAtivo());
    }

    @Test
    public void deve_gravar_informacoes_do_formulario_desafio() {
        String name = "Alecsandro Bez Stolk";

        formulario.digitarNome(name);
        formulario.selecionarCombo("PS4");
        formulario.clicarCheck();
        formulario.clicarSwitch();

        formulario.salvar();

        assertTrue(formulario.lerCampoSalvoNome().endsWith(name));
        assertTrue(formulario.lerCampoSalvoConsole().endsWith("ps4"));
        assertTrue(formulario.lerCampoSalvoSlider().endsWith("25"));
        assertTrue(formulario.lerCampoSalvoSwitch().endsWith("Off"));
        assertTrue(formulario.lerCampoSalvoCheck().endsWith("Marcado"));
        assertTrue(formulario.lerCampoSalvoData().endsWith("01/01/2000"));
    }

    @Test
    public void deve_realizar_cadastro_demorado() {
        String name = "John Smith";

        formulario.digitarNome(name);

        formulario.salvarDemorado();

        // Má estratégia
        aguardarImplicito(0);
//        aguardar(3);
        aguardarPeloElementoPresente(By.xpath("//*[starts-with(@text, 'Nome:')]"), 10);

        assertTrue(formulario.lerCampoSalvoNome().endsWith(name));
        assertTrue(formulario.lerCampoSalvoConsole().endsWith("xone"));
        assertTrue(formulario.lerCampoSalvoSlider().endsWith("25"));
        assertTrue(formulario.lerCampoSalvoSwitch().endsWith("On"));
        assertTrue(formulario.lerCampoSalvoCheck().endsWith("Desabilitado"));
        assertTrue(formulario.lerCampoSalvoData().endsWith("01/01/2000"));
    }

    @Test
    public void deve_alterar_data() {
        formulario.clicarNoTexto("01/01/2000");
        formulario.clicarNoTexto("20");
        formulario.clicarNoTexto("OK");

        assertTrue(formulario.existeElementoPeloTexto("20/2/2000"));
    }

    @Test
    public void deve_alterar_hora() {
        formulario.clicarNoTexto("06:00");
        formulario.clicar(MobileBy.AccessibilityId("10"));
        formulario.clicar(MobileBy.AccessibilityId("45"));
        formulario.clicarNoTexto("OK");

        assertTrue(formulario.existeElementoPeloTexto("10:45"));
    }

    @Test
    public void deve_interagir_com_seekbar() {
        // Clicar no seekbar
        formulario.clicarSeekBar(0.67);

        // Salvar
        formulario.salvar();

        aguardar(7);

        // Obter o valor
    }
}
