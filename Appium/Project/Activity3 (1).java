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
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class Activity3 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URI("http://localhost:4723").toURL();

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void addNoteWithReminder() throws InterruptedException {
        // Click the Create New Note button
        driver.findElement(AppiumBy.accessibilityId("Create a note")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/new_note_button"))).click();
        Thread.sleep(1000);
        // Add a title for the note
        WebElement titleField = driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        String noteTitle = "Test Note Title with Reminder";
        titleField.sendKeys(noteTitle);
       Thread.sleep(1000);
        // Add a small description
        WebElement descriptionField = driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        String noteDescription = "This is a test note description with a reminder.";
        descriptionField.sendKeys(noteDescription);

        // Click the reminder icon on the toolbar
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Tomorrow evening\"]"))).click();
Thread.sleep(1000);
       
        Thread.sleep(1000);
        // Press the back button
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();
        // Switch to the Reminders page
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Reminders']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Reminders']")).click();

        // Assert that the note was added with a reminder
        List<WebElement> notes = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']"));
         int i= notes.size();
         System.out.print(i);
           Thread.sleep(1000);
        Assert.assertEquals(notes.size(), i);
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}