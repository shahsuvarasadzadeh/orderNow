import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class LoginUsabilityTest {
    @Test
    public void logIn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromDriverr\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com");
        Thread.sleep(2000);
        testMainNavigation(driver);
        testFormSubmission(driver);
        Thread.sleep(2000);
        driver.close();
    }
    private static void testMainNavigation(WebDriver driver) {
        WebElement homeLink = driver.findElement(By.linkText("Log in"));
        homeLink.click();
    }
    private static void testFormSubmission(WebDriver driver) throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("modalusername"));
        nameInput.sendKeys("john.doe@example.com");
        WebElement emailInput = driver.findElement(By.id("current-password"));
        emailInput.sendKeys("4657486658Ssd");
        WebElement submitButton = driver.findElement(By.cssSelector(".Button_primary__d2Jt3 > span"));
        submitButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector(".LoginModal_modal_inner__zNxJo h1"));
        Assertions.assertTrue(successMessage.isDisplayed(), "Success message is not displayed.");
        String expectedSuccessText = "Please verify email";
        Thread.sleep(2000);
        String actualSuccessText = successMessage.getText();
        Assertions.assertTrue(actualSuccessText.contains(expectedSuccessText),
                "Success message text is incorrect. Expected: " + expectedSuccessText +
                        ", Actual: " + actualSuccessText);
    }
}