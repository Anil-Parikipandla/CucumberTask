package com.epam.pages;

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
	
	
}
