package com.tubi.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class MoviesPage extends BasePage{

	public MoviesPage(AndroidDriver driver) 
	{
		super(driver);
	}

	//Locators
	private By category_FamilyMovies = By.xpath("//android.widget.TextView[@text='Family Movies']");
	
	//Page Action methods
	public FamilyMoviesPage clickFamilyMovies()
	{
		scrollToCategory("Family Movies");
		click(getElement(category_FamilyMovies), "Family Movies section...");
		
		return getInstance(FamilyMoviesPage.class);
	}
}
