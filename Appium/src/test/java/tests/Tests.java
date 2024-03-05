package tests;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Tests extends BaseClass {

	@Test
	public void testOne() {
		
		 ExtentTest test1 = extent.createTest("Test One", "Sample test case for demo");
		 
		 test1.log(Status.INFO, "Test One Started");
		driver.get("https://google.com");
		test1.log(Status.PASS, "Navigate to https://google.com" );
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.log(Status.PASS, "Enter Automation in google search box" );
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test1.log(Status.PASS, "Hit the Enter Key" );

		System.out.println("Completed Test One...");
		test1.log(Status.INFO, "Test One Completed" );
	}

	@Test
	  public void testLogin() throws Exception {
	    driver.get("https://www.google.com/search?q=orangehrm&rlz=1C1BNSD_enPK971PK974&oq=or&aqs=chrome.0.69i59j69i57j46i131i199i433i465i512j0i131i433i512j0i131i433i650j69i60l3.1731j0j7&sourceid=chrome&ie=UTF-8");
	    driver.findElement(By.xpath("//div[@id='rso']/div[2]/div/div/div/div/div/div/div/span/a/h3")).click();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    isElementPresent(By.xpath("//button[@type='submit']"));
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    driver.findElement(By.xpath("//div[@id='app']/div/div/header/div/div[2]/ul/li/span/p")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }

	 private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
}
