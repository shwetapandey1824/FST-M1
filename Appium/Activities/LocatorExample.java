package examples;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LocatorExample {
	
	AppiumDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException{
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
		options.noReset();
		
        URL serverURL = new URI("http://localhost:4723").toURL();
        
        driver = new AndroidDriver(serverURL, options);
	}
	
    @Test
    public void Test() {
    	
    	driver.findElement(AppiumBy.id("digit_2")).click();
    	//driver.findElement(AppiumBy.accessibilityId("plus")).click();
    	driver.findElement(AppiumBy.id("op_add")).click();
    	driver.findElement(AppiumBy.id("digit_2")).click();
    	//driver.findElement(AppiumBy.accessibilityId("equals")).click();
  
    	
    	String result = driver.findElement(AppiumBy.id("result_preview")).getText();
    	Assert.assertEquals(result,"4");
    	
    }
    
       @AfterClass
       public void tearDown() {
       // Close the app
       driver.quit();
    }
}
