package teststs;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestAppium {
	AppiumDriver driver;

	@Test
	public void testAppium() {
		//AndroidDriver<WebElement> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SM-G950F");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android");
		
		File file = new File("C:\\Users\\user\\eclipse-workspace\\teststs\\src\\apk\\Indeed Job Search_v72.0_apkpure.com.apk");
		capabilities.setCapability("app", file.getAbsolutePath());


		
		try {
			URL url = new URL("http://10.72.100.80:4723/wd/hub");
	        
			 driver = new AppiumDriver(url, capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Desktop\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://google.com");
		TestAppium test = new tetete();
		test.testAppium();
		test.afterTest();
	
	}

} 
