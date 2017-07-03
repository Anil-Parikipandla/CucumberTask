package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{


	@FindBy(xpath="//a[normalize-space(text())='Add to cart']")
	private WebElement AddToCart_Button;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ShoppingCartPage add_Product_To_Cart(){
		miscFunctions.WaitForClickableElement(AddToCart_Button);
		AddToCart_Button.click();
		return new ShoppingCartPage(driver);
	}
}
