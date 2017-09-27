package com.build.qa.build.selenium.tests;

import java.awt.AWTException;

import org.junit.Ignore;
import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.BathroomSinkPage;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;

public class BuildTest extends BaseFramework { 
	
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Ignore
	@Test
	public void navigateToHomePage() { 
		
		driver.get(getConfiguration("BATHROOMSINKPAGE"));
		
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 */
	@Ignore
	@Test
	public void searchForProductLandsOnCorrectProduct() { 
		// TODO: Implement this test
		
		driver.get(getConfiguration("HOMEPAGE"));
		
		System.out.println("Waiting for page to  load");
		
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
		
		System.out.println("Search Box is available on the Screen ?? :: " + homePage.isSearchBoxAvailable());
		
		softly.assertThat(homePage.isSearchBoxAvailable())
		.as("Search Box is available on the Screen")
		.isTrue();
		
		softly.assertThat(homePage.doSearch("Quoizel MY1613").equals("Quoizel MY1613ML"))
		.as("Searched result page title correctly matched with searched content")
		.isTrue();
		
			
	}
	
	/** 
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504) 
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws AWTException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	
	@Test
	public void addProductToCartFromCategoryDrop() throws AWTException { 
		// TODO: Implement this test
		
		driver.get(getConfiguration("BATHROOMSINKPAGE"));
		
		System.out.println("Waiting for page to  load");
		
		BathroomSinkPage bathroomSink = new BathroomSinkPage(driver, wait);
		
		System.out.println("Confirmation Message for adding to Cart is :: "  + bathroomSink.addToCart());
		softly.assertThat(bathroomSink.addToCart().equals("Product Added to Cart"))
		.as("After adding the product, confirmation message should show that Product added to Cart")
		.isTrue();
		
	}
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
	@Ignore
	@Test
	public void addProductToCartAndEmailIt() { 
		// TODO: Implement this test
	}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Ignore
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() { 
		// TODO: Implement this test
	}
}
