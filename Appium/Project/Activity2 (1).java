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

public class Activity2 {

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
    public void addNote() throws InterruptedException {
        // Click the Create New Note button
        driver.findElement(AppiumBy.accessibilityId("Create a note")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/new_note_button"))).click();
        
        // Add a title for the note
        Thread.sleep(1000);
        WebElement titleField = driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        String noteTitle = "Test Note Title";
        titleField.sendKeys(noteTitle);

        // Add a small description
        WebElement descriptionField = driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        String noteDescription = "This is a test note description.";
        descriptionField.sendKeys(noteDescription);
        Thread.sleep(1000);
        // Press the back button
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();
       
        // Assert that the note was added
        List<WebElement> notes = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']"));
      // int i = notes.size();
       //System.out.print(i);
        boolean noteAdded = notes.stream().anyMatch(note -> note.getText().equals(noteTitle));
        
        Assert.assertTrue(noteAdded, "The note was not added successfully.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}