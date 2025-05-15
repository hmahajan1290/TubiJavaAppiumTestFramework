package com.tubi.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BasePage extends Page{

	private static final Logger logger = LogManager.getLogger(BasePage.class);
			
	public BasePage(AndroidDriver driver) 
	{
		super(driver);
	}

	@Override
	public WebElement getElement(By locator) 
	{
		WebElement element = null;
		
		try
		{
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		}
		catch(Exception e)
		{
			System.out.println("Exception while creating element " + locator.toString());
			logger.error("Exception while creating element " + locator.toString());
			e.printStackTrace();
		}
		
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) 
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("Some exception occurred while waiting for element " + locator.toString());
			logger.error("Some exception occurred while waiting for element " + locator.toString());
		}
	}
	
	public String getElementText(By locator)
	{
		return getElement(locator).getText();
	}

	public void sendKeys(WebElement element, String value, String elementName)
	{
		element.clear();
		element.sendKeys(value);
		logger.info("Entering '" + value + "' to '" + elementName + "' field");
	}

	public void click(WebElement element, String elementName)
	{
		element.click();
		logger.info("Clicking '" + elementName + "'");
	}
	
	public void scrollToCategory(String category)
	{
		driver.findElement((AppiumBy.androidUIAutomator(
			"new UiScrollable(new UiSelector().resourceId(\"com.tubitv:id/fragment_home_list_category_recycler\"))"
			+ ".scrollIntoView(new UiSelector().scrollable(true).resourceId(\"com.tubitv:id/container_name\"))"
			+ ".scrollIntoView(new UiSelector().textMatches(\"" + category + "\").instance(0))")));
		
		logger.info("Scrolling to '" + category + "'...");
	}
	
	public void scrollToResource(String resource)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				".scrollIntoView(new UiSelector().resourceId(\"" + resource +"\").instance(0))"));
	}
	
	public boolean isElementPresent(By locator)
	{
		WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			elementWait.until(ExpectedConditions.presenceOfElementLocated(locator));
			List<WebElement> elements = driver.findElements(locator);
			return !elements.isEmpty();
		}
		catch(Exception e)
		{
			System.out.println(locator.toString() + " is not present on the page.");
			logger.info(locator.toString() + " is not present on the page.");
			return false;
		}
	}
}
