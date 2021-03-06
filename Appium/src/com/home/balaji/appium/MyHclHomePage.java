package com.home.balaji.appium;


	
	import java.util.List;

	import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

	import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;


	public class MyHclHomePage {

		private AppiumDriver appiumDriver=null;
		public boolean isPageLoaded=false;
		
		private static final By MENUBUTTON=By.xpath("//*[@class='android.widget.Button' and @NAF='true']");
		private static final By USERNAME=By.xpath("//*[@class='android.widget.EditText' and @text='Username']");
		private static final By PASSWORD=By.xpath("//*[@class='android.widget.EditText' and @NAF='true']");
		private static final By DOMAINBUTTON=By.xpath("//*[@class='android.widget.Spinner' and @index='2']");
		private static final By DOMAINSELECTIONLIST=By.xpath("//*[@class='android.widget.CheckedTextView']");
		private static final By LOGINBUTTON=By.xpath("//*[@class='android.widget.Button' and @text='LOGIN']");
		
		
		
		private static final Logger LOGGER=Logger.getLogger(MyHclLoginPage.class);
		
		public MyHclHomePage(AppiumDriver appiumDriver) {
			this.appiumDriver=appiumDriver;
			waitForPageLoad();
		}
		
		public void waitForPageLoad()
		{
			try{
				WaitClass.waitFor(appiumDriver,MENUBUTTON, 60);
				isPageLoaded=true;
			}catch(TimeoutException timeoutException){
				LOGGER.error("TimeoutException is occured");
			}catch(NoSuchElementException noSuchElementException)
			{
				LOGGER.error("NoSuchElement Exception is occured");
			}
		}
		/*public void enterUsername(String username)
		{
			WaitClass.waitFor(appiumDriver, USERNAME, 60);
			appiumDriver.findElement(USERNAME).sendKeys(username);
		}
		public void enterPassword(String password)
		{
			WaitClass.waitFor(appiumDriver, PASSWORD, 60);
			appiumDriver.findElement(PASSWORD).sendKeys(password);
		}
		public void selectDomain(String domain)
		{
			MobileElement mobileElement=null;
			WaitClass.waitFor(appiumDriver,DOMAINBUTTON, 60);
			appiumDriver.findElement(DOMAINBUTTON).click();
			WaitClass.waitFor(appiumDriver,DOMAINSELECTIONLIST, 60);
			List<WebElement> listDomain=appiumDriver.findElements(DOMAINSELECTIONLIST);
			
			for(WebElement domainChoice:listDomain)
			{
				mobileElement=((MobileElement)domainChoice);
				if(mobileElement.getText().equalsIgnoreCase(domain))
				{
					mobileElement.click();
					break;
				}
			}
			
		}
		public void clickOnLoginButton()
		{
			WaitClass.waitFor(appiumDriver,LOGINBUTTON, 60);
			appiumDriver.findElement(LOGINBUTTON).click();
		}*/
		public void clickOnMenuButton()
		{
			WaitClass.waitFor(appiumDriver,MENUBUTTON, 60);
			appiumDriver.findElement(MENUBUTTON).click();;
		}

		public void scrollPageUp()
		{
			TouchAction action=new TouchAction(appiumDriver);
			action.press(100,100).moveTo(100,50).release().perform();
		}
		public void scrollPageDown()
		{
			TouchAction action=new TouchAction(appiumDriver);
			action.press(50,50).moveTo(100,100).release().perform();
		}
	}



