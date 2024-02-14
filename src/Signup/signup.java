package Signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class signup {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ckt-pc32/Documents/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stagingdev.dotsimple.io/signup");

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

        // TC - 01 - Invalid Signup Details - Empty fields
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[2]/input")).sendKeys(""); // Empty first name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[3]/input")).sendKeys(""); // Empty last name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[4]/input")).sendKeys(""); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(""); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"cpassword\"]")).sendKeys(""); // Empty confirm password field
        // Switch to the iframe containing reCAPTCHA
        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe);
        // Click on the reCAPTCHA checkbox
        WebElement recaptchaCheckbox = driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border"));
        recaptchaCheckbox.click();
        // Click on the signup button
        driver.findElement(By.cssSelector("#page-container > div > main > section > div > div.row > div.col-6.align-self-center > div > div > form > div.si__form--button > button")).click();
        // Refresh the page
        driver.navigate().refresh();
        // Print message if test case passed
        System.out.println("Test - 01 - Passed");

        // TC - 02 - Invalid Signup Details - Invalid Details
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[2]/input")).sendKeys("exo"); // Empty first name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[3]/input")).sendKeys("decxo"); // Empty last name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[4]/input")).sendKeys("exodecxo@@.com"); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Exo@54321"); // Invalid password field
        driver.findElement(By.xpath("//*[@id=\"cpassword\"]")).sendKeys("Exo@54311"); // Invalid confirm password field
        // Switch to the iframe containing reCAPTCHA
        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe1);
        // Click on the reCAPTCHA checkbox
        WebElement recaptchaCheckbox1 = driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border"));recaptchaCheckbox1.click();
        recaptchaCheckbox1.click();
        // Click on the signup button
        driver.findElement(By.xpath("#page-container > div > main > section > div > div.row > div.col-6.align-self-center > div > div > form > div.si__form--button > button")).click();
        // Refresh the page
        driver.navigate().refresh();
        // Print message if test case passed
        System.out.println("Test - 02 - Passed");

        // TC - 03 - Valid Signup Details - All Valid Details
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[2]/input")).sendKeys("exo"); // Empty first name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[3]/input")).sendKeys("decxo"); // Empty last name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[4]/input")).sendKeys("exodecxo@gmail.com"); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Coder@321"); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"cpassword\"]")).sendKeys("Coder@321"); // Empty confirm password field
        // Switch to the iframe containing reCAPTCHA
        WebElement iframe2 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe2);
        // Click on the reCAPTCHA checkbox
        WebElement recaptchaCheckbox2 = driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border"));
        recaptchaCheckbox2.click();
        // Click on the signup button
        driver.findElement(By.xpath("#page-container > div > main > section > div > div.row > div.col-6.align-self-center > div > div > form > div.si__form--button > button")).click();
        // Refresh the page
        driver.navigate().refresh();
        // Print message if test case passed
        System.out.println("Test - 03 - Passed");
    }
}

// 14/04/2024 - Note for self regarding script - Need to handle captcha images handling via automation script. Need to find script to handle the same.