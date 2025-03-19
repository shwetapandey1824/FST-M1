package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 
{
	WebDriver driver;

	@BeforeClass
	public void beforeClass() 
    {
		//create a WebDriver instance
		driver = new FirefoxDriver();

		//go to a web page
		driver.get("http://alchemy.hguy.co/orangehrm");

		//do stuff on the page
		System.out.println("Title of the page is : " + driver.getTitle());
    }
 
	@AfterClass
	public void afterClass() 
	{
 	     // Close the driver
		driver.close();
	}
	
	@SuppressWarnings("deprecation")
	@Test
    public void getImageURL() 
    {
		WebElement image = driver.findElement(By.tagName("img"));
		System.out.println("Image URL is - " + image.getAttribute("src"));
	
    }

}
