package unidad2.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import unidad2.utils.ClaseBase;
import unidad2.utils.Encoding;

import java.util.List;

public class LoginPages extends ClaseBase {
    //Agrupar los localizadores
    //mail
    By byTxtMail = By.id("emlInput");

    //PopUpCookie
    By byPUpCookie = By.id("js_btn_cookie");
    By byExtCookie = By.xpath("//button[contains(text(),\"Acepto\")]");

    //BTN CONTINUAR
    By byBtnContinuar = By.xpath("//button[@onclick='enviarCorreo();']");

    //Formulario 1era parte de la creacion de usuario
    By byTxtEncabezado = By.xpath("//h1[contains(text(),'Regístrate en Sucursal Virtual')]");

    By byTxtNomb = By.id("txtNombre");
    By byTxtApell = By.id("txtApellido");
    By byRdDoc = By.id("tipoDocumento");

    By byTxtDoc = By.id("ndoc");
    By byTxtCell = By.id("txtCelular");

    By byTxtComuna = By.id("txtComuna");
    // id calle: txtCalle
    By byTxtCall = By.id("txtCalle");
    // id num calle: txtNumCalle
    By byTxtNumCall = By.id("txtNumCalle");
    // id Dpto/CASa: txtDptoCasa
    By byTxtDptoCasa = By.id("txtDptoCasa");
    // btn continuar: //div[@class='btn-container-continuar']
    By byBtnContinuar2 = By.xpath("//div[@class='btn-container-continuar']");

    //2da parte de la creación de usuario
    By byTxtPass = By.id("nuevoPass");
    By byRepTxtPass = By.id("repetirNuevoPass");
    By byBtnRegPass = By.id("btnRegistraClave");

    //3era parte
    By byBtnEntendido = By.id("btnEntendido");
    By byRdAliado = By.id("rdAliado");
    By byBtnContAliad = By.id("btnContinuarAliado");

    //4ta parte
    By byRutEmp = By.id("txtRutEmprendimiento");
    By byEntendido2 = By.id("btnEntendido2");
    By byTxtNomEmp = By.id("txtNombreEmprendimiento");
    By bySelRubr = By.id("select-rubro");
    By byRubSel = By.xpath("//div[@attr-id='Alimentos']");
    By byTxtMailEmp = By.id("txtMailEmprendimiento");
    By byBtnAliadEmp = By.id("btnAliadoEmprendimiento");
    By byEncabezadoAl = By.xpath("//p[contains(text(),'Tienes convenios')]");

    By byEntendido3 = By.id("btnEntendido3");
    By bySlcConv = By.id("select-convenio");
    By byConvSlc = By.xpath("//div[@attr-id='18']");
    By byConvSlc1 = By.xpath("//div[@attr-id='14']");
    By byRdVEmp = By.id("rdVitrinaEmprendimiento");
    By byBtnModalEnt = By.id("btn-modal-entendido");
    By byNAld = By.xpath("//input[@class='rdAliado input']");
    By byChkTermEmp = By.id("chkTerminosEmprendimiento");
    By byChkAcpTerm = By.id("chkAceptoTerminos");

    By byBtnConvEmp = By.id("btnConveniosEmprendimiento");
    By byBtnNAliado = By.id("btnContinuarAliado");
    By assTxt = By.xpath("//h2[@class='titulo']");


    //Definir las acciones de la pagina
    public LoginPages(WebDriver driver) {
        super(driver);
    }

    public void IngresarMail(String mail) {
        esperarXSegundos(1000);
        if (estaDesplegado(byExtCookie)) {
            click(esperaExplicita(byExtCookie));
        }
        agregarTexto(esperaExplicita(byTxtMail), mail);
        //click(esperaExplicita(byPUpCookie));
        click(esperaExplicita(byBtnContinuar));

    }

    public void RegAlianza(String mail, String nom, String apell, int doc, String nDoc, String cell, String comuna, String calle, String numCall, String depCas, String pass, String repPass, int rdAl, String rutEmp, String nomEmp, String mailEmp, String conv, int vit, boolean chkTerm, boolean chk) {

        esperarXSegundos(1000);

        if (estaDesplegado(byPUpCookie)) {
            click(esperaExplicita(byPUpCookie));
        }
        esperarXSegundos(1000);
        agregarTexto(esperaExplicita(byTxtMail), mail);
        click(esperaExplicita(byPUpCookie));
        click(esperaExplicita(byBtnContinuar));
        agregarTexto(esperaExplicita(byTxtNomb), nom);
        agregarTexto(esperaExplicita(byTxtApell), apell);
        List<WebElement> tipDoc = buscarElementosWeb(byRdDoc);
        click(tipDoc.get(doc));
        agregarTexto(esperaExplicita(byTxtDoc), nDoc);
        agregarTexto(esperaExplicita(byTxtCell), cell);
        agregarTexto(esperaExplicita(byTxtComuna), comuna);
        agregarTexto(esperaExplicita(byTxtCall), calle);
        agregarTexto(esperaExplicita(byTxtNumCall), numCall);
        agregarTexto(esperaExplicita(byTxtDptoCasa), depCas);
        click(esperaExplicita(byBtnContinuar2));
        agregarTexto(esperaExplicita(byTxtPass), pass);
        agregarTexto(esperaExplicita(byRepTxtPass), repPass);
        click(esperaExplicita(byBtnRegPass));
        if (estaDesplegado(byBtnEntendido)) {
            click(esperaExplicita(byBtnEntendido));
        }
        List<WebElement> rdAliado = buscarElementosWeb(byRdAliado);
        click(rdAliado.get(rdAl));
        click(esperaExplicita(byBtnContAliad));
        agregarTexto(esperaExplicita(byRutEmp), rutEmp);
        if (estaDesplegado(byEntendido2)) {
            click(esperaExplicita(byEntendido2));
        }
        agregarTexto(esperaExplicita(byTxtNomEmp), nomEmp);
        click(esperaExplicita(bySelRubr));
        click(byRubSel);
        agregarTexto(esperaExplicita(byTxtMailEmp), mailEmp);
        click(esperaExplicita(byBtnAliadEmp));


       /* List<WebElement> checks = buscarElementosWeb();
        if(chkTerm){
            click(ch.get(0));
        }

        if(chkShareData){
            click(checks.get(1));
        }

        */


    }

    public void RegAlianzaConV(String mail, String nom, String apell, int doc, String nDoc, String cell, String comuna, String calle, String numCall, String depCas, String pass, String repPass, int rdAl, String rutEmp, String nomEmp, String mailEmp, String conv, int vit, boolean chkTerm, boolean chk) {

        esperarXSegundos(1000);
        if (estaDesplegado(byPUpCookie)) {
            click(esperaExplicita(byPUpCookie));
        }
        agregarTexto(esperaExplicita(byTxtMail), mail);
        //click(esperaExplicita(byPUpCookie));
        click(esperaExplicita(byBtnContinuar));
        agregarTexto(esperaExplicita(byTxtNomb), nom);
        agregarTexto(esperaExplicita(byTxtApell), apell);
        List<WebElement> tipDoc = buscarElementosWeb(byRdDoc);
        click(tipDoc.get(doc));
        agregarTexto(esperaExplicita(byTxtDoc), nDoc);
        agregarTexto(esperaExplicita(byTxtCell), cell);
        agregarTexto(esperaExplicita(byTxtComuna), comuna);
        agregarTexto(esperaExplicita(byTxtCall), calle);
        agregarTexto(esperaExplicita(byTxtNumCall), numCall);
        agregarTexto(esperaExplicita(byTxtDptoCasa), depCas);
        click(esperaExplicita(byBtnContinuar2));
        agregarTexto(esperaExplicita(byTxtPass), pass);
        agregarTexto(esperaExplicita(byRepTxtPass), repPass);
        click(esperaExplicita(byBtnRegPass));
        if (estaDesplegado(byBtnEntendido)) {
            click(esperaExplicita(byBtnEntendido));
        }
        List<WebElement> rdAliado = buscarElementosWeb(byRdAliado);
        click(rdAliado.get(rdAl));
        click(esperaExplicita(byBtnContAliad));
        agregarTexto(esperaExplicita(byRutEmp), rutEmp);
        if (estaDesplegado(byEntendido2)) {
            click(esperaExplicita(byEntendido2));
        }
        agregarTexto(esperaExplicita(byTxtNomEmp), nomEmp);
        click(esperaExplicita(bySelRubr));
        click(byRubSel);
        agregarTexto(esperaExplicita(byTxtMailEmp), mailEmp);
        click(esperaExplicita(byBtnAliadEmp));
        //6ta pag
        if (estaDesplegado(byEntendido3)) {
            click(esperaExplicita(byEntendido3));
        }

        click(esperaExplicita(bySlcConv));
        click(esperaExplicita(byConvSlc));
        List<WebElement> vitEmp = buscarElementosWeb(byRdVEmp);
        click(vitEmp.get(vit));
        if (estaDesplegado(byBtnModalEnt)) {
            click(esperaExplicita(byBtnModalEnt));
        }

        List<WebElement> checks = buscarElementosWeb(byChkTermEmp);
        if (chkTerm) {
            click(checks.get(0));
        }
       /* List<WebElement> checks1 = buscarElementosWeb(ck);
        if(chk){
            click(checks.get(1));
        }*/

        click(esperaExplicita(byBtnConvEmp));

    }

    public void RegAlianzaSinV(String mail, String nom, String apell, int doc, String nDoc, String cell, String comuna, String calle, String numCall, String depCas, String pass, String repPass, int rdAl, String rutEmp, String nomEmp, String mailEmp, String conv, int vit, boolean chkTerm, boolean chk) {

        esperarXSegundos(1000);
        if (estaDesplegado(byPUpCookie)) {
            click(esperaExplicita(byPUpCookie));
        }
        agregarTexto(esperaExplicita(byTxtMail), mail);
        //click(esperaExplicita(byPUpCookie));
        click(esperaExplicita(byBtnContinuar));
        agregarTexto(esperaExplicita(byTxtNomb), nom);
        agregarTexto(esperaExplicita(byTxtApell), apell);
        List<WebElement> tipDoc = buscarElementosWeb(byRdDoc);
        click(tipDoc.get(doc));
        agregarTexto(esperaExplicita(byTxtDoc), nDoc);
        agregarTexto(esperaExplicita(byTxtCell), cell);
        agregarTexto(esperaExplicita(byTxtComuna), comuna);
        agregarTexto(esperaExplicita(byTxtCall), calle);
        agregarTexto(esperaExplicita(byTxtNumCall), numCall);
        agregarTexto(esperaExplicita(byTxtDptoCasa), depCas);
        click(esperaExplicita(byBtnContinuar2));
        agregarTexto(esperaExplicita(byTxtPass), pass);
        agregarTexto(esperaExplicita(byRepTxtPass), repPass);
        click(esperaExplicita(byBtnRegPass));
        if (estaDesplegado(byBtnEntendido)) {
            click(esperaExplicita(byBtnEntendido));
        }
        List<WebElement> rdAliado = buscarElementosWeb(byRdAliado);
        click(rdAliado.get(rdAl));
        click(esperaExplicita(byBtnContAliad));
        agregarTexto(esperaExplicita(byRutEmp), rutEmp);
        if (estaDesplegado(byEntendido2)) {
            click(esperaExplicita(byEntendido2));
        }
        agregarTexto(esperaExplicita(byTxtNomEmp), nomEmp);
        click(esperaExplicita(bySelRubr));
        click(byRubSel);
        agregarTexto(esperaExplicita(byTxtMailEmp), mailEmp);
        click(esperaExplicita(byBtnAliadEmp));
        //6ta pag
        if (estaDesplegado(byEntendido3)) {
            click(esperaExplicita(byEntendido3));
        }

        click(esperaExplicita(bySlcConv));
        click(esperaExplicita(byConvSlc));
        List<WebElement> vitEmp = buscarElementosWeb(byRdVEmp);
        click(vitEmp.get(vit));
        if (estaDesplegado(byBtnModalEnt)) {
            click(esperaExplicita(byBtnModalEnt));
        }

        List<WebElement> checks = buscarElementosWeb(byChkTermEmp);
        if (chkTerm) {
            click(checks.get(0));
        }
       /* List<WebElement> checks1 = buscarElementosWeb(ck);
        if(chk){
            click(checks.get(1));
        }*/

        click(esperaExplicita(byBtnConvEmp));

    }

    public void RegNoAlianza(String mail, String nom, String apell, int doc, String nDoc, String cell, String comuna, String calle, String numCall, String depCas, String pass, String repPass, int rdAl, boolean chkTerm, boolean chk) {

        esperarXSegundos(1000);
        if (estaDesplegado(byPUpCookie)) {
            click(esperaExplicita(byPUpCookie));
        }
        agregarTexto(esperaExplicita(byTxtMail), mail);
        //click(esperaExplicita(byPUpCookie));
        click(esperaExplicita(byBtnContinuar));
        agregarTexto(esperaExplicita(byTxtNomb), nom);
        agregarTexto(esperaExplicita(byTxtApell), apell);
        List<WebElement> tipDoc = buscarElementosWeb(byRdDoc);
        click(tipDoc.get(doc));
        agregarTexto(esperaExplicita(byTxtDoc), nDoc);
        agregarTexto(esperaExplicita(byTxtCell), cell);
        agregarTexto(esperaExplicita(byTxtComuna), comuna);
        agregarTexto(esperaExplicita(byTxtCall), calle);
        agregarTexto(esperaExplicita(byTxtNumCall), numCall);
        agregarTexto(esperaExplicita(byTxtDptoCasa), depCas);
        click(esperaExplicita(byBtnContinuar2));
        agregarTexto(esperaExplicita(byTxtPass), pass);
        agregarTexto(esperaExplicita(byRepTxtPass), repPass);
        click(esperaExplicita(byBtnRegPass));
        if (estaDesplegado(byBtnEntendido)) {
            click(esperaExplicita(byBtnEntendido));
        }
        List<WebElement> rdAliado = buscarElementosWeb(byRdAliado);
        click(rdAliado.get(rdAl));
        List<WebElement> checks = buscarElementosWeb(byChkAcpTerm);
        if (chkTerm) {
            click(checks.get(0));
            click(esperaExplicita(byBtnNAliado));
        }
        /*click(esperaExplicita(byBtnContAliad));
        agregarTexto(esperaExplicita(byRutEmp),rutEmp);
        if (estaDesplegado(byEntendido2)){
            click(esperaExplicita(byEntendido2));
        }
        agregarTexto(esperaExplicita(byTxtNomEmp),nomEmp);
        click(esperaExplicita(bySelRubr));
        click(byRubSel);
        agregarTexto(esperaExplicita(byTxtMailEmp),mailEmp);
        click(esperaExplicita(byBtnAliadEmp));
        //6ta pag
        if (estaDesplegado(byEntendido3)){
            click(esperaExplicita(byEntendido3));
        }

        click(esperaExplicita(bySlcConv));
        click(esperaExplicita(byConvSlc));
        List<WebElement> vitEmp = buscarElementosWeb(byRdVEmp);
        click(vitEmp.get(vit));
        if (estaDesplegado(byBtnModalEnt))
        {
            click(esperaExplicita(byBtnModalEnt));
        }*/

       /* List<WebElement> checks = buscarElementosWeb(byChkTermEmp);
        if(chkTerm){
            click(checks.get(0));
        }
       /* List<WebElement> checks1 = buscarElementosWeb(ck);
        if(chk){
            click(checks.get(1));
        }*/

        click(esperaExplicita(byBtnConvEmp));

    }


    public String obtenerEncabezado() {
        return obtenerTexto(esperaExplicita(byEncabezadoAl));
    }

    public String obtenerTxtFinal() {
        return obtenerTexto(esperaExplicita(assTxt));
    }


    public void RegConCondiciones(String mail, String nom, String apell, int doc, String nDoc, String cell, String comuna, String calle, String numCall, String depCas, String pass, String repPass, int rdAl, String rutEmp, String nomEmp, String mailEmp, String conv, int vit, boolean chkTerm, boolean chk) {

        esperarXSegundos(1500);

        if (estaDesplegado(byPUpCookie)) {
            click(esperaExplicita(byPUpCookie));
        }
        esperarXSegundos(1000);
        agregarTexto(esperaExplicita(byTxtMail), mail);
        //click(esperaExplicita(byPUpCookie));
        click(esperaExplicita(byBtnContinuar));
        agregarTexto(esperaExplicita(byTxtNomb), nom);
        agregarTexto(esperaExplicita(byTxtApell), apell);
        List<WebElement> tipDoc = buscarElementosWeb(byRdDoc);
        click(tipDoc.get(doc));
        agregarTexto(esperaExplicita(byTxtDoc), nDoc);
        agregarTexto(esperaExplicita(byTxtCell), cell);
        agregarTexto(esperaExplicita(byTxtComuna), comuna);
        agregarTexto(esperaExplicita(byTxtCall), calle);
        agregarTexto(esperaExplicita(byTxtNumCall), numCall);
        agregarTexto(esperaExplicita(byTxtDptoCasa), depCas);
        click(esperaExplicita(byBtnContinuar2));
        agregarTexto(esperaExplicita(byTxtPass), pass);
        agregarTexto(esperaExplicita(byRepTxtPass), repPass);
        click(esperaExplicita(byBtnRegPass));
        if (estaDesplegado(byBtnEntendido)) {
            click(esperaExplicita(byBtnEntendido));
        }
        List<WebElement> rdAliado = buscarElementosWeb(byRdAliado);
        if (rdAl == 0) {
            click(rdAliado.get(rdAl));
            click(esperaExplicita(byBtnContAliad));
            agregarTexto(esperaExplicita(byRutEmp), rutEmp);
            if (estaDesplegado(byEntendido2)) {
                click(esperaExplicita(byEntendido2));
            }
            agregarTexto(esperaExplicita(byTxtNomEmp), nomEmp);
            click(esperaExplicita(bySelRubr));
            click(byRubSel);
            agregarTexto(esperaExplicita(byTxtMailEmp), mailEmp);
            click(esperaExplicita(byBtnAliadEmp));
            //6ta pag
            if (estaDesplegado(byEntendido3)) {
                click(esperaExplicita(byEntendido3));
            }

            click(esperaExplicita(bySlcConv));
            click(esperaExplicita(byConvSlc1));
            List<WebElement> vitEmp = buscarElementosWeb(byRdVEmp);
            click(vitEmp.get(vit));
            if (estaDesplegado(byBtnModalEnt)) {
                click(esperaExplicita(byBtnModalEnt));
            }
            List<WebElement> checks = buscarElementosWeb(byChkTermEmp);
            if (chkTerm) {
                click(checks.get(0));
            }
       /* List<WebElement> checks1 = buscarElementosWeb(ck);
        if(chk){
            click(checks.get(1));
        }*/

            click(esperaExplicita(byBtnConvEmp));

        } else if (rdAl == 1) {
            click(rdAliado.get(rdAl));
            List<WebElement> checks = buscarElementosWeb(byChkAcpTerm);
            if (chkTerm) {
                click(checks.get(0));
                click(esperaExplicita(byBtnNAliado));
            }

        }
    }
}
