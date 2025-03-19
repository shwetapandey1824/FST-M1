package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
    // Driver Declaration
	 AndroidDriver driver;
	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.android.chrome");
	        options.setAppActivity("com.google.android.apps.chrome.Main");
	        options.noReset();
	        URL serverURL = new URI("http://localhost:4723").toURL();
	        driver = new AndroidDriver(serverURL, options);
	        driver.get("https://training-support.net");
	    }
	    @Test
	    public void chromeTest() throws InterruptedException {
	        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
	        Thread.sleep(5000);
	        System.out.println("Heading: " + pageHeading);
	        driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).click();
	        Thread.sleep(5000);
	        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
	        System.out.println(aboutPageHeading);
	    }
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}