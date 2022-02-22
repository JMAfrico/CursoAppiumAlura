package com.alura.appium.CursoAppiumAlura;

import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.alura.appium.PageObjects.CadastroPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FeatureCadastro 
{
	private AppiumDriver driver;

	public FeatureCadastro() throws MalformedURLException {
		driver = AppiumDriverConfig.Instance().driver;	
	}
	
    @Test
    public void TentativaLoginUsuarioOuSenhaInvalido()
    {      	    
    	driver.launchApp();
    	MobileElement txtUsuario = (MobileElement)driver.findElement(By.xpath("//*[@text ='Id do usuário']"));  
    	txtUsuario.sendKeys("joao");
    	
    	MobileElement txtSenha = (MobileElement)driver.findElement(By.xpath("//*[@text ='Senha']"));  
    	txtSenha.setValue("joao");
    	
    	MobileElement btnLogin = (MobileElement)driver.findElement(By.xpath("//*[@text ='LOGAR']"));
    	btnLogin.click();
    	
    	MobileElement lblMensagemLoginInvalido = (MobileElement)driver.findElement(By.xpath("//*[@text ='Usuário ou senha inválidos']"));
    	Boolean mensagem = lblMensagemLoginInvalido.isDisplayed();
    	
        Assert.assertTrue(mensagem);
    }
    
    @Test
    public void EfetuarCadastro()
    {      
    	driver.launchApp();
    	MobileElement btnCadastrar = (MobileElement)driver.findElement(By.xpath("//*[@text = 'CADASTRAR USUÁRIO']"));
    	btnCadastrar.click();
    	
    	MobileElement txtUsuario = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));  
    	txtUsuario.sendKeys("joaozeras");
    	
    	MobileElement txtSenha = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));  
    	txtSenha.sendKeys("joao12");
    	
    	MobileElement confirmaSenha = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));  
    	confirmaSenha.sendKeys("joao12");
    	
     	MobileElement btnCadastrarUsuario = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
    	btnCadastrarUsuario.click();
    
		MobileElement txtUsuarioLogin = (MobileElement)driver.findElement(By.xpath("//*[@text ='Id do usuário']"));  
		txtUsuarioLogin.sendKeys("joaozeras");
		
		MobileElement txtSenhaLogin = (MobileElement)driver.findElement(By.xpath("//*[@text ='Senha']"));  
		txtSenhaLogin.setValue("joao12");
		
    	MobileElement btnLogin = (MobileElement)driver.findElement(By.xpath("//*[@text ='LOGAR']"));
    	btnLogin.click();
    	
   	    MobileElement lblConfirmacaoLogin = (MobileElement)driver.findElement(By.xpath("//*[@text ='Lista de produtos']"));
    	Boolean mensagem = lblConfirmacaoLogin.isDisplayed();
    	
        Assert.assertTrue(mensagem);

    }
    
    @Test
    public void EfetuarCadastroSenhasNaoConferem()
    {      
    	driver.launchApp();
    	MobileElement btnCadastrar = (MobileElement)driver.findElement(By.xpath("//*[@text = 'CADASTRAR USUÁRIO']"));
    	btnCadastrar.click();
    	
    	MobileElement txtUsuario = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));  
    	txtUsuario.sendKeys("joao");
    	
    	MobileElement txtSenha = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));  
    	txtSenha.sendKeys("123");
    	
    	MobileElement confirmaSenha = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));  
    	confirmaSenha.sendKeys("123456");
    	
    	MobileElement btnCadastrarUsuario = (MobileElement)driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
    	btnCadastrarUsuario.click();
    	
   	    MobileElement lblMensagemLoginInvalido = (MobileElement)driver.findElement(By.xpath("//*[@text ='Senhas não conferem']"));
    	Boolean mensagem = lblMensagemLoginInvalido.isDisplayed();
    	
        Assert.assertTrue(mensagem);
        
    }
}
