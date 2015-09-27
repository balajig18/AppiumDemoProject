package com.hcl.seleniumapp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.hcl.usaa.appium.WaitClass;
import com.home.base.BasePage;
import com.home.exception.PageNotLoadedException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FormPage extends BasePage{

	public static final By USERNAMETEXTFIELD=By.id("io.selendroid.testapp:id/inputUsername");
	public static final By EMAILTEXTFIELD=By.id("io.selendroid.testapp:id/inputEmail");
	public static final By PASSWORDTEXTFIELD=By.id("io.selendroid.testapp:id/inputPassword");
	public static final By NAMETEXTFIELD=By.id("io.selendroid.testapp:id/inputName");
	public static final By SPINNERBUTTON=By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
	public static final By CHECKBOX=By.id("io.selendroid.testapp:id/input_adds");
	public static final By REGISTERUSERBT=By.id("io.selendroid.testapp:id/btnRegisterUser");
	public static final By SPINNERLIST=By.xpath("//*[@id='android:id/select_dialog_listview']/CheckedTextView");
	
	private static final Logger LOGGER=Logger.getLogger(FormPage.class);
	
	private AndroidDriver<MobileElement> androidDriver=null;
	
	public FormPage(AppiumDriver<MobileElement> appiumDriver) throws PageNotLoadedException
	{
		super(appiumDriver);
		androidDriver=getAndroidDriver();
		
	}
	
	public void enterUserName(String username)
	{
		setTextField(USERNAMETEXTFIELD, username);
	}
	public void enterEmail(String email)
	{
		setTextField(EMAILTEXTFIELD, email);
	}
	public void enterPassword(String password)
	{
		scrollDownToText("Password", 5);
		setTextField(PASSWORDTEXTFIELD, password);
	}
	public void enterName(String name)
	{
		scrollDownToText("Name", 5);
		setTextField(NAMETEXTFIELD, name);
	}
	public void selectProgramLanguage(String text)
	{
		scrollDownToText("Programming Languge", 5);
		MobileElement element=(MobileElement) androidDriver.findElement(SPINNERBUTTON);
		element.tap(1,1);
		waitForElement(By.className("android.widget.CheckedTextView"));
		scrollDownToText(text, 5);
		androidDriver.scrollToExact(text).click();
	}
	
	public void clickOnRegister()
	{
		scrollDownToText("Register User (verify)", 5);
		AndroidElement registerElement=((AndroidElement)androidDriver.findElement(REGISTERUSERBT));
		registerElement.click();
	}
	
	public int getY(Point point){
		return point.getY();
	}

	@Override
	public boolean waitForPageLoad() {
		boolean isPageLoaded=false;
		try{
			waitForElement(USERNAMETEXTFIELD,60);
			isPageLoaded=true;
		}catch(TimeoutException timeoutException){
			LOGGER.error("TimeoutException is occured");
		}catch(NoSuchElementException noSuchElementException)
		{
			LOGGER.error("NoSuchElement Exception is occured");
		}
		return isPageLoaded;
	
	}
	
}
