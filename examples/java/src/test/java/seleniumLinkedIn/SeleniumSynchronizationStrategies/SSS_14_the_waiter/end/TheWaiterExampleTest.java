package seleniumLinkedIn.SeleniumSynchronizationStrategies.SSS_14_the_waiter.end;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class TheWaiterExampleTest {


    WebDriver driver;

    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    private class ButtonPage {

        @FindBy(how = How.ID, using = "easy00")
        public WebElement startButton;

        @FindBy(how = How.ID, using = "easy01")
        public WebElement button01;

        @FindBy(how = How.ID, using = "easy02")
        public WebElement button02;

        @FindBy(how = How.ID, using = "easy03")
        public WebElement button03;

        @FindBy(how = How.ID, using = "easybuttonmessage")
        public WebElement buttonMessage;

        public ButtonPage(WebDriver driver){
            PageFactory.initElements(driver, this);
        }
    }

    @Test
    public void canClickOnButtons(){

        driver = new ChromeDriver();

        Waiter waiter = new Waiter();

        waiter.get("https://eviltester.github.io/synchole/buttons.html", driver);

        ButtonPage page = new ButtonPage(driver);

        waiter.click(page.startButton, driver);
        waiter.click(page.button01, driver);
        waiter.click(page.button02, driver);
        waiter.click(page.button03, driver);

        waiter.waitForElementTextContainsString(page.buttonMessage,
                "All Buttons Clicked", driver);

        Assertions.assertEquals("All Buttons Clicked",
                page. buttonMessage.getText());
    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }


}
