package com.tubi.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;


public abstract class Page {

	AndroidDriver driver;
	WebDriverWait wait;
	
	public Page(AndroidDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	{
		try 
		{
			return pageClass.getDeclaredConstructor(AndroidDriver.class).newInstance(this.driver);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
