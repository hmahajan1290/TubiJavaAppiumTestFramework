package com.tubi.pages;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class FamilyMoviesPage extends BasePage{
	
	private static final Logger logger = LogManager.getLogger(FamilyMoviesPage.class);

	public FamilyMoviesPage(AndroidDriver driver) 
	{
		super(driver);
	}

	//Locators
	private By movieTitle = By.id("com.tubitv:id/head_info_title");
	private By movieInfo = By.id("com.tubitv:id/head_info_duration_and_tags");
	private By movieDescription = By.id("com.tubitv:id/description");
	private By movieList = By.xpath("//android.widget.ImageView[@resource-id=\"com.tubitv:id/video_poster_image_view\"]");
	
	//Page Action methods
	public boolean getMovieDetailsByTitle(String movieName)
	{
		//Get list of movies on Family Movies page
		List<WebElement> movies = driver.findElements(movieList);
		logger.info("Total movies on Family Movies page are: " + movies.size());
		
		for (int i = 0; i < movies.size(); i++)
		{		
			click(movies.get(i), " Movie poster...");
			String title = getElementText(movieTitle);
			
			if(title.equalsIgnoreCase(movieName))
			{
				System.out.println("Title: " + title);
				logger.info("Title: " + title);
				System.out.println("Info: " + getElementText(movieInfo));
				logger.info("Info: " + getElementText(movieInfo));
				scrollToResource("com.tubitv:id/description");
				System.out.println("Description: " + getElementText(movieDescription));
				logger.info("Description: " + getElementText(movieDescription));
				return true;
			}
			else
			{
				driver.navigate().back();
				logger.info("Navigating back...");
				movies = driver.findElements(movieList);
			}
		}
		return false;
	}
}
