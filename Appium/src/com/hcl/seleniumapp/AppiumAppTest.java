package com.hcl.seleniumapp;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumSetting;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import com.home.base.BaseTest;
import com.home.exception.PageNotLoadedException;

public class AppiumAppTest extends BaseTest {

	public AndroidDriver<MobileElement> androidDriver=null;
	private static final Logger LOGGER=Logger.getLogger(AppiumAppTest.class);
	
	@BeforeClass
	public static void setUpClass()
	{
		BasicConfigurator.configure();
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		androidDriver=(AndroidDriver<MobileElement>) getDeviceDriver("ANDROID","E8AZCY224672","Zenfone5");
		if(!androidDriver.isAppInstalled("io.selendroid.testapp"))
		{
			androidDriver.installApp("D:/Android/selendroid-test-app-0.15.0.apk");
		}
		androidDriver.startActivity("io.selendroid.testapp",".HomeScreenActivity");
	}
	
	@Test
	public void test() throws PageNotLoadedException
	{
		//scrollDownToText("About",5);
		
		SeleniumTestAppHomePage appHomePage=new SeleniumTestAppHomePage(androidDriver);
		appHomePage.clickOnRegistrationButton();
		FormPage formPage=new FormPage(androidDriver);
		formPage.enterUserName("balaji");
		formPage.enterEmail("xx@gg.com");
		formPage.enterPassword("adfadf");
		formPage.enterName("gadg");
		formPage.selectProgramLanguage("Java");
		formPage.clickOnRegister();
		
	} 
	@Ignore
	@Test
	public void pageObjectTest() throws PageNotLoadedException
	{
		SeleniumTestAppHomePage appHomePage=new SeleniumTestAppHomePage(androidDriver);
		appHomePage.clickOnRegistrationButton();
		

		PageObjectFormPage pageObjectAppium=new PageObjectFormPage(androidDriver);

		PageFactory.initElements(new AppiumFieldDecorator(androidDriver,10,TimeUnit.SECONDS),
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
		//((AndroidDriver)androidDriver).removeApp("io.selendroid.testapp");
		//((AndroidDriver)androidDriver).quit();
	}

}
