package com.hcl.usaa.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumTestAppHomePage {

	public static final By WAITUNTILHOMELOAD=By.xpath("//android.widget.TextView[contains(@text,'Selendroid-test-app!')]");
	
	public static final By REGISTRATIONBUTTON=By.id("io.selendroid.testapp:id/startUserRegistration");

	private AppiumDriver appiumDriver;
	
	
	public SeleniumTestAppHomePage(AppiumDriver appiumDriver)
	{
		this.appiumDriver=appiumDriver;
	}
	public void clickOnRegistrationButton()
	{
		WaitClass.waitFor(appiumDriver, WAITUNTILHOMELOAD, 60);
		appiumDriver.findElement(REGISTRATIONBUTTON).click();
		//appiumDriver.tap(2,appiumDriver.findElement(REGISTRATIONBUTTON),2);
	}
}
