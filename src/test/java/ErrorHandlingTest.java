import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ErrorHandlingTest {
    @Test
    public void errorHandling() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromDriverr\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://abb-bank.az");
            WebElement orderNowButton = driver.findElement(By.cssSelector(
                    ".color-17253a[href='https://abb-bank.az/az/ferdi/kartlar']"));
            orderNowButton.click();
            Thread.sleep(2000);
            System.out.println("successfully");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Error: Order Now button not found on the page.");
        } catch (org.openqa.selenium.WebDriverException e) {
            System.out.println("Error: WebDriver encountered an issue - " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.close();
        }
    }
}