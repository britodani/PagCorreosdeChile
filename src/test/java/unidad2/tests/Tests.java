package unidad2.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import unidad2.pages.CotPages;
import unidad2.pages.HomePages;
import unidad2.pages.LoginPages;
import unidad2.utils.DataDriven;
import unidad2.utils.Encoding;
import unidad2.utils.Propertiesdriven;

import java.util.ArrayList;
import java.util.Properties;

public class Tests {
    //Instanciar objetos de las page's
    private WebDriver driver;
    ArrayList<String> data;
    private HomePages homePage;
    private LoginPages loginPage;
    private CotPages cotPages;
    static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver32.exe";

    @BeforeEach
    public void preCondiciones(){
        //Preparo el driver y las page's
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        data = new ArrayList<String>();
        homePage = new HomePages(driver);
        //homePage.conexionDriver("Chrome",rutaDriver,"webdriver.chrome.driver");
        loginPage = new LoginPages(homePage.getDriver());
        cotPages = new CotPages(homePage.getDriver());
        homePage.cargarSitio(Propertiesdriven.obtenerProperty("url"));
        homePage.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){

    }


    @Test
    public void CP001_REGUSU_ALIANZA(){
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP001"));
        homePage.ingresar();
        loginPage.RegAlianza(data.get(1),data.get(2),data.get(3), Integer.parseInt(data.get(4)), data.get(5),data.get(6), data.get(7), data.get(8), data.get(9), data.get(10), data.get(11), data.get(12), Integer.parseInt(data.get(13)), data.get(14), data.get(15), data.get(16), data.get(17), Integer.parseInt(data.get(18)),Boolean.valueOf(data.get(19)),Boolean.valueOf(data.get(20)));
        Assertions.assertEquals(data.get(21)
                ,loginPage.obtenerEncabezado());

    }

    @Test
    public void CP002_REGUSU_ALIANZA_CON_VIT(){
        data = DataDriven.getTestData( Propertiesdriven.obtenerProperty("CP002"));
        homePage.ingresar();
        loginPage.RegConCondiciones(data.get(1),data.get(2),data.get(3), Integer.parseInt(data.get(4)), data.get(5),data.get(6), data.get(7), data.get(8), data.get(9), data.get(10), data.get(11), data.get(12), Integer.parseInt(data.get(13)), data.get(14), data.get(15), data.get(16), data.get(17), Integer.parseInt(data.get(18)),Boolean.valueOf(data.get(19)),Boolean.valueOf(data.get(20)));
        Assertions.assertEquals(Encoding.corregirEncoding(data.get(21))
                ,loginPage.obtenerTxtFinal());

    }

    @Test
    public void CP003_REGUSU_ALIANZA_SIN_VIT(){
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP003"));
        homePage.ingresar();
        loginPage.RegConCondiciones(data.get(1),data.get(2),data.get(3),Integer.parseInt(data.get(4)), data.get(5),data.get(6), data.get(7), data.get(8), data.get(9), data.get(10), data.get(11), data.get(12), Integer.parseInt(data.get(13)), data.get(14), data.get(15), data.get(16), data.get(17), Integer.parseInt(data.get(18)),Boolean.valueOf(data.get(19)),Boolean.valueOf(data.get(20)));
        Assertions.assertEquals(Encoding.corregirEncoding(data.get(21))
                ,loginPage.obtenerTxtFinal());

    }

    @Test
    public void CP004_REGUSU_NO_ALIANZA(){
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP004"));
        homePage.ingresar();
        loginPage.RegConCondiciones(data.get(1),data.get(2),data.get(3),Integer.parseInt(data.get(4)), data.get(5),data.get(6), data.get(7), data.get(8), data.get(9), data.get(10), data.get(11), data.get(12), Integer.parseInt(data.get(13)), data.get(14), data.get(15), data.get(16), data.get(17), Integer.parseInt(data.get(18)), Boolean.parseBoolean(data.get(19)),Boolean.parseBoolean(data.get(20)));
        Assertions.assertEquals(Encoding.corregirEncoding(data.get(21))
                ,loginPage.obtenerTxtFinal());

    }

    @Test
    public void CP005_COTIZAR_ENV(){
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP005"));
        homePage.irACotizar();
        cotPages.LLenFor(Integer.parseInt(data.get(1)),data.get(2),data.get(3),data.get(4));
        Assertions.assertEquals(data.get(5), cotPages.obtResp());
    }


}
