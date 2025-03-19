package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Activity6 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URI("http://localhost:4723").toURL();

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testLoginWithCorrectCredentials() throws InterruptedException {
        driver.get("https://v1.training-support.net/selenium");

        // Wait for the "Get Started" button to be present and click it
        WebElement getStartedButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        getStartedButton.click();
        Thread.sleep(1000);

        // Scroll up using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollForward()"
        ));

        // Wait for the "Popups" card to be present and click it
        WebElement popupCard = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text, 'Popups')]")));
        popupCard.click();

        // Wait for the "Sign In" button to be present and click it
        Thread.sleep(1000);
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In \")")));
       signInButton.click();

        // Wait for the input fields to be present in the popup and enter credentials
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")));
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Log in']")));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");
        Thread.sleep(1000);
        loginButton.click();

        // Verify the success message
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Welcome Back, admin']")));
        Thread.sleep(1000);
        Assert.assertNotNull(successMessage, "Success message not displayed");

        // Assertion to verify the success message text
        Assert.assertEquals(successMessage.getText(), "Welcome Back, admin", "Success message text does not match");
    }

    @Test
    public void testLoginWithIncorrectCredentials() throws InterruptedException {
        driver.get("https://v1.training-support.net/selenium");

        // Wait for the "Get Started" button to be present and click it
        WebElement getStartedButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        getStartedButton.click();
        Thread.sleep(1000);

        // Scroll up using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollForward()"
        ));

        // Wait for the "Popups" card to be present and click it
        WebElement popupCard = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text, 'Popups')]")));
        popupCard.click();

        // Capture page source for debugging
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        // Wait for the "Sign In" button to be present and click it
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In \")")));
        signInButton.click();

        // Wait for the input fields to be present in the popup and enter credentials
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")));
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Log in']")));

        usernameField.sendKeys("wrong_user");
        passwordField.sendKeys("wrong_password");
        loginButton.click();

        // Verify the error message
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Invalid Credentials']")));
        Assert.assertNotNull(errorMessage, "Error message not displayed");

        // Assertion to verify the error message text
        Assert.assertEquals(errorMessage.getText(), "Invalid Credentials", "Error message text does not match");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}