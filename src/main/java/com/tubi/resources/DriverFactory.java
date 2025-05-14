package com.tubi.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

import java.net.MalformedURLException;
import java.net.URI;


public class DriverFactory {

	public AndroidDriver driver;
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	
	public AndroidDriver init_driver(String deviceName, String udId, String platformVersion, String appiumServerUrl)
	{
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setPlatformName(ANDROID);
        options.setUdid(udId);
        options.setPlatformVersion(platformVersion);
        
        try 
        {
        	if(driver == null)
        		driver = new AndroidDriver(URI.create(appiumServerUrl).toURL(), options);
		} 
        catch (MalformedURLException e) 
        {
        	logger.error("Error occurred while initializing driver...");
        	logger.error(e.getMessage());
			e.printStackTrace();
		}
        
        return driver;
	}
}
