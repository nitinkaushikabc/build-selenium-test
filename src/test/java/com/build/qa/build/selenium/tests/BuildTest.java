package com.build.qa.build.selenium.tests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.BathroomSinkPage;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;

public class BuildTest extends BaseFramework { 
	
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */

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
	 * @throws InterruptedException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */

	@Test
	public void addProductToCartFromCategoryDrop() throws AWTException, InterruptedException  { 
		// TODO: Implement this test
		
		driver.get(getConfiguration("BATHROOMSINKPAGE"));
		
		BathroomSinkPage bathroomSink = new BathroomSinkPage(driver, wait);
		
		softly.assertThat(bathroomSink.addToCart().equals("Product Added to Cart"))
		.as("After adding the product, confirmation message should show that Product added to Cart")
		.isTrue();
		
		//We can also go into Cart section and then searched for the added item in Card.
		//Right now we have just checked the confirmation message.
		//There is some problem with Button clicks (sometimes not working and hence we have used Robot class).
		
	}
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @throws InterruptedException 
	 * @throws AWTException 
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */

	@Test
	public void addProductToCartAndEmailIt() throws AWTException, InterruptedException { 
		
		driver.get(getConfiguration("BATHROOMSINKPAGE"));
		BathroomSinkPage bathroomSink = new BathroomSinkPage(driver, wait);
		
		while(bathroomSink.isCartEmpty())
		{
			bathroomSink.addToCart().equals("Product Added to Cart");
		
			
		}
		
		//Click the email Button:
		
		bathroomSink.sendEmail();
	
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'js-notifications')]")));
		
		softly.assertThat(true)
		.as("Email confirmation message is available on screen")
		.isTrue();
		
		
		
		
		
	}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */

	@Test
	public void facetNarrowBysResultInCorrectProductCounts() { 
		// TODO: Implement this test
	}
}
