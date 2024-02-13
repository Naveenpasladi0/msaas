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
        // Click on month tab button
        driver.findElement(By.cssSelector("#calendar > div.fc-header-toolbar.fc-toolbar.fc-toolbar-ltr > div:nth-child(3) > div > button.fc-dayGridMonth-button.fc-button.fc-button-primary.fc-button-active")).click();
        // Click on + icon
        driver.findElement(By.cssSelector("#calendar > div.fc-view-harness.fc-view-harness-active > div > table > tbody > tr.fc-scrollgrid-section.fc-scrollgrid-section-body.fc-scrollgrid-section-liquid > td > div > div > div > table > tbody > tr:nth-child(4) > td.fc-daygrid-day.fc-day.fc-day-tue.fc-day-today > a > i")).click();
        // Click on Text Area and Type Content
        driver.findElement(By.cssSelector("#originaltext > div.si_she_post--caption.post-textarea > div > div.emojionearea-editor")).sendKeys("Sample Text For Automation Testing");
        // Click on Add Media button to add Media for the Posts
        driver.findElement(By.xpath("//*[@id=\"originaltext\"]/div[1]/div[2]/a")).click();
        // Add New Folder
        driver.findElement(By.xpath("//*[@id=\"upd-dropzone\"]/div[1]/div[3]/div[3]/div")).click();
        // Add New Folder Name
        // 3 Seconds wait time
        driver.findElement(By.xpath("//*[@id=\"main-si__form\"]/div/form/input[4]")).sendKeys("Exodecxo");
        // Click on Add Folder button
        driver.findElement(By.xpath("//*[@id=\"main-si__form\"]/div/form/div/button[2]")).click();
    }
}