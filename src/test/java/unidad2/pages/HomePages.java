package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class HomePages extends ClaseBase {
    //Agrupar los localizadores
    //ingresar
    By byBtnIngresar =By.xpath("//a[@class='ingresar-correo text-link d-lg-flex d-none']");

    //cotizar
    By byCotiza = By.xpath("//a[@href='/cotizador']");


    //Definir las acciones de la pagina
    public HomePages(WebDriver driver) {
        super(driver);
    }

    //ACCIONES
    public void ingresar(){

        click(esperaExplicita(byBtnIngresar));

    }

    public void irACotizar(){
        click(esperaExplicita(byCotiza));
    }


}
