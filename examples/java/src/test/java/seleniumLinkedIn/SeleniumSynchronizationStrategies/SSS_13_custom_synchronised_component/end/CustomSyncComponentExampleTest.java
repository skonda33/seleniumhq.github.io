package seleniumLinkedIn.SeleniumSynchronizationStrategies.SSS_13_custom_synchronised_component.end;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomSyncComponentExampleTest {

    WebDriver driver;

    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void canClickOnSecondButtonsWithComponent(){

        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/synchole/buttons.html");

        ButtonComponent startButton = new ButtonComponent(driver, By.id("button00"));
        startButton.waitTillReady();
        startButton.click();
        Assertions.assertTrue(startButton.isReady());

        ButtonComponent buttonOne = new ButtonComponent(driver, By.id("button01"));
        buttonOne.waitTillReady();
        buttonOne.click();

        ButtonComponent buttonTwo = new ButtonComponent(driver, By.id("button02"));
        buttonTwo.waitTillReady();
        buttonTwo.click();

        ButtonComponent buttonThree = new ButtonComponent(driver, By.id("button03"));
        buttonThree.waitTillReady();
        buttonThree.click();

        Assertions.assertEquals("All Buttons Clicked",
                driver.findElement(By.id("buttonmessage")).getText());
    }

    private class ButtonComponent extends CanWaitTillReady{
        private final By locator;
        private final WebDriver myDriver;

        public ButtonComponent(WebDriver myDriver, final By elementLocator) {
            super(myDriver,10);
            this.myDriver = myDriver;
            this.locator = elementLocator;
        }

        public void nowReady(){
            WebElement elem = this.myDriver.findElement(this.locator);
            if(elem.isDisplayed() && elem.isEnabled()){
                return;
            }else{
                throw new IllegalStateException(
                        String.format("Button %s not ready", this.locator));
            }
        }

        public void click() {
            this.myDriver.findElement(this.locator).click();
        }
    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }

    private class CanWaitTillReady {
        private final WebDriver myDriver;
        private final Duration secondsTimeout;

        public CanWaitTillReady(WebDriver myDriver, int seconds) {
            this.myDriver = myDriver;
            this.secondsTimeout = Duration.ofSeconds(seconds);
        }

        public void nowReady(){
            throw new RuntimeException("not implemented nowReady");
        }

        public boolean isReady(){
            try{
                nowReady();
                return true;
            }catch (IllegalStateException e){
                return false;
            }
        }

        public void waitTillReady(){

            ExpectedCondition<Boolean> nowReadyHasNoException = myDriver -> {
                nowReady();
                return true;
            };

            new WebDriverWait(this.myDriver, this.secondsTimeout).
                    ignoring(IllegalStateException.class).until(nowReadyHasNoException);
        }
    }
}
