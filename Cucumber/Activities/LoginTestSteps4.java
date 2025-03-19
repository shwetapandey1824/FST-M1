package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps4 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Login page$")
	public void GivenFuntion() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://training-support.net/webelements/login-form");
		
	}
	
	@When("User enters {string} and {string}")
	public void whenFuntion(String username, String password) {
		//WebElements
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password1 = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//*[text()='Submit']"));
		
		userName.sendKeys("admin");
		password1.sendKeys("password");
		submitButton.click();
		
	}
	
	@Then("^Read the page title and confirmation message1$")
	public void thenFuntion() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("mt-5")));
		
		String pageTitle = driver.getTitle();
		String confirmationMessgae = driver.findElement(By.className("mt-5")).getText();
		System.out.println(pageTitle);
		System.out.println(confirmationMessgae);
		
	}
	
	@And("^Close the Browser1$")
	public void AndFuntion() {
		driver.close();
	}
}
