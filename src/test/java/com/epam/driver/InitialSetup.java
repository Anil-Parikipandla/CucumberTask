package com.epam.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitialSetup {
	private static WebDriver driver ;
	public static final int MINTIME = 10;

	public static void OpenBroswer(String browserName){
		driver = new ChromeDriver();
	}

	public static WebDriver getDriver(){
		return driver;
	}

	public static void CloseBrowser(){
		if(driver!=null)
		{
			driver.close();
			driver.quit();
			driver = null;
		}

	}

	public static void goToUrl(String url){
		driver.manage().timeouts().implicitlyWait(MINTIME, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
}
