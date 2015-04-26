package com.hcl.seleniumapp;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.hcl.usaa.appium.AppiumDemoTest1;
import com.hcl.usaa.appium.UtilityClass;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

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
		formPage.selectProgramLanguage("Java");
		formPage.clickOnRegister();
		
	} 
	@Test
	public void pageObjectTest()
	{
		SeleniumTestAppHomePage appHomePage=new SeleniumTestAppHomePage(appiumDriver);
		appHomePage.clickOnRegistrationButton();
		
		PageObjectAppium pageObjectAppium=new PageObjectAppium(appiumDriver);
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver,10,TimeUnit.SECONDS),
				pageObjectAppium);
		pageObjectAppium.enterUserName("balaji");
		pageObjectAppium.enterEmail("xx@gg.com");
		pageObjectAppium.enterPassword("adfadf");
		pageObjectAppium.enterName("gadg");
		pageObjectAppium.selectProgramLanguage("Java");
		pageObjectAppium.clickOnAddCheck();
		pageObjectAppium.clickOnRegister();
		
	}
	@After
	public void tearDown()
	{
		((AndroidDriver)appiumDriver).removeApp("io.selendroid.testapp");
		((AndroidDriver)appiumDriver).quit();
		
	}
}
