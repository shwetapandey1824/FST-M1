package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Google Home Page$")
	public void givenFunction()throws Throwable {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\JayshriSubhashLinge\\OneDrive - IBM\\Documents\\project\\WebDrivers\\geckodriver-v0.35.0-win-aarch64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
	}
	

	@When("^User types cheese and hit enter$")
		public void whenFunction()throws Throwable {
		driver.findElement(By.name("q")).sendKeys("cheese",Keys.ENTER);
		}
	
	@Then("^Show how many serach results were shown$")
		public void thenFunction() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls")));
		driver.findElement(By.id("hdtb-tls")).click();
		String totalResult = driver.findElement(By.id("result-stats")).getText();
		System.out.println(totalResult);		
	}
	
	@And("^close browser$")
	public void andFunction() throws Throwable {
		driver.close();
	}
	
	

}
