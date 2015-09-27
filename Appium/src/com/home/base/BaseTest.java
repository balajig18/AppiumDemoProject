package com.home.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
	
	@SuppressWarnings("rawtypes")
	public AppiumDriver getDeviceDriver(String OS,String DeviceName,String ApplicationName)
	{
		AppiumDriverLocalService driverLocalService=new AppiumServiceBuilder().usingAnyFreePort()
				.usingDriverExecutable(new File("D:\\Android\\Appium\\node.exe"))
				.withAppiumJS(new File("D:\\Android\\Appium\\node_modules\\appium\\bin\\appium.js"))
				.build();
		AndroidDriver appiumDriver = null;
		
		if(OS.equalsIgnoreCase("ANDROID"))
		{
			DesiredCapabilities options=new DesiredCapabilities();
			options.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
			options.setCapability(MobileCapabilityType.DEVICE_NAME,DeviceName);
			options.setCapability("appPackage", "com.android.settings");
			options.setCapability("appActivity", ".Settings");
			
			appiumDriver=new AndroidDriver<MobileElement>(driverLocalService, options);

		}
		else{
		}
		return appiumDriver;
		
	}
}
