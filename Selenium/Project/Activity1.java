package seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 
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
 
	@Test
    public void getPageTitle() 
    {
		if (driver.getTitle().matches("OrangeHRM")) 
		{
			System.out.println("Welcome to : " + driver.getTitle());
		} 
		else 
		{
			System.out.println("Incorrect Website");
		}
		
		 Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
}
