package unidad2.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import unidad2.pages.CotPages;
import unidad2.pages.HomePages;
import unidad2.pages.LoginPages;
import unidad2.utils.Encoding;

public class Tests {
    //Instanciar objetos de las page's
    private WebDriver driver;
    // ArrayList<String> data;
    private HomePages homePage;
    private LoginPages loginPage;
    private CotPages cotPages;
    static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver32.exe";

    @BeforeEach
    public void preCondiciones(){
        //Preparo el driver y las page's
        homePage = new HomePages(driver);
        homePage.conexionDriver("Chrome",rutaDriver,"webdriver.chrome.driver");
        loginPage = new LoginPages(homePage.getDriver());
        cotPages = new CotPages(homePage.getDriver());
        homePage.cargarSitio("https://www.correos.cl/");
        homePage.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){

    }


    @Test
    public void CP001_REGUSU_ALIANZA(){
        homePage.ingresar();
        loginPage.RegAlianza("cualquiercosa@algo.cl","Daniela","Brito",0,"24461571-6","+56945787233", "huasco","llanos de challes","23","Casa","Algo123456","Algo123456",0,"","Cualquier","cualquiercosa@algo.cl","Convenio",0,true,false);
        Assertions.assertEquals(Encoding.corregirEncoding("¿Tienes convenios asociados a tu empredimiento?")
                ,loginPage.obtenerEncabezado());

    }

    @Test
    public void CP002_REGUSU_ALIANZA_CON_VIT(){
        homePage.ingresar();
        loginPage.RegConCondiciones("cualquiercosa@algo.cl","Daniela","Brito",1,"24461571-6","+56945787233", "huasco","llanos de challes","23","Casa","Algo123456","Algo123456",0,"24461571-6","Cualquier","cualquiercosa@algo.cl","Convenio",0,true,false);
        Assertions.assertEquals(Encoding.corregirEncoding("Para finalizar verifica tu mail")
                ,loginPage.obtenerTxtFinal());

    }

    @Test
    public void CP003_REGUSU_ALIANZA_SIN_VIT(){
        homePage.ingresar();
        loginPage.RegConCondiciones("cualquiercosa@algo.cl","Daniela","Brito",1,"24461571-6","+56945787233", "huasco","llanos de challes","23","Casa","Algo123456","Algo123456",0,"24461571-6","Cualquier","cualquiercosa@algo.cl","Convenio",1,true,false);
        Assertions.assertEquals(Encoding.corregirEncoding("Para finalizar verifica tu mail")
                ,loginPage.obtenerTxtFinal());

    }

    @Test
    public void CP004_REGUSU_NO_ALIANZA(){
        homePage.ingresar();
        loginPage.RegConCondiciones("cualquiercosa@algo.cl","Daniela","Brito",0,"24461571-6","+56945787233", "huasco","llanos de challes","23","Casa","Algo123456","Algo123456",1, "24461571-6","Cualquier","cualquiercosa@algo.cl","Convenio",1,true,false);
        Assertions.assertEquals(Encoding.corregirEncoding("Para finalizar verifica tu mail")
                ,loginPage.obtenerTxtFinal());

    }

    @Test
    public void CP005_COTIZAR_ENV(){
        homePage.irACotizar();
        cotPages.LLenFor(0,"Santiago","huasco","15");
    }


}
