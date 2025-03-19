package seleniumproject;

import java.time.Duration;
import java.util.List;

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

public class Activity9 
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
	

	@Test(priority = 2)
    public void emergencyContacts() 
    {
		//Retrieve Emergency Contacts
		
		//Find the “My Info” menu item and click it.
		WebElement leave = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
		
		builder.moveToElement(leave).pause(1000).click(leave).pause(2000).build().perform();
		System.out.println("Clicked on My Info tab");
		
		message = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).getText();
		System.out.println("You are on " + message);
		
		//On the new page, Click on the “Emergency Contacts” on the left side menu
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
		System.out.println("Clicked on Emergency Contacts");
		
		//Retrieve information about all the contacts listed in the table.
		//Print all the information to the console
		
        //Find the number of columns from header in the table and print them.
	    List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr/th"));
	    System.out.println("total number of columns in header: " + cols.size()); 
        
        //Find the number of rows in the table and print them. 
	    List<WebElement> row = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr"));
	    System.out.println("total number of rows : " + row.size());

	    for (int i = 1; i <= row.size(); ++i)
	    {
	    	String a = String.valueOf(i);
	    	
	    	//Find and print all the cell values in the first row of the table.
	    	List<WebElement> rowData = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[" + a + "]"));
	    
	    	System.out.println(a + " row cell values: ");
	    	for(WebElement cell : rowData) 
    		{
    			System.out.println(cell.getText());
    		}	    	
	    }
		
    }

}
