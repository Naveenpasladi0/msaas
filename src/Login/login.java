package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ckt-pc32/Documents/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stagingdev.dotsimple.io/login");

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

        // TC - 01 - Invalid login - Empty Fields
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(""); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(""); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click(); // Click on Sign In button
        Thread.sleep(3000);
        //TC - 02 - Invalid login - Invalid email id and Empty password field
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("exodexo@gmailcom"); // Invalid email id
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(""); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click(); // Click on Sign In button
        Thread.sleep(3000);
        driver.navigate().refresh();
        //TC - 03 - Invalid login - Empty email id and Invalid password field
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(""); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123456789012345"); // Invalid password field
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click(); // Click on Sign In button
        Thread.sleep(3000);
        driver.navigate().refresh();
        //TC - 04 - Invalid login - Invalid email id and Invalid password field
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("exodexo@gmailcom"); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123456789012345"); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click(); // Click on Sign In button
        Thread.sleep(3000);
        driver.navigate().refresh();
        //TC - 05 - Valid Login - Valid email id and password
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("exodecxo@gmail.com"); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Coder@321"); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click(); // Click on Sign In button
        Thread.sleep(3000);
        driver.navigate().refresh();

        // Quit Browser
        Thread.sleep(3000); // Wait time for 3 seconds
        driver.quit();
    }
}