package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{
	@FindBy(id="ptcBtnRight")
	private WebElement ProceedToCheckout_Button;
	
	ShoppingCartPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAddedToCart(String productTitle)
	{	System.out.println("Checking for the Product: "+productTitle+"in the Cart.");
		return driver.findElement(By.partialLinkText(productTitle)).isEnabled();
	}
	
	
}
