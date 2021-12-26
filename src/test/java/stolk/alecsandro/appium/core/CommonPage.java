package stolk.alecsandro.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.ActionOptions;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.List;

import static stolk.alecsandro.appium.core.DriverFactory.getDriver;

public class CommonPage {

    public void digitar(By by, String texto) {
        getElement(by).sendKeys(texto);
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicar(WebElement element) {
        element.click();
    }

    public void clicarNoTexto(String texto) {
        clicar(byTexto(texto));
    }

    public void clicarLongo(By by) {
        new TouchAction(getDriver())
                .longPress(new LongPressOptions()
                        .withElement(ElementOption.element(getDriver().findElement(by))))
                .perform();
    }

    public void tap(By by) {
        new TouchAction(getDriver())
                .tap(new TapOptions().withElement(ElementOption.element(getDriver().findElement(by))))
                .perform();
    }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width / 2;
        int yStart = (int) (size.height * inicio);
        int yEnd = (int) (size.height * fim);
        new TouchAction(getDriver())
                .press(PointOption.point(x, yStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, yEnd))
                .release()
                .perform();
    }

    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();
        int xStart = (int) (size.width * inicio);
        int xEnd = (int) (size.width * fim);
        int y = size.height / 2;
        new TouchAction(getDriver())
                .press(PointOption.point(xStart, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(xEnd, y))
                .release()
                .perform();
    }

    public void swipeElement(WebElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);
        int xStart = (int) (element.getSize().width * inicio);
        int xEnd = (int) (element.getSize().width * fim);

        new TouchAction(getDriver())
//                .press(ElementOption.element(element, xStart, y))
                .press(PointOption.point(xStart, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(ElementOption.element(element, xEnd, y))
                .moveTo(PointOption.point(xEnd, y))
                .release()
                .perform();
    }

    public void dragAndDrop(WebElement elementoOrigem, WebElement elementoDestino) {
        /*new Actions(getDriver())
                .clickAndHold(elementoOrigem)
                .dragAndDrop(elementoOrigem, elementoDestino)
                .release()
                .perform();*/
        new TouchAction(getDriver())
                .longPress(new LongPressOptions().withElement(new ElementOption().withElement(elementoOrigem)))
                .moveTo(new PointOption().withCoordinates(elementoDestino.getLocation()))
                .release()
                .perform();
    }

    public void singleTap(By by){
        WebElement element = getElement(by);
        TouchActions action = new TouchActions(getDriver());
        action.singleTap(element).perform();
    }

    public void doubleTap(By by){
        WebElement element = getElement(by);
        TouchActions action = new TouchActions(getDriver());
        action.doubleTap(element).perform();
    }

    public void tap(int x, int y) {
        new TouchAction(getDriver())
                .tap(PointOption.point(x, y))
//                .tap(PointOption.point(new Point(x, y)))
//                .tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y)))
//                .tap(TapOptions.tapOptions().withPosition(PointOption.point(new Point(x, y))))
                .perform();
    }

    public By byTexto(String texto) {
        return By.xpath(String.format("//*[@text='%s']", texto));
    }

    public By byTextoFilho(String texto) {
        return By.xpath(String.format("//*[@text='%s']/..", texto));
    }

    public By byId(String id) {
        return By.xpath(String.format(".//*[@id='%s']", id));
    }

    public WebElement getElement(By by) {
        return getDriver().findElement(by);
    }

    public List<MobileElement> getElements(By by) {
        return getDriver().findElements(by);
    }

    public MobileElement getElement(By by, int index) {
        return (MobileElement) getDriver().findElements(by).get(index - 1);
    }

    public void selecionarCombo(By by, String texto) {
        clicar(by);
        clicarNoTexto(texto);
    }

    public void selecionarCombo(MobileElement element, String texto) {
        clicar(element);
        clicarNoTexto(texto);
    }

    public Boolean isAtivo(By by) {
        return atributo(by, "checked").equals("true");
    }

    public String texto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String atributo(By by, String atributo) {
        return getDriver().findElement(by).getAttribute(atributo);
    }

    public boolean existeElementoPeloTexto(String texto) {
        List<MobileElement> elementos = getDriver().findElements(byTexto(texto));
        return elementos.size() > 0;
    }
}
