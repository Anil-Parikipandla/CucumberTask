package com.epam.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.epam.driver.InitialSetup;
import com.epam.pages.Homepage;
import com.epam.pages.ProductPage;
import com.epam.pages.ShoppingCartPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCart {

	private static final String EBAY_URL = "http://www.ebay.com/";
	private static final String EXPECTED_PAGE_TITLE = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
	private String ProductTitle = "";
	private WebDriver driver;

	private Homepage Homepage;
	private ProductPage productPage;
	private ShoppingCartPage shoppingCartPage;

	@Given("^Chrome browser is open$")
	public void chrome_browser_is_open() {
		InitialSetup.OpenBroswer();
		driver = InitialSetup.getDriver();
	}

	@Parameters({ "url" })
	@Given("^Ebay Homepage is launched$")
	public void ebay_Homepage_is_launched() {
		InitialSetup.goToUrl(EBAY_URL);
		Homepage = new Homepage(driver);
		Assert.assertEquals(EXPECTED_PAGE_TITLE, driver.getTitle(), "Ebay HomePage is not launched");
	}

	@When("^we search for parker pen$")
	public void we_search_for_parker_pen() {
		Homepage.searchForProduct("parker pen");
		productPage = Homepage.selectFirstProduct();
	}

	@When("^add it to cart$")
	public void add_it_to_cart() {
		ProductTitle = productPage.getProductTitle();
		shoppingCartPage = productPage.addProductToCart();
	}

	@Then("^parker pen should be added and displayed in the cart$")
	public void parker_pen_should_be_added_and_displayed_in_the_cart() throws Throwable {
		Assert.assertTrue(shoppingCartPage.isProductAddedToCart(ProductTitle), "Product is not Found in the Cart");
		System.out.println("Product Found in the Cart.");
		InitialSetup.CloseBrowser();
	}

	@When("^we search for \"([^\"]*)\"$")
	public void we_search_for(String product) {
		Homepage.searchForProduct(product);
		productPage = Homepage.selectFirstProduct();
	}

	@Then("^\"([^\"]*)\" should be added and displayed in the cart$")
	public void should_be_added_and_displayed_in_the_cart(String product) {
		boolean blnStatus = shoppingCartPage.isProductAddedToCart(ProductTitle);
		Assert.assertTrue(blnStatus, product + "Product is not added to the cart");
		System.out.println("Product Found in the Cart.");
		InitialSetup.CloseBrowser();
	}
}
