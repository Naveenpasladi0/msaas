package NewPost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class newpost {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ckt-pc32/Downloads/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stagingdev.dotsimple.io/login");

        // Login with valid credentials
        driver.findElement(By.id("email")).sendKeys("exodecxo@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Coder@321");
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        // Print message if test case passed
        System.out.println("Login Successfully Done");

        // Pop-Up Handling
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement popupElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gleap-tour-popover-content")));

            if (popupElement.isDisplayed()) {
                driver.findElement(By.cssSelector("#gleap-tour-popover-content > button")).click();
                System.out.println("Pop-up closed successfully.");
            } else {
                System.out.println("No pop-up detected.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // New Post - Click
        driver.findElement(By.cssSelector("#page-container > div > div.app-main > div > div.scrollbar-sidebar > div > ul > li:nth-child(2) > a > img")).click();
        // Original Text - Type content
        driver.findElement(By.cssSelector("#originaltext > div.si_she_post--caption.post-textarea > div > div.emojionearea-editor")).sendKeys("This is some sample text");
        // Add media - click
        driver.findElement(By.cssSelector("#originaltext > div.si__scedule_post--con.d-flex > div.si__calander-field.fold_open--link.add-media-btn")).click();
        // Wait time period
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Locate the checkbox element by its XPath or any other suitable locator
        Thread.sleep(2000);
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement checkbox = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/div/div[2]/form/div/div/div[2]/div[3]/div/div[3]/div/div[3]"));
            if (checkbox.isDisplayed()) {
                driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/div/div[2]/form/div/div/div[2]/div[3]/div/div[3]/div")).click();
                System.out.println("Checkbox Selected Successfully");
            } else {
                System.out.println("checkbox Is Not Selected");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
