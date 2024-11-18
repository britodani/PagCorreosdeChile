package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import unidad2.utils.ClaseBase;

import java.util.List;

public class CotPages extends ClaseBase {
    //Agrupar los localizadores
    By byCerrPUp = By.id("js_btn_cookie");
    By byRdDoc = By.xpath("//label[@for=\"documento\"]");
    //WebElement txtdesde= driver.findElement(By.id("_Cotizador_INSTANCE_l0psINRsg4hg_origen"));
    By byTxtDesde = By.id("_Cotizador_INSTANCE_l0psINRsg4hg_origen");
    By byTxtDest = By.id("_Cotizador_INSTANCE_l0psINRsg4hg_destino");
    By byTxtPeso = By.id("_Cotizador_INSTANCE_l0psINRsg4hg_peso");
    By byBtnEnvFor = By.xpath("//a[@onclick=\"enviarFormulario();\"]");


    //para assertion
    By byResEsp = By.xpath("//h5[contains(text(),\"Resumen de tu\")]");


    //Definir las acciones de la pagina
    public CotPages(WebDriver driver) {
        super(driver);
    }

    public void LLenFor(int tipEnv, String desde, String dest, String peso){
        List<WebElement> tipEnvio = buscarElementosWeb(byRdDoc);
        click(tipEnvio.get(tipEnv));

        esperarXSegundos(1000);
        if (estaDesplegado(byCerrPUp)){
            click(esperaExplicita(byCerrPUp));
        }

        //scrollToElement(txtdesde);*/
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
        agregarTexto(esperaExplicita(byTxtDesde),desde);
        agregarTexto(esperaExplicita(byTxtDest),dest);
        agregarTexto(esperaExplicita(byTxtPeso),peso);
        click(esperaExplicita(byBtnEnvFor));
    }
}
