package stolk.alecsandro.appium.pages.seu_barriga_nativo;

import org.openqa.selenium.By;
import stolk.alecsandro.appium.core.CommonPage;

import static java.lang.String.format;

public class HomePage extends CommonPage {

    public String getSaldoConta(String conta) {
        return texto(By.xpath(format("//*[@text='%s']/following-sibling::android.widget.TextView", conta)));
    }
}
