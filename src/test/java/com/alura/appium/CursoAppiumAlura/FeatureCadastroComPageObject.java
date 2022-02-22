package com.alura.appium.CursoAppiumAlura;

import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FeatureCadastroComPageObject 
{
	private AppiumDriver driver;
	private CadastroPageObject cadastroPage;
	private LoginPageObject loginPage;
	
	public FeatureCadastroComPageObject() throws MalformedURLException {
		driver = AppiumDriverConfig.Instance().driver;
		cadastroPage = new CadastroPageObject(driver);
		loginPage = new LoginPageObject(driver);
	}
	
    @Test
    public void TentativaLoginUsuarioOuSenhaInvalido()
    {      	    
    	loginPage.PreencherFormularioLogin("teste", "5545"); 
    	loginPage.ClicarBtnLogin();
        Assert.assertTrue(loginPage.ValidarMensagemLoginInvalido());
        driver.closeApp();
    } 
    
    @Test
    public void EfetuarCadastro()
    {      
    	loginPage.ClicaBtnCadastro();;
    	cadastroPage.PreencherFormularioDeCadastro("joaozeras","joao12","joao12");
    	cadastroPage.ClicarBtnCadastrar();
    	loginPage.PreencherFormularioLogin("joaozeras", "joao12"); 
    	loginPage.ClicarBtnLogin();
        Assert.assertTrue(loginPage.ValidarMensagemLoginValido());
        driver.closeApp();

    }
    
    @Test
    public void EfetuarCadastroSenhasNaoConferem()
    {      
    	loginPage.ClicaBtnCadastro();
    	cadastroPage.PreencherFormularioDeCadastro("joaozf","joao","joao123");
    	cadastroPage.ClicarBtnCadastrar();
        Assert.assertTrue(cadastroPage.ValidarMensagemCadastroInvalido());
        driver.closeApp();
    }
}
