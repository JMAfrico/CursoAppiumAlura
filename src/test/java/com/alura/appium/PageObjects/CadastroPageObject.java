package com.alura.appium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class CadastroPageObject {

	private AppiumDriver driver;
	private WebDriverWait wait;
	private By txtNovoUsuario;
	private By txtNovaSenha;
	private By txtConfirmaNovaSenha;
	private By btnCadastrarUsuario;
	private By msgErroCadastro;

	
	public CadastroPageObject(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);	
		msgErroCadastro = By.xpath("//*[@text ='Senhas não conferem']");
		txtNovoUsuario = By.id("br.com.alura.aluraesporte:id/input_nome");
		txtNovaSenha = By.id("br.com.alura.aluraesporte:id/input_senha");
		txtConfirmaNovaSenha = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		btnCadastrarUsuario = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
	}
			
	public void PreencherFormularioDeCadastro(String usuario,String senha, String confirmaSenha) {
		
		WebElement Usuario = driver.findElement(txtNovoUsuario);
		Usuario.sendKeys(usuario);
		
		WebElement Senha = driver.findElement(txtNovaSenha);
		Senha.sendKeys(senha);
		
		WebElement ConfirmaSenha = driver.findElement(txtConfirmaNovaSenha);
		ConfirmaSenha.sendKeys(confirmaSenha);

	}	
	
	public void ClicarBtnCadastrar() {
     	WebElement botaoCadastrar = driver.findElement(btnCadastrarUsuario);
     	botaoCadastrar.click();
	}
	
	public boolean ValidarMensagemCadastroInvalido() {	
		WebElement existe = wait.until(ExpectedConditions.presenceOfElementLocated(msgErroCadastro));
		return existe.isDisplayed();
	}
}
