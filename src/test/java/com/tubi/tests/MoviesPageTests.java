package com.tubi.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tubi.pages.FamilyMoviesPage;
import com.tubi.pages.HomePage;
import com.tubi.pages.MoviesPage;

public class MoviesPageTests extends BaseTest{
	
	HomePage homePage;
	MoviesPage moviesPage;
	FamilyMoviesPage familyMoviesPage;
	
	@BeforeMethod
	public void setUp()
	{
		homePage = new HomePage(driver);
		homePage.clickSkipOnBoarding();
		moviesPage = homePage.clickMovies();
	}

	@Test
	public void verifyUserCanSeeMovieDetailsForAnyMovieForFamilyMoviesCategory()
	{
		familyMoviesPage = moviesPage.clickFamilyMovies();
		boolean foundMovie = familyMoviesPage.getMovieDetailsByTitle("UglyDolls");;
		
		Assert.assertTrue(foundMovie, "'UglyDolls' movie not found on Family Movies page");
	}
}
