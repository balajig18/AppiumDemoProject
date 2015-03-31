package com.hcl.usaa.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.misc.FpUtils;

public class AppiumAppTest {

	public AppiumDriver appiumDriver=null;
	private static final Logger LOGGER=Logger.getLogger(AppiumDemoTest1.class);
	
	@BeforeClass
	public static void setUpClass()
	{
		BasicConfigurator.configure();
	}
	@Before
	public void setUp() throws Exception {
		appiumDriver=UtilityClass.getDeviceDriver("ANDROID","E8AZCY224672","Zenfone5");
		
		appiumDriver.installApp("D:/Android/selendroid-test-app-0.15.0.apk");
		((AndroidDriver)appiumDriver).startActivity("io.selendroid.testapp",".HomeScreenActivity");
	}
	
	@Test
	public void test()
	{
		System.out.println("Inside Test");
		SeleniumTestAppHomePage appHomePage=new SeleniumTestAppHomePage(appiumDriver);
		appHomePage.clickOnRegistrationButton();
		FormPage formPage=new FormPage(appiumDriver);
		formPage.enterUserName("balaji");
		formPage.enterEmail("xx@gg.com");
		formPage.enterPassword("adfadf");
		formPage.enterName("gadg");
		formPage.selectProgramLanguage("text");
		formPage.clickOnRegister();
	} 
	@After
	public void tearDown()
	{
		appiumDriver.closeApp();
		appiumDriver.close();
		appiumDriver.quit();
	}
}
