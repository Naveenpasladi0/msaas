package NewPost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class schedule {
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
        driver.findElement(By.cssSelector("#originaltext > div.si_she_post--caption.post-textarea > div > div.emojionearea-editor")).sendKeys("This content is only for Scheduled Post via Automation - Selenium and Java");
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
        // Click on Add Post button
        driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/div/div[2]/form/div/div/div[3]/div[2]/button")).click();
        // Click on Select Account button
        driver.findElement(By.cssSelector("#page-container > div > div.inner-layout > div.post-container.si__newcomp--sec.si__dashboard_right_block--con > form > div.si__compinn--con.d-flex.justify-content-between > div.si__comp_left--con > div.si_post_platform--con > div > div > span > span.selection > span > ul > li > input")).click();
        // Click on LinkedIn Account
        driver.findElement(By.xpath("/html/body/span/span/span/ul/li[2]")).click();
        // Click on Schedule Post Button
        driver.findElement(By.cssSelector("#page-container > div > div.inner-layout > div.post-container.si__newcomp--sec.si__dashboard_right_block--con > form > div.top_header_post_column > div.top_header_post_right_column > div > div > div.si__calander-field.si_post_datepicker > div")).click();
        // Select Date from Calendar - 20th feb 2024
        driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/form/div[1]/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div[1]/div[1]/table/tbody/tr[4]/td[2]")).click();
        // Click on Repeat this Post checkbox
        driver.findElement(By.cssSelector("#page-container > div > div.inner-layout > div.post-container.si__newcomp--sec.si__dashboard_right_block--con > form > div.top_header_post_column > div.top_header_post_right_column > div > div > div.si__calander-field.si_post_datepicker > div > div > div > div > div > div.si__publ_time--setting.repeat__post__container_schedule > div.si__publish--post.align-center > div > label > div")).click();
        // Enter Repeat Time
        driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/form/div[1]/div[2]/div/div/div[1]/div/div/div/div/div/div[3]/div[1]/label[1]/input")).sendKeys("1");
        // Enter Interval Time
        driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[1]/form/div[1]/div[2]/div/div/div[1]/div/div/div/div/div/div[3]/div[1]/label[2]/input")).sendKeys("12");
        // Click on Update button
        driver.findElement(By.cssSelector("#page-container > div > div.inner-layout > div.post-container.si__newcomp--sec.si__dashboard_right_block--con > form > div.top_header_post_column > div.top_header_post_right_column > div > div > div.si__calander-field.si_post_datepicker > div > div > div > div > div > div.si__shedul_submit--btn.d-flex.align-center > button.btn.update-btn.schedule_close_btn")).click();
    }
}
