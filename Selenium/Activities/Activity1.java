package com.Activity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.until(ExpectedConditions.visibilityOfElementLocated())

    }
}
