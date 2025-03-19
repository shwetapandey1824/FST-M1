package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alerts {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on the alert page$")
	public void giveCondition1() {
		driver= new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://training-support.net/webelements/alerts");
	}
	
	@When("^User clicks the simple alert button$")
	public void whenCondition1() {
		driver.findElement(By.id("simple")).click();;
	}
	
	@When("^User clicks the Confirm alert button$")
	public void whenCondition2() {
		driver.findElement(By.id("confirmation")).click();;
	}
	
	@When("^User clicks the Prompt Alert button$")
	public void whenCondition3() {
		driver.findElement(By.id("prompt")).click();;
	}
	
	@Then("^Alert opens$")
	public void thenCOndition1() {
		driver.switchTo().alert();
	}
	
	@And("^Read the Text from it and print it$")
	public void andCondition1() {
		System.out.println("Message displayed on Alert is: " + driver.switchTo().alert().getText());
	}
	
	@And("^Write a custom message in it$")
	public void promptCondition() {
		driver.switchTo().alert().sendKeys("Hello Prompt,How are you?");
	}
	
	@And("^Close the alert$")
	public void andCondition2() {
		driver.switchTo().alert().accept();
	}
	
	@And("^Close the alert with Cancel$")
	public void andCondition3() {
		driver.switchTo().alert().dismiss();
	}
	
	@And("^Read the result text$")
	public void andCondition4() {
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
	}
	
	@And("^Close Browser$")
	public void close() {
		driver.close();
	}
		

}
