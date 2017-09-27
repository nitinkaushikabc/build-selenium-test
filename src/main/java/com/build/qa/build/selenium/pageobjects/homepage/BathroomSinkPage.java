package com.build.qa.build.selenium.pageobjects.homepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class BathroomSinkPage extends BasePage{

	private By itemToAddInCart;
	private By itemName;
	private By addToCartButton;
	private By confirmationMessage;
	private By pageTitle;
	private By itemCount;
	private By cartButton;
	private By cartNumber;
	private By emailButton;

	public BathroomSinkPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		pageTitle = By.xpath("//h1[contains(@class,'inline-block')]");
		addToCartButton = By.xpath("//div[contains(@class,'add-to-cart-btn')]");
		itemToAddInCart = By.xpath(".//*[@id='product-composite-560374']/div[2]/a/div[2]/span");
		confirmationMessage = By.xpath(".//*[@id='recommended-options']/div[1]/div/div/div[2]/div");
		itemName = By.xpath(".//*[@id='heading']");
		itemCount = By.xpath(".//*[@id='main-product-quantity']/div/input");
		cartButton = By.xpath("//button[contains(@href,'cart:cart')]");
		cartNumber = By.xpath("//div[contains(@class,'cart-number')]");
		emailButton = By.xpath("//button[contains(@class,'btn-email')]");
		
	}
	
	public boolean isPageLoaded()
	{
		System.out.println("Inside isPageLoaded method");
	
		if(wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle)) != null)
		{
			System.out.println("Page Title is ::: " + driver.findElement(pageTitle).getText());
			if(driver.findElement(pageTitle).getText().equals("Bathroom Sinks"))
			{
				return true;
			}else
				return false;
			
		}

		return false;
	
	}
	

	public String addToCart() throws AWTException, InterruptedException
	{
		if(isPageLoaded())
		{
			if(wait.until(ExpectedConditions.presenceOfElementLocated(itemToAddInCart)) != null)
			{
				driver.findElement(itemToAddInCart).click();
				
				
				if((wait.until(ExpectedConditions.presenceOfElementLocated(itemName)) != null) 
						&& driver.findElement(itemName).getText().equals("Kohler K-2214-0"))
				{
							Robot robot = new Robot();
							driver.findElement(itemCount).click();
							
							Thread.sleep(5000);
							robot.keyPress(KeyEvent.VK_TAB);
							robot.keyRelease(KeyEvent.VK_TAB);
							
							Thread.sleep(5000);
							
							robot.keyPress(KeyEvent.VK_ENTER);
							System.out.println("Enter Key Pressed");
							robot.keyRelease(KeyEvent.VK_ENTER);
							
							if((wait.until(ExpectedConditions.presenceOfElementLocated(confirmationMessage)) != null))
							{
								System.out.println("Confirmation Message is : " + driver.findElement(confirmationMessage).getText());
								return driver.findElement(confirmationMessage).getText();
							}
							else
								return "Wrong confirmation message is displayed.";
							
							
						}
						
						
						
			
				
			return "Wrong Item Page is displayed";
		
	}
		
		}
		return "Page is not loaded correctly";
		
	}
	
	
	
	public boolean isCartEmpty()
	{
		driver.findElement(cartButton).click();
		
		if(driver.findElement(cartNumber)!=null)
		{
			return false;
			
		}
		return true;
	}
	
	public void sendEmail() throws InterruptedException, AWTException
	{
		if(driver.findElement(emailButton)!=null)
		{
			System.out.println("Clicking email Button");
			
			Thread.sleep(5000);
			driver.findElement(emailButton).click();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			System.out.println("Enter Key Pressed");
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(5000);
			
		}
		
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Size of the iframes are: " + iframeElements.size());
		
		for(int i=0; i<iframeElements.size();i++)
		{
			System.out.println("Size of the iframes are: " +iframeElements.get(i).getAttribute("src"));
		}
		
		driver.findElement(By.xpath("//input[contains(@id,'yourName')]")).sendKeys("Nitin Kaushik");
		driver.findElement(By.xpath("//input[contains(@id,'yourEmail')]")).sendKeys("talk2kaushik@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'recipientName')]")).sendKeys("build.com test");
		driver.findElement(By.xpath("//input[contains(@id,'recipientEmail')]")).sendKeys("jgilmore+SeleniumTest@build.com");
		driver.findElement(By.xpath("//input[contains(@id,'quoteMessage')]")).sendKeys("This is Nitin Kaushik, sending you a cart from my automation!");
		driver.findElement(By.xpath("//button[contains(@class,'js-email-cart-submit-button')]")).click();
		
		
		
		
	
	}
	
	

}