package com.epam.pages;

import org.openqa.selenium.WebDriver;

import com.epam.driver.MiscFunctions;

public abstract class BasePage {
	protected WebDriver driver;
	protected static final int MINTIME = 10;
	protected MiscFunctions miscFunctions;
	
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		miscFunctions = new MiscFunctions(driver);
	}
	
	
	
	

}
