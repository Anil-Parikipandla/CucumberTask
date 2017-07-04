package com.epam.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected WebDriver driver;
	private static final int MINTIME = 10;
	
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isElementPresent(WebElement element)
	{
		boolean blnStatus = false;
		try{
			element.isEnabled();
			blnStatus = true;
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}

	public void WaitForClickableElement(WebElement webElement){
		WebDriverWait wait = new WebDriverWait(driver, MINTIME);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		System.out.println("Waiting for the element: "+webElement+"to be clickable.");
	}

	public void waitForElementVisible(WebElement webElement)
	{
		WebDriverWait wait = (new WebDriverWait( driver,MINTIME));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		System.out.println("Waiting for the element: "+webElement+"to be visible.");
	}
	
	public void scrollToElement(WebElement webElement)
	{
		JavascriptExecutor jsexe =(JavascriptExecutor) driver;
		jsexe.executeScript("arguments[0].scrollIntoView()", webElement);
		System.out.println("Scrolling the page to the element: "+webElement);
	}
	
	
	
	

}
