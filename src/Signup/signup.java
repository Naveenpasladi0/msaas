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
        WebElement recaptchaCheckbox = driver.findElement(By.cssSelector("#recaptcha-anchor"));
        recaptchaCheckbox.click();
        // Switch back to the main content
        driver.switchTo().defaultContent();
        // Click on the signup button
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        // Refresh the page
        driver.navigate().refresh();
        // Check if the test case passed and print the corresponding message
        String currentUrl = driver.getCurrentUrl();
        String expectedUrlAfterSignup = "https://stagingdev.dotsimple.io/signup";
        if (currentUrl.equals(expectedUrlAfterSignup)) {
            System.out.println("Test Case 01 - Invalid Signup Details - Empty fields passed successfully!");
        } else {
            System.out.println("Test Case 01 - Invalid Signup Details - Empty fields failed!");
        }


        // TC - 02 - Invalid Signup Details - Invalid Details
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[2]/input")).sendKeys("exo"); // Empty first name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[3]/input")).sendKeys("decxo"); // Empty last name field
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/main/section/div/div[2]/div[2]/div/div/form/div[4]/input")).sendKeys("exodecxo"); // Empty email field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("147852369"); // Empty password field
        driver.findElement(By.xpath("//*[@id=\"cpassword\"]")).sendKeys("147852369"); // Empty confirm password field
        // Switch to the iframe containing reCAPTCHA
        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe1);
        // Click on the reCAPTCHA checkbox
        WebElement recaptchaCheckbox1 = driver.findElement(By.cssSelector("#recaptcha-anchor"));
        recaptchaCheckbox1.click();
        // Switch back to the main content
        driver.switchTo().defaultContent();
        // Click on the signup button
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        // Check if the test case passed and print the corresponding message
        String currentUrl1 = driver.getCurrentUrl();
        String expectedUrlAfterSignupString = "https://stagingdev.dotsimple.io/signup";
        if (currentUrl.equals(expectedUrlAfterSignup)) {
            System.out.println("Test Case 02 - Invalid Signup Details - Invalid Details passed successfully!");
        } else {
            System.out.println("Test Case 02 - Invalid Signup Details - Invalid Details failed!");
        }

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
        WebElement recaptchaCheckbox2 = driver.findElement(By.cssSelector("#recaptcha-anchor"));
        recaptchaCheckbox2.click();
        // Switch back to the main content
        driver.switchTo().defaultContent();
        // Click on the signup button
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        // Check if the test case passed and print the corresponding message
        String currentUrl2 = driver.getCurrentUrl();
        String expectedUrlAfterSignupStringString = "https://stagingdev.dotsimple.io/signup";
        if (currentUrl.equals(expectedUrlAfterSignup)) {
            System.out.println("Test Case 03 - Valid Signup Details - All Valid Details passed successfully!");
        } else {
            System.out.println("Test Case 03 - Valid Signup Details - All Valid Details failed!");
        }
        // Quit Browser
        Thread.sleep(3000); // Wait time for 3 seconds
        driver.quit();
    }
}
