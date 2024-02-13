package Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class monthly {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/ckt-pc32/Downloads/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stagingdev.dotsimple.io/login");

        // Login with valid credentials
        driver.findElement(By.id("email")).sendKeys("exodecxo@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Coder@321");
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();

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

        // Click on calendar module
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[2]/div/div[4]/div/ul/li[1]")).click();
        // Click on Select Items
        driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/button")).click();
        // Click on Monthly button
        driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/div/div/button[1]")).click();
        // Click on All Post
        driver.findElement(By.xpath("//*[@id=\"horizontal-menu\"]/div/div/a[1]")).click();
        // Click on + Icon
        // driver.findElement(By.cssSelector("#calendar > div.fc-view-harness.fc-view-harness-active > div > table > tbody > tr.fc-scrollgrid-section.fc-scrollgrid-section-body.fc-scrollgrid-section-liquid > td > div > div > div > table > tbody > tr:nth-child(3) > td.fc-daygrid-day.fc-day.fc-day-tue.fc-day-today > a > i")).click();
        // Post - Original Text
        // driver.findElement(By.xpath("//*[@id=\"originaltext\"]/div[2]/div/div[1]")).sendKeys("This is some sample text");
        // Post - Add Media
        // driver.findElement(By.xpath("//*[@id=\"originaltext\"]/div[1]/div[2]/a")).click();
    }
}