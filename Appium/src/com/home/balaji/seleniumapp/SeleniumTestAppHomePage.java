package com.home.balaji.seleniumapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.home.balaji.appium.WaitClass;
import com.home.base.BasePage;
import com.home.exception.PageNotLoadedException;

public class SeleniumTestAppHomePage extends BasePage{

	public static final By WAITUNTILHOMELOAD=By.xpath("//android.widget.TextView[contains(@text,'Selendroid-test-app!')]");
	
	public static final By REGISTRATIONBUTTON=By.id("io.selendroid.testapp:id/startUserRegistration");
	
	public static final By CHROMEBUTTON=By.id("io.selendroid.testapp:id/buttonStartWebview");

	private static final Logger LOGGER = Logger.getLogger(SeleniumTestAppHomePage.class);
	

	
	public SeleniumTestAppHomePage(AppiumDriver<MobileElement> appiumDriver) throws PageNotLoadedException
	{
		super(appiumDriver);
	}
	public void clickOnRegistrationButton()
	{
		((AndroidElement)waitForElement(REGISTRATIONBUTTON)).tap(1,1);
	}
	public void clickOnChromeButton()
	{
		((AndroidElement)waitForElement(CHROMEBUTTON)).tap(1,1);
	}
	@Override
	public boolean waitForPageLoad() {
		boolean isPageLoaded=false;
		try{
			waitForElement(WAITUNTILHOMELOAD,60);
			isPageLoaded=true;
		}catch(TimeoutException timeoutException){
			LOGGER.error("TimeoutException is occured");
		}catch(NoSuchElementException noSuchElementException)
		{
			LOGGER.error("NoSuchElement Exception is occured");
		}
		return isPageLoaded;
	
	}
}
