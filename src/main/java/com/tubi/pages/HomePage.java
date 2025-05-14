package com.tubi.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage{

	public HomePage(AndroidDriver driver) 
	{
		super(driver);
	}

	//Locators
	private By skipButton = By.id("com.tubitv:id/top_skip_button_onboarding");
	private By menu_Movies = By.id("com.tubitv:id/chip_movies");
	
	//Page Action Methods
	public void clickSkipOnBoarding()
	{
		if(isElementPresent(skipButton))
		{
			click(getElement(skipButton), "Skip Onboarding...");
			driver.navigate().back();
		}
	}
	
	public MoviesPage clickMovies()
	{
		click(getElement(menu_Movies), "Movies...");
		
		return getInstance(MoviesPage.class);
	}
}
