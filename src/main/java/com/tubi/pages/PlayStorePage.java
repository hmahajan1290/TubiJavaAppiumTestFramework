package com.tubi.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;

public class PlayStorePage extends BasePage{

	private AndroidDriver driver;
	private static final Logger logger = LogManager.getLogger(PlayStorePage.class);
	
	public PlayStorePage(AndroidDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}

	//Locators
	private By searchBox = By.xpath("//android.widget.TextView[@text=\"Search\"]");
	private By inputSearchBox = By.xpath("//android.widget.TextView[@text=\"Search apps & games\"]");
	private By addSearchText = By.className("android.widget.EditText");
 	private By installButton = By.xpath("//android.widget.TextView[@content-desc=\"Install\"]");
 	private By openApp = By.xpath("//android.widget.TextView[@content-desc=\"Open\"]");
	private By tubiAppText = By.xpath("//android.widget.TextView[contains(@text,'Tubi')]");
	
	//Page Action methods
	public void searchAndInstallTubiApp()
	{
		logger.info("Opening Google Play Store...");
		driver.activateApp("com.android.vending");
		click(getElement(searchBox), "Search box...");
		click(getElement(inputSearchBox), "Input search box");
		sendKeys(getElement(addSearchText), "Tubi", "Input search box...");
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
		
		click(getElement(tubiAppText), "Tubi...");
		
		click(getElement(installButton), "Install button...");
		logger.info("Installing Tubi app...");
		
		click(getElement(openApp), "Open...");
		logger.info("Opening Tubi app...");
	}
}
