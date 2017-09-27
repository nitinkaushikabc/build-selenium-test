package com.build.qa.build.selenium.pageobjects.homepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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

	public BathroomSinkPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		pageTitle = By.xpath(".//*[@id='category-content']/div[2]/div/div[1]/h1");
		itemToAddInCart = By.xpath(".//*[@id='product-composite-560374']/div[2]/a/div[2]/span");
		addToCartButton = By.xpath(".//*[@id='configure-product-wrap']/button");
		confirmationMessage = By.xpath(".//*[@id='recommended-options']/div[1]/div/div/div[2]/div");
		itemName = By.xpath(".//*[@id='heading']");
	
		
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
	

	public String addToCart() throws AWTException
	{
		if(isPageLoaded())
		{
			if(wait.until(ExpectedConditions.presenceOfElementLocated(itemToAddInCart)) != null)
			{
				driver.findElement(itemToAddInCart).click();
				
				
				if((wait.until(ExpectedConditions.presenceOfElementLocated(itemName)) != null) 
						&& driver.findElement(itemName).getText().equals("Kohler K-2214-0"))
				{
					if((wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton)) != null))
					{
						System.out.println("Enter Button is displayed on Screen");
						
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_PAGE_DOWN);
						robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
						
					
						Actions action = new Actions(driver);
						action.moveToElement(driver.findElement(addToCartButton)).perform();
						System.out.println("PERFORMED::::::::::::::");
						action.doubleClick().perform();
						//driver.findElement(addToCartButton).click();
						//Sometimes single click is not working, Bug to be reported in App
						
					
					
					if((wait.until(ExpectedConditions.presenceOfElementLocated(confirmationMessage)) != null))
							{
								return driver.findElement(confirmationMessage).getText();
							}
					else
						return "Element confirmationMessage is not available on screen";
					}
					else
						return "addToCartButton not available";
					
				}
				else
					return "Correct Item Title not available to add in Cart";
			}
			else
				return "Item is not available to add in Cart";
			}
		else
			
			return "Page is Not Loaded";
		
	}
	
	
	
	
	
	
	
	
}
