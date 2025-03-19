package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
  public static void main(String[] args) {
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
    
    // Open the browser
    driver.get("https://training-support.net/webelements/login-form/");    
    System.out.println("Page title is: " + driver.getTitle());
    
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("password");    
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    
    System.out.println("New page title is: " + driver.getTitle());
    
    String message = driver.findElement(By.tagName("h1")).getText();
    System.out.println(message);

    // Close the browser  
    driver.quit();
  }
}