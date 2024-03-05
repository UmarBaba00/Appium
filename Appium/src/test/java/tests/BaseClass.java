package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends ExtentReportsDemo {
	
	static AppiumDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		try {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo V21");     //Mobile Device name
		cap.setCapability(MobileCapabilityType.UDID, "192.168.10.9:5555");   //Mobile device adb name getting through cmd
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
//		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//		cap.setCapability(MobileCapabilityType.APP, "");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		cap.setCapability("appPackage", "com.vivo.calculator");
		cap.setCapability("appActivity", "com.vivo.calculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver(url, cap);
//		driver = new AndroidDriver(url, cap);  //Appium driver is parent of Mobile driver
		
		}catch(Exception e) {
			System.out.println("Cause is:" +e.getCause());
			System.out.println("Message is:" +e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void sampleTest() {
		System.out.println("I'm inside");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
