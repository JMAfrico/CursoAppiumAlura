package com.alura.appium.CursoAppiumAlura;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;


public class FeatureCadastro 
{
	
    @Test
    public void cadastrarUsuarioSenhasNaoConferem() throws MalformedURLException
    {      	
    	AppiumDriverConfig config= new AppiumDriverConfig();
    	MobileElement txtUsuario = (MobileElement)config.driver.findElement(By.xpath("//*[@text ='Id do usuário']"));  
    	txtUsuario.sendKeys("joao");
        assertTrue( true );
    }
}
