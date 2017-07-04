package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{


	@FindBy(xpath = "//a[normalize-space(text())='Add to cart']")
	private WebElement AddToCart_Button;
	
	@FindBy(xpath = "//*[@id='itemTitle']")
	private WebElement productTitle;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getProductTitle(){
		waitForElementVisible(productTitle);
		System.out.println("Product Title is:" + productTitle.getText());
		return productTitle.getText();
	}
	
	public ShoppingCartPage addProductToCart(){
		WaitForClickableElement(AddToCart_Button);
		AddToCart_Button.click();
		System.out.println("Clicked on Add To Cart button.");
		return new ShoppingCartPage(driver);
	}
	
}
