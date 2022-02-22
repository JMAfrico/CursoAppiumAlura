package com.alura.appium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject {

	private AppiumDriver driver;
	private WebDriverWait wait;
	private By txtLogin;
	private By txtSenha;
	private By btnLogin;
	private By btnCadastro;
	private By msgErroLogin;
	private By msgValidacaoLogin;
	
	public LoginPageObject(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		txtLogin = By.xpath("//*[@text ='Id do usuário']");
		txtSenha = By.xpath("//*[@text ='Senha']");
		btnLogin = By.xpath("//*[@text ='LOGAR']");
		btnCadastro = By.xpath("//*[@text = 'CADASTRAR USUÁRIO']");
		msgErroLogin = By.xpath("//*[@text ='Usuário ou senha inválidos']");
		msgValidacaoLogin = By.xpath("//*[@text ='Lista de produtos']");
	}
	
	public void PreencherFormularioLogin(String usuario,String senha) {
		WebElement login = driver.findElement(txtLogin);
		login.sendKeys(usuario);
		
		WebElement Senha= driver.findElement(txtSenha);
		Senha.sendKeys(senha);
	}
	
	public void ClicarBtnLogin() {
		WebElement BotaoLogin = driver.findElement(btnLogin);
		BotaoLogin.click();
	}
	
	public void ClicaBtnCadastro() {
		WebElement BotaoCadastro = driver.findElement(btnCadastro);
		BotaoCadastro.click();
	}
	
	public boolean ValidarMensagemLoginInvalido() {
		WebElement existe = wait.until(ExpectedConditions.presenceOfElementLocated(msgErroLogin));
		return existe.isDisplayed();
	}
	
	public boolean ValidarMensagemLoginValido() {
		WebElement existe = wait.until(ExpectedConditions.presenceOfElementLocated(msgValidacaoLogin));
		return existe.isDisplayed();
	}
	
}
