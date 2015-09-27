package com.hcl.usaa.appium;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.home.base.BasePage;
import com.home.exception.PageNotLoadedException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class MyHclLoginPage extends BasePage{

	private AndroidDriver<MobileElement> androidDriver=null;
	public boolean isPageLoaded=false;
	
	private static final By LOGINPAGE=By.xpath("//*[@class='android.view.View' and @index='1']");
	private static final By USERNAME=By.xpath("//*[@class='android.widget.EditText' and @text='Username']");
	private static final By PASSWORD=By.xpath("//*[@class='android.widget.EditText' and @NAF='true']");
	private static final By DOMAINBUTTON=By.xpath("//*[@class='android.widget.Spinner' and @index='2']");
	private static final By DOMAINSELECTIONLIST=By.xpath("//*[@class='android.widget.CheckedTextView']");
	private static final By LOGINBUTTON=By.xpath("//*[@class='android.widget.Button' and @text='LOGIN']");
	
	
	
	private static final Logger LOGGER=Logger.getLogger(MyHclLoginPage.class);
	
	public MyHclLoginPage(AppiumDriver<MobileElement> appiumDriver) throws PageNotLoadedException {
		super(appiumDriver);
		androidDriver=getAndroidDriver();
	}
	
	public boolean waitForPageLoad()
	{
		boolean isPageLoaded=false;
		try{
			waitForElement(LOGINPAGE,60);
			isPageLoaded=true;
		}catch(TimeoutException timeoutException){
			LOGGER.error("TimeoutException is occured");
		}catch(NoSuchElementException noSuchElementException)
		{
			LOGGER.error("NoSuchElement Exception is occured");
		}
		return isPageLoaded;
	}
	
	public void enterUsername(String username)
	{
		setTextField(USERNAME,username);
	}
	public void enterPassword(String password)
	{
		setTextField(PASSWORD,password);
	}
	public void selectDomain(String domain)
	{
		androidDriver.findElement(DOMAINBUTTON).click();
		
		List<MobileElement> listDomain=waitForListElement(DOMAINSELECTIONLIST, 40);
		
		for(MobileElement domainChoice:listDomain)
		{
			if(domainChoice.getText().equalsIgnoreCase(domain))
			{
				domainChoice.click();
				break;
			}
		}
		
	}
	public void clickOnLoginButton()
	{
		MobileElement LoginButton=waitForElement(LOGINBUTTON);
		LoginButton.click();
	}
}
