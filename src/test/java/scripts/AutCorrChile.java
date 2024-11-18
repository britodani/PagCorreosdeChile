package scripts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutCorrChile {
    //Atributos
    private static WebDriver driver;
    private static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver32.exe";
    private WebDriverWait wait;

    @BeforeEach
    public void preCondiciones(){
        //Enlazar el webDriver al browser de nuestro sistema
        System.setProperty("webdriver.chrome.driver",rutaDriver);
        //Instanciar el webdriver
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }

   /* @AfterEach
    public void posCondiciones(){
        driver.close();
    }*/

    @Test
    public void CP001_REG_USU_ALIANZA() throws  InterruptedException{
        //home
        driver.get("https://www.correos.cl/");

        driver.findElement(By.xpath("//a[@class='ingresar-correo text-link d-lg-flex d-none']")).click();

        //1page
            WebElement btnCerrarPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_btn_cookie")));

            if(btnCerrarPopUp.isDisplayed()){
                btnCerrarPopUp.click();
            }

            driver.findElement(By.id("emlInput")).sendKeys("cualquiercosa@algo.cl");
            driver.findElement(By.xpath("//button[@onclick='enviarCorreo();']")).click();

        //2page
            driver.findElement(By.id("txtNombre")).sendKeys("Cualquier");
            driver.findElement(By.id("txtApellido")).sendKeys("Cosa");

            List<WebElement> tipDoc = driver.findElements(By.id("tipoDocumento"));
            tipDoc.get(1).click();

            driver.findElement(By.id("ndoc")).sendKeys("24461571-6");
            driver.findElement(By.id("txtCelular")).sendKeys("917291272");

            //id comuna: txtComuna
            driver.findElement(By.id("txtComuna")).sendKeys("Huasco");
            // id calle: txtCalle
            driver.findElement(By.id("txtCalle")).sendKeys("llanos de challes");
            // id num calle: txtNumCalle
            driver.findElement(By.id("txtNumCalle")).sendKeys("23");
            // id Dpto/CASa: txtDptoCasa
            driver.findElement(By.id("txtDptoCasa")).sendKeys("Casa");
            // btn continuar: //div[@class='btn-container-continuar']
            driver.findElement(By.xpath("//div[@class='btn-container-continuar']")).click();

        //3era Pagina

            //id nuev contra: nuevoPass
            driver.findElement(By.id("nuevoPass")).sendKeys("Algo12342");
            //id rep cont: repetirNuevoPass
            driver.findElement(By.id("repetirNuevoPass")).sendKeys("Algo12342");
            // btn continuar: btnRegistraClave
            driver.findElement(By.id("btnRegistraClave")).click();

        //4ta pagina

            //mensaje de entendido id: btnEntendido
            //id rdSi/no: rdAliado
            WebElement btnCerrarPopUp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido")));

            if(btnCerrarPopUp4.isDisplayed()){
                btnCerrarPopUp4.click();
            }
            List<WebElement> empSiNo = driver.findElements(By.id("rdAliado"));
            empSiNo.get(0).click();
            driver.findElement(By.id("btnContinuarAliado")).click();

        //5TA Pagina
            //id rut: txtRutEmprendimiento
            driver.findElement(By.id("txtRutEmprendimiento")).sendKeys("24461571-6");
            //id entendido: btnEntendido2
            WebElement btnCerrarPopUp5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido2")));

            if(btnCerrarPopUp5.isDisplayed()){
                btnCerrarPopUp5.click();
            }
            //id nomb empr: txtNombreEmprendimiento
            driver.findElement(By.id("txtNombreEmprendimiento")).sendKeys("cualquier cosa");
            //id de cmbBox
            driver.findElement(By.id("select-rubro")).click();
            /*Select ddLRubro = new Select(driver.findElement(By.id("select-items")));

            ddLRubro.selectByVisibleText("Alimentos");*/
            driver.findElement(By.xpath("//div[@attr-id='Alimentos']")).click();

            //id mailEmp: txtMailEmprendimiento
            driver.findElement(By.id("txtMailEmprendimiento")).sendKeys("cualquiercosa1@algo.cl");
            //btn cont: btnAliadoEmprendimiento
            driver.findElement(By.id("btnAliadoEmprendimiento")).click();



      //6ta Pagina

        Assertions.assertEquals(corregirEncoding("¿Tienes convenios asociados a tu empredimiento?"),driver.findElement(By.xpath("//p[contains(text(),'Tienes')]")).getText());

    }

    @Test
    public void CP002_REG_USU_ALIANZA_CON_VITRINA() throws  InterruptedException{
        //home
        driver.get("https://www.correos.cl/");

        driver.findElement(By.xpath("//a[@class='ingresar-correo text-link d-lg-flex d-none']")).click();

        //1page
        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_btn_cookie")));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        driver.findElement(By.id("emlInput")).sendKeys("cualquiercosa@algo.cl");
        driver.findElement(By.xpath("//button[@onclick='enviarCorreo();']")).click();

        //2page
        driver.findElement(By.id("txtNombre")).sendKeys("Cualquier");
        driver.findElement(By.id("txtApellido")).sendKeys("Cosa");

        List<WebElement> tipDoc = driver.findElements(By.id("tipoDocumento"));
        tipDoc.get(1).click();

        driver.findElement(By.id("ndoc")).sendKeys("24461571-6");
        driver.findElement(By.id("txtCelular")).sendKeys("917291272");

        //id comuna: txtComuna
        driver.findElement(By.id("txtComuna")).sendKeys("Huasco");
        // id calle: txtCalle
        driver.findElement(By.id("txtCalle")).sendKeys("llanos de challes");
        // id num calle: txtNumCalle
        driver.findElement(By.id("txtNumCalle")).sendKeys("23");
        // id Dpto/CASa: txtDptoCasa
        driver.findElement(By.id("txtDptoCasa")).sendKeys("Casa");
        // btn continuar: //div[@class='btn-container-continuar']
        driver.findElement(By.xpath("//div[@class='btn-container-continuar']")).click();

        //3era Pagina

        //id nuev contra: nuevoPass
        driver.findElement(By.id("nuevoPass")).sendKeys("Algo12342");
        //id rep cont: repetirNuevoPass
        driver.findElement(By.id("repetirNuevoPass")).sendKeys("Algo12342");
        // btn continuar: btnRegistraClave
        driver.findElement(By.id("btnRegistraClave")).click();

        //4ta pagina

        //mensaje de entendido id: btnEntendido
        //id rdSi/no: rdAliado
        WebElement btnCerrarPopUp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido")));

        if(btnCerrarPopUp4.isDisplayed()){
            btnCerrarPopUp4.click();
        }
        List<WebElement> empSiNo = driver.findElements(By.id("rdAliado"));
        empSiNo.get(0).click();
        driver.findElement(By.id("btnContinuarAliado")).click();

        //5TA Pagina
        //id rut: txtRutEmprendimiento
        driver.findElement(By.id("txtRutEmprendimiento")).sendKeys("24461571-6");
        //id entendido: btnEntendido2
        WebElement btnCerrarPopUp5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido2")));

        if(btnCerrarPopUp5.isDisplayed()){
            btnCerrarPopUp5.click();
        }
        //id nomb empr: txtNombreEmprendimiento
        driver.findElement(By.id("txtNombreEmprendimiento")).sendKeys("cualquier cosa");
        //id de cmbBox
        driver.findElement(By.id("select-rubro")).click();
            /*Select ddLRubro = new Select(driver.findElement(By.id("select-items")));

            ddLRubro.selectByVisibleText("Alimentos");*/
        driver.findElement(By.xpath("//div[@attr-id='Alimentos']")).click();

        //id mailEmp: txtMailEmprendimiento
        driver.findElement(By.id("txtMailEmprendimiento")).sendKeys("cualquiercosa1@algo.cl");
        //btn cont: btnAliadoEmprendimiento
        driver.findElement(By.id("btnAliadoEmprendimiento")).click();

        //6ta Pagina
        //id entendido3: btnEntendido3
        WebElement btnCerrarPopUp6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido3")));

        if(btnCerrarPopUp6.isDisplayed()){
            btnCerrarPopUp6.click();
        }

        //id cmbBox: select-convenio
        driver.findElement(By.id("select-convenio")).click();
        driver.findElement(By.xpath("//div[@attr-id='18']")).click();

        List<WebElement> empVtrSiNo = driver.findElements(By.id("rdVitrinaEmprendimiento"));
        empVtrSiNo.get(0).click();
        driver.findElement(By.id("btn-modal-entendido")).click();
        driver.findElement(By.id("chkTerminosEmprendimiento")).click();
        driver.findElement(By.id("btnConveniosEmprendimiento")).click();



        String resultadoEsperado= "Para finalizar verifica tu mail";
        String resultadoActual = driver.findElement(By.xpath("//h2[@class='titulo']")).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }

    @Test
    public void CP003_REG_USU_ALIANZA_SIN_VITRINA() throws  InterruptedException{
        //home
        driver.get("https://www.correos.cl/");

        driver.findElement(By.xpath("//a[@class='ingresar-correo text-link d-lg-flex d-none']")).click();

        //1page
        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_btn_cookie")));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        driver.findElement(By.id("emlInput")).sendKeys("cualquiercosa@algo.cl");
        driver.findElement(By.xpath("//button[@onclick='enviarCorreo();']")).click();

        //2page
        driver.findElement(By.id("txtNombre")).sendKeys("Cualquier");
        driver.findElement(By.id("txtApellido")).sendKeys("Cosa");

        List<WebElement> tipDoc = driver.findElements(By.id("tipoDocumento"));
        tipDoc.get(1).click();

        driver.findElement(By.id("ndoc")).sendKeys("24461571-6");
        driver.findElement(By.id("txtCelular")).sendKeys("917291272");

        //id comuna: txtComuna
        driver.findElement(By.id("txtComuna")).sendKeys("Huasco");
        // id calle: txtCalle
        driver.findElement(By.id("txtCalle")).sendKeys("llanos de challes");
        // id num calle: txtNumCalle
        driver.findElement(By.id("txtNumCalle")).sendKeys("23");
        // id Dpto/CASa: txtDptoCasa
        driver.findElement(By.id("txtDptoCasa")).sendKeys("Casa");
        // btn continuar: //div[@class='btn-container-continuar']
        driver.findElement(By.xpath("//div[@class='btn-container-continuar']")).click();

        //3era Pagina

        //id nuev contra: nuevoPass
        driver.findElement(By.id("nuevoPass")).sendKeys("Algo12342");
        //id rep cont: repetirNuevoPass
        driver.findElement(By.id("repetirNuevoPass")).sendKeys("Algo12342");
        // btn continuar: btnRegistraClave
        driver.findElement(By.id("btnRegistraClave")).click();

        //4ta pagina

        //mensaje de entendido id: btnEntendido
        //id rdSi/no: rdAliado
        WebElement btnCerrarPopUp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido")));

        if(btnCerrarPopUp4.isDisplayed()){
            btnCerrarPopUp4.click();
        }
        List<WebElement> empSiNo = driver.findElements(By.id("rdAliado"));
        empSiNo.get(0).click();
        driver.findElement(By.id("btnContinuarAliado")).click();

        //5TA Pagina
        //id rut: txtRutEmprendimiento
        driver.findElement(By.id("txtRutEmprendimiento")).sendKeys("24461571-6");
        //id entendido: btnEntendido2
        WebElement btnCerrarPopUp5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido2")));

        if(btnCerrarPopUp5.isDisplayed()){
            btnCerrarPopUp5.click();
        }
        //id nomb empr: txtNombreEmprendimiento
        driver.findElement(By.id("txtNombreEmprendimiento")).sendKeys("cualquier cosa");
        //id de cmbBox
        driver.findElement(By.id("select-rubro")).click();
            /*Select ddLRubro = new Select(driver.findElement(By.id("select-items")));

            ddLRubro.selectByVisibleText("Alimentos");*/
        driver.findElement(By.xpath("//div[@attr-id='Alimentos']")).click();

        //id mailEmp: txtMailEmprendimiento
        driver.findElement(By.id("txtMailEmprendimiento")).sendKeys("cualquiercosa1@algo.cl");
        //btn cont: btnAliadoEmprendimiento
        driver.findElement(By.id("btnAliadoEmprendimiento")).click();

        //6ta Pagina

        //id entendido3: btnEntendido3
        WebElement btnCerrarPopUp6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido3")));

        if(btnCerrarPopUp6.isDisplayed()){
            btnCerrarPopUp6.click();
        }

        //id cmbBox: select-convenio
        driver.findElement(By.id("select-convenio")).click();
        driver.findElement(By.xpath("//div[@attr-id='14']")).click();

        //Rdio button
        List<WebElement> empVtrSiNo = driver.findElements(By.id("rdVitrinaEmprendimiento"));
        empVtrSiNo.get(1).click();
        //Chkbox terminos
        driver.findElement(By.id("chkTerminosEmprendimiento")).click();
        //boton continuar
        driver.findElement(By.id("btnConveniosEmprendimiento")).click();


        String resultadoEsperado= "Para finalizar verifica tu mail";
        String resultadoActual = driver.findElement(By.xpath("//h2[@class='titulo']")).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }

    @Test
    public void CP004_REG_USU_NO_ALIANZA() throws  InterruptedException{
        //home
        driver.get("https://www.correos.cl/");

        driver.findElement(By.xpath("//a[@class='ingresar-correo text-link d-lg-flex d-none']")).click();

        //1page
        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_btn_cookie")));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        driver.findElement(By.id("emlInput")).sendKeys("cualquiercosa@algo.cl");
        driver.findElement(By.xpath("//button[@onclick='enviarCorreo();']")).click();

        //2page
        driver.findElement(By.id("txtNombre")).sendKeys("Cualquier");
        driver.findElement(By.id("txtApellido")).sendKeys("Cosa");

        List<WebElement> tipDoc = driver.findElements(By.id("tipoDocumento"));
        tipDoc.get(1).click();

        driver.findElement(By.id("ndoc")).sendKeys("24461571-6");
        driver.findElement(By.id("txtCelular")).sendKeys("917291272");

        //id comuna: txtComuna
        driver.findElement(By.id("txtComuna")).sendKeys("Huasco");
        // id calle: txtCalle
        driver.findElement(By.id("txtCalle")).sendKeys("llanos de challes");
        // id num calle: txtNumCalle
        driver.findElement(By.id("txtNumCalle")).sendKeys("23");
        // id Dpto/CASa: txtDptoCasa
        driver.findElement(By.id("txtDptoCasa")).sendKeys("Casa");
        // btn continuar: //div[@class='btn-container-continuar']
        driver.findElement(By.xpath("//div[@class='btn-container-continuar']")).click();

        //3era Pagina

        //id nuev contra: nuevoPass
        driver.findElement(By.id("nuevoPass")).sendKeys("Algo12342");
        //id rep cont: repetirNuevoPass
        driver.findElement(By.id("repetirNuevoPass")).sendKeys("Algo12342");
        // btn continuar: btnRegistraClave
        driver.findElement(By.id("btnRegistraClave")).click();

        //4ta pagina

        //mensaje de entendido id: btnEntendido
        //id rdSi/no: rdAliado
            /*List<WebElement> empSiNo = driver.findElements(By.id("rdAliado"));
            empSiNo.get(1).click();
            //driver.findElement(By.id("btnContinuarAliado")).click();*/
        WebElement btnCerrarPopUp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEntendido")));

        if(btnCerrarPopUp4.isDisplayed()){
            btnCerrarPopUp4.click();
        }
        driver.findElement(By.xpath("//input[@class='rdAliado input']")).click();
        driver.findElement(By.id("chkAceptoTerminos")).click();
        driver.findElement(By.id("btnContinuarAliado")).click();

        String resultadoEsperado= "Para finalizar verifica tu mail";
        String resultadoActual = driver.findElement(By.xpath("//h2[@class='titulo']")).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }

    @Test
    public void CP005_COTIZAR() throws  InterruptedException{
        //home
        driver.get("https://www.correos.cl/");

        List<WebElement> slide = driver.findElements(By.xpath("//button[@role='button']"));
        slide.get(1).click();

        driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_TK6VYItwcoV7\"]/div/div[2]/div/div/div/div/div/div[1]/div/div[4]/div/div/a")).click();
        /*WebElement iframe;
        By byIFrame = By.id("myFrame");
        iframe = driver.findElement(byIFrame);
        driver.switchTo().frame(iframe);*/
        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_btn_cookie")));

        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }
        driver.findElement(By.xpath("//label[@for=\"documento\"]")).click();

        WebElement txtdesde= driver.findElement(By.id("_Cotizador_INSTANCE_l0psINRsg4hg_origen"));
        txtdesde.sendKeys("Huasco");

//        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtdesde);

        driver.findElement(By.id("_Cotizador_INSTANCE_l0psINRsg4hg_destino")).sendKeys("Santiago");
        driver.findElement(By.id("_Cotizador_INSTANCE_l0psINRsg4hg_peso")).sendKeys("15");
        driver.findElement(By.xpath("//a[@onclick=\"enviarFormulario();\"]")).click();

        String resultadoEsperado= "Resumen de tu envío";
        String resultadoActual = driver.findElement(By.xpath("//h5[contains(text(),\"Resumen de tu\")]")).getText();

        Assertions.assertEquals(corregirEncoding(resultadoEsperado),resultadoActual);
/*/Un momento, por favor...
        String resultadoEsperado= "Un momento, por favor...";
        String resultadoActual = driver.findElement(By.xpath("//h5[contains(text(),\"Resumen de tu\")]")).getText();

        Assertions.assertEquals(corregirEncoding(resultadoEsperado),resultadoActual);*/

    }


    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }
}


