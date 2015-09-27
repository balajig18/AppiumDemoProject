package com.home.balaji.seleniumapp;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.home.balaji.appium.WaitClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebViewPage {
	
	@FindBy(id="io.selendroid.testapp:id/spinner_webdriver_test_data")
	public AndroidElement spinnerButton;
	

	@FindBy(id="io.selendroid.testapp:id/goBack")
	public AndroidElement goBackButton;

	private AppiumDriver appiumDriver;

	public WebViewPage(AppiumDriver appiumDriver)
	{
		this.appiumDriver=appiumDriver;
	}
	
	public void selectWebViewHtml(String text)
	{
		
		appiumDriver.tap(1, spinnerButton,1);
		WaitClass.waitFor(appiumDriver,By.id("android:id/select_dialog_listview"),60);
		List<WebElement> list=appiumDriver.findElements(By.className("android.widget.TextView"));
		for(WebElement item:list)
		{
			if(item.getAttribute("text").toLowerCase().contains(text.toLowerCase()))
			{
				appiumDriver.tap(1,item,1);
				break;
			}
				
		}
	}
	public void switchToWebView()
	{
		WaitClass.waitFor(appiumDriver, By.className("android.view.View"),10);
		Set<String> webViewContextList=appiumDriver.getContextHandles();
		for(String text:webViewContextList)
		{
			appiumDriver.context(text);
		}
	}
	
}
