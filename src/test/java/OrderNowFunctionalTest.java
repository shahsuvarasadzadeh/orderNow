import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class OrderNowFunctionalTest {
    @Test
    public void orderNow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromDriverr\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extension");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://abb-bank.az");
        Thread.sleep(2000);
        WebElement orderNowButton = driver.findElement(By.cssSelector(
                ".color-17253a[href='https://abb-bank.az/az/ferdi/kreditler']"));
        orderNowButton.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://abb-bank.az/az/ferdi/kreditler")) {
            System.out.println("Functional test passed: Redirected to the correct page.");
        } else {
            System.out.println("Functional test failed: Redirected to an unexpected page.");
        }
        driver.close();
    }
}