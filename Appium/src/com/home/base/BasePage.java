package com.home.base;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import com.google.common.base.Function;
import com.home.exception.PageNotLoadedException;

public abstract class BasePage {
	
	private static final long DEFAULT_TIMEOUT=60;
	
	private AppiumDriver<MobileElement> appiumDriver=null;
	
	public BasePage(AppiumDriver<MobileElement> appiumDriver) throws PageNotLoadedException {
		this.appiumDriver=appiumDriver;
		if(!waitForPageLoad())
		{throw new PageNotLoadedException(this.getClass().getName());}
	}

	public abstract boolean waitForPageLoad();

	public AndroidDriver<MobileElement> getAndroidDriver(){
		return (AndroidDriver<MobileElement>)appiumDriver;
	}
	
	public void setTextField(By locator,String string)
	{
		String OS=(String) appiumDriver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME);
		
		if(OS.equalsIgnoreCase("android"))
		{
			MobileElement textField=waitForElement(locator);
			textField.clear();
			textField.sendKeys(string);
			getAndroidDriver().pressKeyCode(4);
		}
	}
	 
	public MobileElement waitForElement(final By locator)
	{
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver)  
		             .withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)  
		             .pollingEvery(2, TimeUnit.SECONDS)  
		             .ignoring(NoSuchElementException.class,WebDriverException.class); 

		     MobileElement element= wait.until(new Function<AppiumDriver<MobileElement>,MobileElement>() {  
		           public MobileElement apply(AppiumDriver<MobileElement> appiumDriver) {  
		             return appiumDriver.findElement(locator);  
		            }  
		      });  
		  return element;  
		 }
	public MobileElement waitForElement(final By locator,long timeOut)
	{
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver)  
		             .withTimeout(timeOut, TimeUnit.SECONDS)  
		             .pollingEvery(2, TimeUnit.SECONDS)  
		             .ignoring(NoSuchElementException.class,WebDriverException.class); 

		     MobileElement element= wait.until(new Function<AppiumDriver<MobileElement>,MobileElement>() {  
		           public MobileElement apply(AppiumDriver<MobileElement> appiumDriver) {  
		             return appiumDriver.findElement(locator);  
		            }  
		      });  
		  return element;  
	 }
	public List<MobileElement> waitForListElement(final By locator,long timeOut)
	{
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver)  
		             .withTimeout(timeOut, TimeUnit.SECONDS)  
		             .pollingEvery(2, TimeUnit.SECONDS)  
		             .ignoring(NoSuchElementException.class,WebDriverException.class); 

			List<MobileElement> element= wait.until(new Function<AppiumDriver<MobileElement>,List<MobileElement>>() {  
		           public List<MobileElement> apply(AppiumDriver<MobileElement> appiumDriver) {  
		             return appiumDriver.findElements(locator);  
		            }  
		      });  
		  return element;  
	 }
	
public void scrollDownToText(String text,int maximumScroll){
		
		int count=0;
		String pageSource;
		String os=(String) appiumDriver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME);
		if(os.equalsIgnoreCase("ANDROID")){
			Dimension screen=appiumDriver.manage().window().getSize();
			int locationY=screen.getHeight();
			while(count<maximumScroll)
			{
				pageSource=appiumDriver.getPageSource();
				if(pageSource.contains(text)){
					break;
				}
				appiumDriver.swipe(2,600, 2, 300, 0);
				count++;
			}
			
		}
	}
	}




