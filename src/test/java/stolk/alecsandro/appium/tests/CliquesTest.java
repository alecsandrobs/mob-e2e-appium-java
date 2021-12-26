package stolk.alecsandro.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Cliques;
import stolk.alecsandro.appium.pages.Menu;

public class CliquesTest extends CommonTest {

    private Menu menu = new Menu();
    private Cliques cliques = new Cliques();

    @Before
    public void acessaFormulario() {
        menu.acessarCliques();
    }

    @Test
    public void deve_realizar_clique_longo() {
        // Clique long
        cliques.cliqueLongo();

        // Verificar texto
        Assert.assertEquals("Clique Longo", cliques.textoCampo());
    }

    @Test
    public void deve_realizar_clique_duplo() {
        // Clique long
        cliques.cliqueDuplo();
        cliques.cliqueLongo();

        // Verificar texto
        Assert.assertEquals("Clique Longo", cliques.textoCampo());
    }
}
