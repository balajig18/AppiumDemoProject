package com.home.balaji.appium;
import static org.junit.Assert.*;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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

import com.home.base.BaseTest;
import com.home.exception.PageNotLoadedException;


public class AppiumDemoTest1 extends BaseTest{

	public AppiumDriver<MobileElement> appiumDriver=null;
	private static final Logger LOGGER=Logger.getLogger(AppiumDemoTest1.class);
	
	@BeforeClass
	public static void setUpClass()
	{
		BasicConfigurator.configure();
	}
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		appiumDriver=getDeviceDriver("ANDROID","E8AZCY224672","Zenfone5");
		
		appiumDriver.installApp("C:/Users/Karthick/Downloads/myhcl.apk");
		((AndroidDriver<MobileElement>)appiumDriver).startActivity("com.hcl.myapprovals",".MyHclActivity");
		
	
	}

	@Test
	public void test() throws PageNotLoadedException {
		MyHclLoginPage myHclLoginPage=new MyHclLoginPage(appiumDriver);
	
		myHclLoginPage.enterUsername("balaji_ga");
		myHclLoginPage.enterPassword("sep2015$");
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
