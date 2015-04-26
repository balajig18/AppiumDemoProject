package com.hcl.seleniumapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hcl.usaa.appium.WaitClass;

public class SeleniumTestAppHomePage {

	public static final By WAITUNTILHOMELOAD=By.xpath("//android.widget.TextView[contains(@text,'Selendroid-test-app!')]");
	
	public static final By REGISTRATIONBUTTON=By.id("io.selendroid.testapp:id/startUserRegistration");
	
	public static final By CHROMEBUTTON=By.id("io.selendroid.testapp:id/buttonStartWebview");
	
	private AppiumDriver appiumDriver;
	
	
	public SeleniumTestAppHomePage(AppiumDriver appiumDriver)
	{
		this.appiumDriver=appiumDriver;
	}
	public void clickOnRegistrationButton()
	{
		WaitClass.waitFor(appiumDriver, REGISTRATIONBUTTON, 60);
		appiumDriver.findElement(REGISTRATIONBUTTON).click();
		//appiumDriver.tap(2,appiumDriver.findElement(REGISTRATIONBUTTON),2);
	}
	public void clickOnChromeButton()
	{
		WaitClass.waitFor(appiumDriver, CHROMEBUTTON, 60);
		appiumDriver.findElement(CHROMEBUTTON).click();
		//appiumDriver.tap(2,appiumDriver.findElement(REGISTRATIONBUTTON),2);
	}
}
