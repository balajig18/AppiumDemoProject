package com.home.balaji.seleniumapp;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.home.base.BaseTest;
import com.home.exception.PageNotLoadedException;

public class WebViewTest extends BaseTest{
	
	public AppiumDriver appiumDriver=null;
	private static final Logger LOGGER=Logger.getLogger(WebViewTest.class);
	
	@BeforeClass
	public static void setUpClass()
	{
		BasicConfigurator.configure();
	}
	@Before
	public void setUp() throws Exception {
		appiumDriver=getDeviceDriver("ANDROID","E8AZCY224672","Zenfone5");
		
	
		appiumDriver.installApp("D:/Android/selendroid-test-app-0.15.0.apk");
		((AndroidDriver)appiumDriver).startActivity("io.selendroid.testapp",".HomeScreenActivity");
	}
	
	@Test
	public void test1() throws PageNotLoadedException
	{
		SeleniumTestAppHomePage appHomePage=new SeleniumTestAppHomePage(appiumDriver);
		appHomePage.clickOnChromeButton();
		WebViewPage webViewPage=new WebViewPage(appiumDriver);
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver,10,TimeUnit.SECONDS),webViewPage);
		webViewPage.selectWebViewHtml("Form");
		webViewPage.switchToWebView();
	}
	@org.junit.After
	public void After()
	{
		((AndroidDriver)appiumDriver).removeApp("io.selendroid.testapp");
		((AndroidDriver)appiumDriver).quit();
	}
}
