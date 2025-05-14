package com.tubi.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.tubi.pages.PlayStorePage;
import com.tubi.resources.DriverFactory;

import io.appium.java_client.android.AndroidDriver;


public class BaseTest {

	protected AndroidDriver driver;
	protected DriverFactory driverFactory;
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeMethod
	@Parameters({"deviceName", "udId", "platformVersion", "appiumServerUrl"})
	public void setUpDriver(String deviceName, String udId, String platformVersion, String appiumServerUrl)
	{
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(deviceName, udId, platformVersion, appiumServerUrl);
		
		//Check if Tubi App is installed on the device
		//if not download and install it from Play Store
		if (!driver.isAppInstalled("com.tubitv")) 
		{
			logger.info("Tubi app is not installed on the device...");
            PlayStorePage store = new PlayStorePage(driver);
            store.searchAndInstallTubiApp();
        }
		else
		{
			logger.info("Tubi app is installed on the device...");
			//Launch Tubi App
			launchTubiApp();
		}
	}
	
	public void launchTubiApp()
	{
		driver.activateApp("com.tubitv");
		logger.info("Launching Tubi App...");
	}
	
	@AfterMethod
	public void tearDown()
	{
		logger.info("Quiting the driver...");
		driver.terminateApp("com.tubitv");
		if (driver != null)
			driver.quit();
	}
}
