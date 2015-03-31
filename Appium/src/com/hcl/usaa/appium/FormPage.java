package com.hcl.usaa.appium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FormPage {

	private AppiumDriver appiumDriver;
	
	public static final By USERNAMETEXTFIELD=By.id("io.selendroid.testapp:id/inputUsername");
	public static final By PASSWORDTEXTFIELD=By.id("io.selendroid.testapp:id/inputEmail");
	public static final By EMAILTEXTFIELD=By.id("io.selendroid.testapp:id/inputPassword");
	public static final By NAMETEXTFIELD=By.id("io.selendroid.testapp:id/inputName");
	public static final By SPINNERBUTTON=By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
	public static final By CHECKBOX=By.id("io.selendroid.testapp:id/input_adds");
	public static final By REGISTERUSERBT=By.id("io.selendroid.testapp:id/btnRegisterUser");
	public static final By SPINNERLIST=By.xpath("//*[@id='android:id/select_dialog_listview']/CheckedTextView");
	
	public FormPage(AppiumDriver appiumDriver)
	{
		this.appiumDriver=appiumDriver;
	}
	
	public void enterUserName(String username)
	{
		appiumDriver.findElement(USERNAMETEXTFIELD).sendKeys(username);
	}
	public void enterEmail(String email)
	{
		appiumDriver.findElement(EMAILTEXTFIELD).sendKeys(email);
	}
	public void enterPassword(String password)
	{
		appiumDriver.findElement(USERNAMETEXTFIELD).sendKeys(password);
	}
	public void enterName(String name)
	{
		appiumDriver.findElement(NAMETEXTFIELD).sendKeys(name);
	}
	public void selectProgramLanguage(String text)
	{
		MobileElement element=(MobileElement) appiumDriver.findElement(SPINNERBUTTON);
		appiumDriver.tap(1, element,1);
		WaitClass.waitFor(appiumDriver,SPINNERLIST,60);
		List<WebElement> list=appiumDriver.findElements(SPINNERLIST);
		for(WebElement item:list)
		{
			if(item.getAttribute("text").contains(text))
			{
				appiumDriver.tap(1,item,1);
				break;
			}
				
		}
	}
	
	public void clickOnRegister()
	{
		appiumDriver.findElement(REGISTERUSERBT).click();
	}
	
}
