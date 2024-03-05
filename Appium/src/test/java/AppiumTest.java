//import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class AppiumTest {

	
	static AppiumDriver driver;
	
	public static void main(String[] args) {
		try {
			openCalculaor();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	@Test
	public static void openCalculaor() throws Exception  {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "vivo V21");     //Mobile Device name
//		cap.setCapability("udid", "1541276746000JK");     //Mobile device adb name getting through cmd
		cap.setCapability("udid", "192.168.10.9:5555");   //Mobile device adb name getting through cmd used mobile IP Address
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("appPackage", "com.vivo.calculator");
		cap.setCapability("appActivity", "com.vivo.calculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver(url, cap);
		
		System.out.println("Application Started...");
		
		WebElement two = driver.findElement(By.id("com.vivo.calculator:id/digit2"));
		WebElement plus = driver.findElement(By.id("com.vivo.calculator:id/plus"));
		WebElement five = driver.findElement(By.id("com.vivo.calculator:id/digit5"));
		WebElement equal = driver.findElement(By.id("com.vivo.calculator:id/equal"));
		WebElement result = driver.findElement(By.id("com.vivo.calculator:id/input_edit"));
		
		two.click();
		plus.click();
		five.click();
		equal.click();
		
		
		String res = result.getText();
		System.out.println("\n Result is: " + res);
		System.out.println("Completed...");
	} 

}
