package com.hcl.usaa.appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumExecutionMethod;
import io.appium.java_client.AppiumSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class UtilityClass {
public static AppiumDriver getDeviceDriver(String OS,String DeviceName,String ApplicationName)
{
	AppiumDriver appiumDriver=null;
	if(OS.equalsIgnoreCase("ANDROID"))
	{
		DesiredCapabilities options=new DesiredCapabilities();
		//options.setPlatform(Platform.ANDROID);
		options.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4");
		options.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		options.setCapability(MobileCapabilityType.DEVICE_NAME,DeviceName);
		options.setCapability("appPackage", "com.android.settings");
		options.setCapability("appActivity", ".Settings");
		
		try {
			appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	else{
		
	}
	return appiumDriver;
}

}

