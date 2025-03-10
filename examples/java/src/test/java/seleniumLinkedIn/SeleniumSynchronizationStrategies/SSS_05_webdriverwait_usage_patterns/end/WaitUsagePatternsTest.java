package seleniumLinkedIn.SeleniumSynchronizationStrategies.SSS_05_webdriverwait_usage_patterns.end;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*

Illustrate patterns:

- new WebDriverWait for every sync point
- shared local context wait
- wait and return a value
- wait as an alternative to an assertion
- shared driver context wait

 */
public class WaitUsagePatternsTest {

    WebDriver driver;

    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void waitForEverySyncPoint(){
        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/synchole/collapseable.html");

        final WebElement section = driver.findElement(By.cssSelector("section.condense"));
        section.click();

        final By linkToClick = By.cssSelector("a#aboutlink");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(linkToClick));

        final WebElement aboutLink = driver.findElement(linkToClick);
        aboutLink.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("about.html"));
    }

    @Test
    public void sharedLocalWait(){
        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/synchole/collapseable.html");

        final WebElement section = driver.findElement(By.cssSelector("section.condense"));
        section.click();

        final By linkToClick = By.cssSelector("a#aboutlink");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.elementToBeClickable(linkToClick));

        final WebElement aboutLink = driver.findElement(linkToClick);
        aboutLink.click();

        wait.until(ExpectedConditions.urlContains("about.html"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("about.html"));
    }

    @Test
    public void waitReturnsObject(){
        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/synchole/collapseable.html");

        final WebElement section = driver.findElement(By.cssSelector("section.condense"));
        section.click();

        final By linkToClick = By.cssSelector("a#aboutlink");

        final WebElement aboutLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(linkToClick));

        //final WebElement aboutLink = driver.findElement(linkToClick);
        aboutLink.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("about.html"));
    }

    @Test
    public void waitAsAnAlternativeToAssertion(){
        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/synchole/collapseable.html");

        final WebElement section = driver.findElement(By.cssSelector("section.condense"));
        section.click();

        final By linkToClick = By.cssSelector("a#aboutlink");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.elementToBeClickable(linkToClick));

        final WebElement aboutLink = driver.findElement(linkToClick);
        aboutLink.click();

        // waiting instead of an assertion
        wait.until(ExpectedConditions.urlContains("about.html"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("about.html"));
    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }

}
