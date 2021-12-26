package stolk.alecsandro.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stolk.alecsandro.appium.core.CommonPage;
import stolk.alecsandro.appium.core.CommonTest;
import stolk.alecsandro.appium.pages.Menu;

public class SwipeListTest extends CommonTest {

    private Menu menu = new Menu();
    private CommonPage comum = new CommonPage();
    private String opcao1Padrao = "Opção 1";
    private String opcao2Padrao = "Opção 2 (+)";
    private String opcao3Padrao = "Opção 3";
    private String opcao4Padrao = "Opção 4";
    private String opcao5Padrao = "Opção 5 (-)";
    private String opcao6Padrao = "Opção 6 (+)";
    private String opcao7Padrao = "Opção 7";
    private String opcao8Padrao = "Opção 8 (-)";
    private String botaoMais = "(+)";
    private String botaoMenos = "(-)";

    @Before
    public void acessaFormulario() {
        aguardar(1);
        menu.scroll(0.9, 0.1);
        menu.acessarSwipeList();
    }

    @Test
    public void deve_resetar_tudo() {
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao1Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao2Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao3Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao4Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao5Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao6Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao7Padrao)), 0.1, 0.9);
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao8Padrao)), 0.1, 0.9);

        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 1"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 2"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 3"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 4"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 5"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 6"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 7"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 8"));
        aguardar(3);
    }

    @Test
    public void deve_somar_tudo() {
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao1Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao2Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao3Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao4Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao5Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao6Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao7Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao8Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));

        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 1 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 2 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 3 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 4 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 5 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 6 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 7 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 8 (+)"));
        aguardar(3);
    }

    @Test
    public void deve_subtrair_tudo() {
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao1Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao2Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao3Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao4Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao5Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao6Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao7Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao8Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));

        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 1 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 2 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 3 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 4 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 5 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 6 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 7 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 8 (-)"));
        aguardar(3);
    }

    @Test
    public void deve_somar_impares_tudo() {
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao1Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao2Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao3Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao4Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao5Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao6Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao7Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao8Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));

        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 1 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 2 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 3 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 4 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 5 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 6 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 7 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 8 (-)"));
        aguardar(3);
    }

    @Test
    public void deve_somar_pares_tudo() {
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao1Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao2Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao3Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao4Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao5Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao6Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao7Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMenos)));
        comum.swipeElement(comum.getElement(comum.byTextoFilho(opcao8Padrao)), 0.9, 0.1);
        comum.clicar(comum.getElement(comum.byTextoFilho(botaoMais)));

        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 1 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 2 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 3 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 4 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 5 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 6 (+)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 7 (-)"));
        Assert.assertTrue(comum.existeElementoPeloTexto("Opção 8 (+)"));
        aguardar(3);
    }
}
