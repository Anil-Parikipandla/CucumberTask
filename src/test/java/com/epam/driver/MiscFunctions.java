package com.epam.driver;

import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.pages.BasePage;

public class MiscFunctions extends BasePage{

	public MiscFunctions(WebDriver driver) {
		super(driver);
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
	}

	public void waitForElementVisible(WebElement webElement)
	{
		WebDriverWait wait = (new WebDriverWait( driver,MINTIME));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void scrollToElement(WebElement webElement)
	{
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", webElement);
	}




}
