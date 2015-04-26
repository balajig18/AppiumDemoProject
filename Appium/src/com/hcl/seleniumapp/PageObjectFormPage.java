package com.hcl.seleniumapp;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hcl.usaa.appium.WaitClass;

public class PageObjectFormPage {
	
	@FindBy(id="io.selendroid.testapp:id/inputUsername")
	public AndroidElement userName;
	

	@FindBy(id="io.selendroid.testapp:id/inputEmail")
	public AndroidElement emailField;
	

	@FindBy(id="io.selendroid.testapp:id/inputPassword")
	public AndroidElement inputPassword;
	

	@FindBy(id="io.selendroid.testapp:id/inputName")
	public AndroidElement nameField;
	
	@FindBy(id="io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	public AndroidElement spinnerButton;
	
	@FindBy(id="io.selendroid.testapp:id/btnRegisterUser")
	public AndroidElement registerUserButton;
	
	@FindBy(id="io.selendroid.testapp:id/input_adds")
	public AndroidElement addCheckBox;


	private AppiumDriver appiumDriver;
	
	
	public PageObjectFormPage(AppiumDriver appiumDriver)
	{
		this.appiumDriver=appiumDriver;
	}
	
	public void enterUserName(String username)
	{
		
		userName.sendKeys(username);
		((AndroidDriver)appiumDriver).hideKeyboard();
	}
	public void enterEmail(String email)
	{
		emailField.sendKeys(email);
		((AndroidDriver)appiumDriver).hideKeyboard();
	}
	public void enterPassword(String password)
	{
		inputPassword.sendKeys(password);
		((AndroidDriver)appiumDriver).hideKeyboard();
	}
	public void enterName(String name)
	{
		
		nameField.clear();
		nameField.sendKeys(name);
		((AndroidDriver)appiumDriver).hideKeyboard();
	}
	public void selectProgramLanguage(String text)
	{
		
		appiumDriver.tap(1,spinnerButton,1);
		WaitClass.waitFor(appiumDriver,By.className("android.widget.CheckedTextView"),60);
		List<WebElement> list=appiumDriver.findElements(By.className("android.widget.CheckedTextView"));
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
		(registerUserButton).click();
	}
	public void clickOnAddCheck()
	{
		(addCheckBox).click();
	}
}
