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
import java.util.List;

public class Activity4 {

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
    public void testToDoList() throws InterruptedException {
        driver.get("https://v1.training-support.net/selenium");

        // Wait for the "Get Started" button to be present and click it
        WebElement getStartedButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        getStartedButton.click();
        Thread.sleep(1000);

        // Scroll up using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));

        // Wait for the "To-Do List" card to be present and click it
        WebElement toDoListCard = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text, 'To-Do List')]")));
        toDoListCard.click();

        // Wait for the input field to be present
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        // Find the input field and add tasks
        String[] tasks = {"Add tasks to list", "Get number of tasks", "Clear the list"};

        for (String task : tasks) {
            inputField.sendKeys(task);
           
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
            Thread.sleep(1000);
        }

        // Verify tasks are added
        for (String task : tasks) {
            WebElement addedTask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='" + task + "']")));
           Thread.sleep(1000);
            Assert.assertNotNull(addedTask, "Task not added: " + task);
        }

        // Click on each task to strike them out
        for (String task : tasks) {
            WebElement addedTask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='" + task + "']")));
            Thread.sleep(1000);
            addedTask.click();
        }

        // Clear the list
        WebElement clearButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]")));
        Thread.sleep(1000);
        clearButton.click();
        Thread.sleep(1000);

        // Verify the list is cleared
        Thread.sleep(2000); // Adding some wait time to ensure the list is cleared
        List<WebElement> remainingTasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']//android.view.View"));
        Assert.assertEquals(remainingTasks.size(), 0, "List not cleared. Remaining tasks: " + remainingTasks.size());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}