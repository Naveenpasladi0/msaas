package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ckt-pc32/Downloads/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stagingdev.dotsimple.io/login");

        //TC - 01 - Invalid login - Empty Fields
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(""); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(""); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click(); // Click on Sign In button
        Thread.sleep(3000);
        driver.navigate().refresh();
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
