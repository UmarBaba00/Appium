
import io.appium.java_client.AppiumBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class ScrollDown {

   public AppiumDriver driver;
//   public AndroidTouchAction action;
    

    @BeforeTest
    public void setUp() {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo V21");     //Mobile Device name
            cap.setCapability(MobileCapabilityType.UDID, "192.168.10.2:5555");   //Mobile device adb name getting through cmd
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
    
//    @SuppressWarnings("deprecation")
	@Test(priority=1)
    public void scroll_down () throws InterruptedException {
    	
//    	driver.findElement(AppiumBy.accessibilityId("Calender")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Calendar\"]")).click();
		
		Thread.sleep(200);
    	
    	// Scroll Untill View an Element
    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LectServe\"));")); //scrollIntoView method is used to scroll the GUI upto specified text
    	                                                  //UiScrollable is a powerfull Android class that perform element lookup in scrollable layout
    	
    	
//    	driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
//    	                                                  +".scrollIntoView(new UiSelector()" + ",textMatches(\"" +"LectServe" + "\").instance(0))"));
    	
    	driver.findElement(By.xpath("//android.view.View[@content-desc=\"LectServe\"]")).click();
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	WebElement calender = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Books\"]"));
////    	AndroidElement calender = (AndroidElement) driver.findElementByAccessibilityId("Calender");
//    	
//    	//Tap
//    	action = new AndroidTouchAction(driver);
//    	action.tap(ElementOption.element(calender)).perform();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

