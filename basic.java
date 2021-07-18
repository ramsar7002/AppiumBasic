package teststs;

import org.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import io.*;
import io.appium.java_client.android.AndroidDriver;
import teststs.FindingElements.UiAutomator;

import java.io.File;
import java.net.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class findElements {
	
	static public class UiAutomator{
		AndroidDriver dr;
		
		@Test
		public void testApp() throws MalformedURLException, InterruptedException{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", "galaxy s9");
				capabilities.setCapability("platformVersion", "9");
				capabilities.setCapability("platformName", "Android");
				
				dr = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
				dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				
		}
		
		public void addGusture() {
			for(int i=0; i<100; i++) {
			WebElement element = dr.findElementByAccessibilityId("More options");
			element.click();
			dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			List<WebElement> els = dr.findElementsByClassName("android.widget.LinearLayout");
			System.out.println(els.size());
			els.get(0).click();
			dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			els = dr.findElementsById("com.radvision.beehd:id/incall_contact_item_name");
			els.get(0).click();
			dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			element.click();
			dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			els = dr.findElementsByClassName("android.widget.LinearLayout");
			els.get(2).click();
			}

		}
		
		
		@AfterTest
		public void afterTest() throws InterruptedException{
			Thread.sleep(5000);
			dr.quit(); 
		}
		
		public static void main(String[] args) throws MalformedURLException, InterruptedException {
			UiAutomator dr = new UiAutomator();
			dr.testApp();
			dr.addGusture();
			dr.afterTest();
			}
		}

	}
