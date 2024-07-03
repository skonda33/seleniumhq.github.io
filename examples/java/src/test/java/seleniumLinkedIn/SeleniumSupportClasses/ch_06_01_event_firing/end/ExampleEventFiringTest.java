package seleniumLinkedIn.SeleniumSupportClasses.ch_06_01_event_firing.end;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringDecorator;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class ExampleEventFiringTest {

    WebDriver driver;

    @BeforeEach
    public void createDriver(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/supportclasses/");

    }

    @Test
    public void loggingFindingElements() {

        final By resend = By.id("resend-select");
        final By noSuchElement = By.id("no-such-element");



//        EventFiringWebDriver events = new EventFiringWebDriver(driver);
        LocalEventFiringListener localEventFiringListener = new LocalEventFiringListener();
        WebDriver events = new EventFiringDecorator(localEventFiringListener).decorate(driver);
//        events.register(new LocalEventFiringListener());

        WebElement resendElem = events.findElement(resend);
        Assertions.assertNotNull(resendElem);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            events.findElement(noSuchElement);
        });

    }


    @AfterEach
    public void closeDriver(){
        driver.quit();
    }

    private class LocalEventFiringListener implements WebDriverListener {



        @Override
        public void beforeFindElement(  WebDriver driver,By locator) {
            System.out.println("Looking For " + locator.toString());
        }

        @Override
        public void afterFindElement(WebDriver driver, By locator, WebElement result) {
            System.out.println("Finished looking for " + locator.toString());
        }
    }
}
