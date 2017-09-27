package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	private By buildThemeBody;
	private By searchTextBox;
	private By searchResultTitle;
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		buildThemeBody = By.cssSelector("body.build-theme");
		searchTextBox = By.id("search_txt");
		searchResultTitle = By.id("heading");
		
	}
	
	public boolean onBuildTheme() { 
		return wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}
	
	public boolean isSearchBoxAvailable() 
	{
		System.out.println("Inside Search Box Available Method");
	
		return wait.until(ExpectedConditions.presenceOfElementLocated(searchTextBox)) != null;
			
	}
	
	public String doSearch(String searchString)
	{
		driver.findElement(searchTextBox).sendKeys(searchString);
		driver.findElement(searchTextBox).sendKeys(Keys.ENTER);
		
		if(wait.until(ExpectedConditions.presenceOfElementLocated(searchResultTitle)) != null)
		{
			System.out.println("Search Result Title is :: " + driver.findElement(searchResultTitle).getText());
			return driver.findElement(searchResultTitle).getText();
		}
		else
		{
			return "Searched Item not available";
		}
	
		
		
	}
	
	
}
