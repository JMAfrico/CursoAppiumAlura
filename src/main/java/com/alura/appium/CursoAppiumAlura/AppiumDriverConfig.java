package com.alura.appium.CursoAppiumAlura;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppiumDriverConfig {
	
	public AppiumDriver<MobileElement> driver;
	
	private static AppiumDriverConfig getInstance;
	
	public static AppiumDriverConfig Instance() {
		if(AppiumDriverConfig.getInstance == null) {
			AppiumDriverConfig.getInstance = new  AppiumDriverConfig();
		}
		return AppiumDriverConfig.getInstance;
	}
	
	private AppiumDriverConfig() {
		
		File apk = new File("C:\\Aprendizado\\Cursos Java\\CursoAppiumAlura\\src\\main\\resources\\alura_esporte.apk");		
        
		DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        
		URL URLConexao = null;
		try {
			URLConexao = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}

		driver = new AppiumDriver<>(URLConexao,configuracoes);
	}
	
	//@org.junit.After
	//public void tearDown() {
	//	driver.close();
	//	driver.quit();
	//}


}
