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

	@When("^we search for fossil Mens Watch$")
	public void we_search_for_fossil_Mens_Watch() {
		Homepage.searchForProduct("fossil Mens Watch");
		Homepage.selectFirstProduct();
	}

	@When("^add it to cart$")
	public void add_it_to_cart() {
		ProductTitle = productPage.getProductTitle();
		System.out.println(ProductTitle);
		shoppingCartPage = productPage.addProductToCart();
	}

	@Then("^fossil Mens Watch should be added and displayed in the cart$")
	public void fossil_Mens_Watch_should_be_added_and_displayed_in_the_cart() throws Throwable {
		Assert.assertTrue(shoppingCartPage.isProductAddedToCart(ProductTitle), "Product is not Found in the Cart");
	}

	@When("^we search for \"([^\"]*)\"$")
	public void we_search_for(String product) {
		Homepage.searchForProduct(product);
		productPage = Homepage.selectFirstProduct();
	}

	@Then("^\"([^\"]*)\" should be added and displayed in the cart$")
	public void should_be_added_and_displayed_in_the_cart(String product) {
		boolean blnStatus = shoppingCartPage.isProductAddedToCart(ProductTitle);
		Assert.assertTrue(blnStatus, product + " is not added to the cart");
		driver.quit();
		driver = null;
	}
}
