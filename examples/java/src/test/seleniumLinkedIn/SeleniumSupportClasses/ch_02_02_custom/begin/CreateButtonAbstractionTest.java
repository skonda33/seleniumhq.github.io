package seleniumLinkedIn.SeleniumSupportClasses.ch_02_02_custom.begin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
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

public class CreateButtonAbstractionTest {

    static WebDriver driver;

    @BeforeAll
    public static void createDriver(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/supportclasses/");

    }

    @Test
    public void canClickAButton(){

        final WebElement buttonElement = driver.findElement(By.id("resend-select"));

        // rather than click on a button element,
        // could we click on a Button?

        Assertions.assertEquals("Resend Single Option Message", buttonElement.getText());

        buttonElement.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.textToBe(By.id("message"),
                        "Received message: selected 1"));
    }


    @AfterAll
    public static void closeDriver(){
        driver.quit();
    }

}
