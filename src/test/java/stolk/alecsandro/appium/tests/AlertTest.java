package stolk.alecsandro.appium.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.InputSource;
import org.openqa.selenium.interactions.Interaction;
import stolk.alecsandro.appium.core.CommonPage;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.core.DriverFactory;
import stolk.alecsandro.appium.pages.Alerta;
import stolk.alecsandro.appium.pages.Menu;

import static org.junit.Assert.*;
import static stolk.alecsandro.appium.core.DriverFactory.*;

public class AlertTest extends CommonTest {

    private Menu menu = new Menu();
    private Alerta alerta = new Alerta();
    private CommonPage comum = new CommonPage();

    @Before
    public void start_test() {
        // deve acessar o menu alerta
        menu.acessarAlertas();
    }

    @Test
    public void deve_confirmar_alerta() {
        // clicar em alerta fonfirm
        alerta.clicarAlertaConfirm();

        // verificar textos
        assertEquals("Info", alerta.titulo());
        assertEquals("Confirma a operação?", alerta.texto());

        // confirmar alerta
        alerta.confirmar();

        // verificar nova mensagem
        aguardar(1);
        assertEquals("Confirmado", alerta.texto());

        // sair
        alerta.sair();
    }

    @Test
    public void deve_clicar_fora_alerta() {
        // Clicar no alerta simples
        alerta.clicarAlertaSimples();

        // Validar se o alerta simples
        assertTrue(alerta.existeElementoPeloTexto("Pode clicar no OK ou fora da caixa para sair"));

        // Clicar fora da caixa
        int x = getDriver().manage().window().getSize().width;
        int x2 = x/2;
        int y = getDriver().manage().window().getSize().height;
        int y2 = y-400;

        aguardar(1);

        try {
            comum.tap(x2, y2);
        } catch (InvalidElementStateException exception){
            log(String.format("Erro ao executar a touch action nas coordenadas (x: %s, y: %s)\n%s", x2, y2, exception.getMessage()));
//            alerta.OK();
        }

        aguardar(1);
        aguardarImplicito(1);

        // Verificar que a mensagem não está presente
        assertFalse(alerta.existeElementoPeloTexto("Pode clicar no OK ou fora da caixa para sair"));

    }

    @After
    public void final_test(){
        aguardarImplicito(10);
    }

}