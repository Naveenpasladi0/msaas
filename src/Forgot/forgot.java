package Forgot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class forgot {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ckt-pc32/Documents/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stagingdev.dotsimple.io/forgot");

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

        // TC - 01 - Enter empty email field and click on Submit
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(""); // Empty fields
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[3]/div/div/form/div[2]/button")).click(); // Click on Submit button
        driver.navigate().refresh();

        // TC - 02 - Enter invalid email id and click on submit
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("exodecso@gmail.com"); // Invalid data
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[3]/div/div/form/div[2]/button")).click(); // Click on Submit button
        driver.navigate().refresh();

        // TC - 03 - Enter invalid email and click on submit button
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("1234567890"); // Enter numbers only
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[3]/div/div/form/div[2]/button")).click(); // Click on Submit button
        driver.navigate().refresh();

        // TC - 04 - Enter invalid email and click on submit button
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("     "); // Enter spaces only
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[3]/div/div/form/div[2]/button")).click(); // Click on Submit button
        driver.navigate().refresh();

        // TC - 05 - Enter valid email and click on submit button
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("exodecxo@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[3]/div/div/form/div[2]/button")).click(); // Click on Submit button
        driver.navigate().refresh();

        // Quit Browser
        Thread.sleep(3000); // Wait time for 3 seconds
        driver.quit();
    }
}