package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity5 
{
	WebDriver driver;
	String message;
	WebDriverWait wait;
	Actions builder;
	
		
	@BeforeClass
	public void setup() 
    {
		//create a WebDriver instance
		driver = new FirefoxDriver();
		
		builder = new Actions(driver);
		
		//go to a web page
		driver.get("http://alchemy.hguy.co/orangehrm");

		//do stuff on the page
		System.out.println("Title of the page is : " + driver.getTitle());
    }
	
	@BeforeTest
	public void setupBeforeTest() 
    {
		// Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));		
    }
 
	@AfterClass
	public void tearDown() 
	{
 	     // Close the driver
		driver.close();
	}
	
	@DataProvider(name = "LoginCredientials")
	public static Object[][] credentials() {
	    return new Object[][] { 
	        { "orange", "orangepassword123" }
	    };
	}
	
	@Test(priority = 1, dataProvider = "LoginCredientials")
    public void login(String sUsername, String sPassword) 
    {
		// Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.name("txtPassword"));

        // Enter credentials
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);

        // Click login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        System.out.println("Title of the new page is : " + driver.getTitle());
        
        // Read login message
        String loginMessage = driver.findElement(By.id("welcome")).getText();
        
        System.out.println("Confirmation message is - " + loginMessage);
                
        //Verify that the homepage has opened
        message = driver.findElement(By.tagName("h1")).getText();
        System.out.println("You are on " + message);
        
        Assert.assertEquals(message, "Dashboard");
    }
	
	@SuppressWarnings("deprecation")
	@Test(priority = 2)
    public void editUserInformation() throws InterruptedException 
    {
		//Find the “My Info” menu item and click it.
		//driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		
		WebElement leave = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
		
		builder.moveToElement(leave).pause(1000).click(leave).pause(2000).build().perform();
		
		System.out.println("Clicked on My Info tab");
		
		message = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).getText();
		System.out.println("You are on " + message);
        
        //Find the “Edit” menu item and click it.
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
      	
        //Fill in the Name, Gender, Nationality, and the DOB fields. and Click Save.
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Archana");
        
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
    	driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Gidavir");
    	
    	driver.findElement(By.id("personal_optGender_2")).click();
    	
    	driver.findElement(By.id("personal_DOB")).clear();
    	driver.findElement(By.id("personal_DOB")).sendKeys("1990-04-28");
    	
    	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    	System.out.println("New Information saved successfully..!!");
        
    	Thread.sleep(2000);
    	
    	System.out.println("Updated First Name : " + driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"));
        System.out.println("Updated Last Name : " + driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value"));
    	System.out.println("Updated Gender : " + driver.findElement(By.id("personal_optGender_2")).isSelected());
    	System.out.println("Updated DOB : " + driver.findElement(By.id("personal_DOB")).getAttribute("value"));
        
    }

	

}
