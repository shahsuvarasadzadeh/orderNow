import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class RequiredFieldsValidationTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromDriverr\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extension");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com");
    }
    @Test
    public void testRequiredFieldsValidation() throws InterruptedException {
        testMainNavigation(driver);
        WebElement submitButton = driver.findElement(By.cssSelector(".Button_primary__d2Jt3 > span"));
        submitButton.click();
        WebElement validationMessage = driver.findElement(By.cssSelector(".EmailInput_email_error__IJxXf"));
        Assertions.assertTrue(validationMessage.isDisplayed(), "Validation message should be displayed");
        Thread.sleep(2000);
        driver.findElement(By.id("modalusername")).sendKeys("shakh42@gmail.com");
        driver.findElement(By.id("current-password")).sendKeys("shakh426545");
        WebElement submitBtn = driver.findElement(By.cssSelector(".Button_primary__d2Jt3 > span"));
        submitBtn.click();
        Assertions.assertFalse(validationMessage.isDisplayed(),
                "Validation message should not be displayed after filling required fields");
        Thread.sleep(3000);
    }
    private static void testMainNavigation(WebDriver driver) {
        WebElement homeLink = driver.findElement(By.linkText("Log in"));
        homeLink.click();
    }
}