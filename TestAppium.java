package teststs;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class tetete {
	AppiumDriver driver;

	@Test
	public void testAppium() {
		//AndroidDriver<WebElement> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SM-G950F");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android");
		
		File file = new File("C:\\Users\\user\\eclipse-workspace\\teststs\\src\\apk\\beehd.android_4.7.0.apk");
		//capabilities.setCapability("app", file.getAbsolutePath());


		
		try {
			URL url = new URL("http://localhost:4723/wd/hub");
	        
			 driver = new AppiumDriver<MobileElement>(url, capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void makeACall() {
		MobileElement el = (MobileElement) driver.findElementByAccessibilityId("Dial");
		el.click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);


		el = (MobileElement) driver.findElementByAccessibilityId("Transmitters");
		el.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		el = (MobileElement) driver.findElementByAccessibilityId("More options");
		el.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		el = (MobileElement) driver.findElementByLinkText("Show Video");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		
		el = (MobileElement) driver.findElementById("com.radvision.beehd:id/incall_contact_item_uri\r\n"+ "");
		el.click();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Desktop\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://google.com");
		tetete tetete = new tetete();
		tetete.testAppium();
		//tetete.afterTest();
		tetete.makeACall();
	
	}

} 
