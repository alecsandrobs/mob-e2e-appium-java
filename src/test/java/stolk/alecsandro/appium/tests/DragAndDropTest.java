package stolk.alecsandro.appium.tests;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;

import java.util.List;

import static stolk.alecsandro.appium.core.DriverFactory.getDriver;

public class DragAndDropTest extends CommonTest {

    private Menu menu = new Menu();
    private CommonPage comum = new CommonPage();

    @Before
    public void acessaFormulario() {
        aguardar(1);
        menu.scroll(0.9, 0.1);
        menu.acessarDragAndDrop();
        aguardar(1);
    }

    @Test
    public void deve_efetuar_drag_and_drop() {
        String textoObtido = "";
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));

        textoObtido = percorrer(elements);
        String textoEsperadoInicio = "Esta\né uma lista\nDrag em Drop!\nFaça um clique longo,\ne arraste para\nqualquer local desejado.";
        Assert.assertEquals(textoEsperadoInicio, textoObtido);

        comum.dragAndDrop(comum.getElement(comum.byTexto("Esta")), comum.getElement(comum.byTexto("e arraste para")));

        elements = getDriver().findElements(By.className("android.widget.TextView"));
        textoObtido = percorrer(elements);
        String textoEsperadoMeio = "é uma lista\nDrag em Drop!\nFaça um clique longo,\ne arraste para\nEsta\nqualquer local desejado.";
        Assert.assertEquals(textoEsperadoMeio, textoObtido);

        comum.dragAndDrop(comum.getElement(comum.byTexto("Faça um clique longo,")), comum.getElement(comum.byTexto("é uma lista")));

        elements = getDriver().findElements(By.className("android.widget.TextView"));
        textoObtido = percorrer(elements);
        String textoEsperadoFim = "Faça um clique longo,\né uma lista\nDrag em Drop!\ne arraste para\nEsta\nqualquer local desejado.";
        Assert.assertEquals(textoEsperadoFim, textoObtido);

        aguardar(1);
    }

    public String percorrer(List<MobileElement> elements) {
        String lista = null;
        for (int i = 0; i < elements.size(); i++) {
            if (lista != null) {
                lista += "\n" + elements.get(i).getText();
            } else {
                lista = elements.get(i).getText();
            }
        }
        return lista;
    }
}
