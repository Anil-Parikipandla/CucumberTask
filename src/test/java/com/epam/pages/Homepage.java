package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {
	
	@FindBy(xpath = "//input[@id='gh-ac']")
	private WebElement SearchBar;
	
	@FindBy(xpath = "//input[@type='submit']" )
	private WebElement SearchButton;
	
	@FindBy(xpath = "(//*[@id='Results']//*[@id='ResultSetItems']//li[starts-with(@id,'item')])[1]//a")	
	private WebElement firstProduct;
	
	Homepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void searchForProduct(String NameOfProduct){
		miscFunctions.WaitForClickableElement(SearchBar);
		SearchBar.clear();
		SearchBar.sendKeys(NameOfProduct);
		
		miscFunctions.WaitForClickableElement(SearchButton);
		SearchButton.click();
	}
	
	public ProductPage selectFirstProduct(){
		miscFunctions.WaitForClickableElement(firstProduct);
		firstProduct.click();
		return new ProductPage(driver);
	}
	
}