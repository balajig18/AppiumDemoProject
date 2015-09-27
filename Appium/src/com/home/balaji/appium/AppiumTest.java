package com.home.balaji.appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class AppiumTest {

	public static void inputOperation(AppiumDriver appiumDriver)
	{
		
		MobileElement element1=(MobileElement)waitFor(appiumDriver,By.xpath("//*[contains(@content-desc,'my_text_fieldCD')]"),60);
		element1.sendKeys("balaji_ga");
		MobileElement element2=(MobileElement)waitFor(appiumDriver, By.xpath("//*[contains(@content-desc,'showPopupWindowButtonCD')]"),60);
		element2.click();
	}
	public static WebElement waitForElement(AppiumDriver appiumDriver,String locator,long timeout)
	{
		WebDriverWait driverWait=new WebDriverWait(appiumDriver,timeout);
		return driverWait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath(locator)));
		
	}
	public static WebElement waitFor(AppiumDriver appiumDriver,final By locator,long timeout)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(appiumDriver)  
		             .withTimeout(timeout, TimeUnit.SECONDS)  
		             .pollingEvery(2, TimeUnit.SECONDS)  
		             .ignoring(NoSuchElementException.class,WebDriverException.class); 

		     WebElement element= wait.until(new Function<WebDriver,WebElement>() {  
		           public WebElement apply(WebDriver driver) {  
		             return driver.findElement(locator);  
		            }  
		      });  
		  return element;  
		 }
	public static void main(String[] args){
		
	
	DesiredCapabilities cap=DesiredCapabilities.android();
	cap.setCapability(MobileCapabilityType.PLATFORM, cap.getPlatform());
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, cap.getPlatform());
	cap.setCapability("deviceName", "emulator-5554");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
	cap.setCapability(MobileCapabilityType.APP,"D:/JARS/jars/selendroid-test-app-0.12.0.apk");
	cap.setCapability(MobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");	
	cap.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, ".HomeScreenActivity");
	AndroidDriver webDriver=null;
	//WebDriver webdriver=new (new URL("http://localhost:4718/wd/hub"),cap);
	try{
		 webDriver=new AndroidDriver(new URL("http://localhost:4718/wd/hub"), cap);
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
//	webDriver.installApp("C:/Users/Karthick/Downloads/myhcl.apk");
	
//	webDriver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	inputOperation(webDriver);
	
	
	
	
	
	
}
	}
