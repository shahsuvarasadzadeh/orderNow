import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class WebsiteSecurityTest {
    @Test
    public void webSecurity() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromDriverr\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extension");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.cssSelector("[name='login']"));
        emailInput.sendKeys("admin042");
        passwordInput.sendKeys("Lankaran");
        loginButton.click();
        Thread.sleep(2000);
        String responseText = driver.findElement(By.cssSelector("._9ay7")).getText();
        if (responseText.contains("The email or mobile number you entered isn’t connected to an account.")) {
            System.out.println("App is safe");
        } else {
            System.out.println("Security vulnerability found");
        }
        Thread.sleep(3000);
        driver.close();
    }
}