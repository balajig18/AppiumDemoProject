package com.hcl.usaa.appium;
import static org.junit.Assert.*;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppiumDemoTest2 {

	public AppiumDriver appiumDriver=null;
	private static final Logger LOGGER=Logger.getLogger(AppiumDemoTest2.class);
	
	@BeforeClass
	public static void setUpClass()
	{
		BasicConfigurator.configure();
	}
	@Before
	public void setUp() throws Exception {
		appiumDriver=UtilityClass.getDeviceDriver("ANDROID","emulator-5554","NexusEmulator");
		//appiumDriver.closeApp();
		//appiumDriver.installApp("C:/Users/Karthick/Downloads/myhcl.apk");
		//((AndroidDriver)appiumDriver).startActivity("com.hcl.myapprovals",".MyHclActivity");
		
	
	}

	@Test
	public void test() {
		MyHclLoginPage myHclLoginPage=new MyHclLoginPage(appiumDriver);
		
		if(!myHclLoginPage.isPageLoaded){
			Assert.fail("Taking Time open to load");
		}
		myHclLoginPage.enterUsername("balaji_ga");
		myHclLoginPage.enterPassword("dec2014$");
		myHclLoginPage.selectDomain("HCLTECH");
		myHclLoginPage.clickOnLoginButton();
		
		MyHclHomePage myHclHomePage=new MyHclHomePage(appiumDriver);
		
		if(!myHclHomePage.isPageLoaded){
			Assert.fail("Taking Time open to load");
		}
		//myHclHomePage.scrollPageUp();
		//myHclHomePage.scrollPageDown();
		myHclHomePage.clickOnMenuButton();
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		appiumDriver.closeApp();
		appiumDriver.quit();
		appiumDriver=null;
	}


}
