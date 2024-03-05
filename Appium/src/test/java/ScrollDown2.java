import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class ScrollDown2 {

   public AppiumDriver driver;
//   public AndroidTouchAction action;
    

    @BeforeTest
    public void setUp() {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo V21");     //Mobile Device name
            cap.setCapability(MobileCapabilityType.UDID, "192.168.10.3:5555");   //Mobile device adb name getting through cmd
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

            cap.setCapability("appPackage", "com.gwhyyy.publicApis");
            cap.setCapability("appActivity", "com.gwhyyy.publicApis.MainActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver(url, cap);
//		driver = new AndroidDriver(url, cap);  //Appium driver is parent of Mobile driver

        }catch(Exception e) {
            System.out.println("Cause is:" +e.getCause());
            System.out.println("Message is:" +e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority=0)
    public void clickTest() {

        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"ok\"]")).click();    
    }
    
    
   @Test
   public void Scroll_Test() {
//	  WebElement c = driver.findElement(AppiumBy.accessibilityId("Calender"));
//	  c.click();
	  
	  driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\'Books\']")).click();
	   
   }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}


