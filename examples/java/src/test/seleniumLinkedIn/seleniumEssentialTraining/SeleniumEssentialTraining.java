package seleniumLinkedIn.seleniumEssentialTraining;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumEssentialTraining {
    RemoteWebDriver driver;

    @Test(priority = 1)
    public void keyBoard() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys("hey siva");
        Assertions.assertEquals("hey siva", textBox.getAttribute("value"));

        WebElement button = driver.findElement(By.cssSelector("button#button"));
        button.click();
        driver.quit();

    }

    @Test(priority = 2)
    public void scrollTo() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement fullName = driver.findElement(By.className("form-control"));
        Actions a = new Actions(driver);
        a.scrollToElement(fullName);
        a.moveToElement(fullName);

        fullName.sendKeys("siva full name");
        Assertions.assertEquals("siva full name", fullName.getAttribute("value"));
        WebElement date = driver.findElement(By.xpath("//input[@class='form-control' and @id = 'date']"));
        date.sendKeys("01/07/1980");
        Assertions.assertEquals("01/07/1980", date.getAttribute("value"));
        driver.quit();

    }

    @Test(priority = 3)
    public void switchToWindow() {

        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTab = driver.findElement(By.xpath("//button[@id='new-tab-button']"));
        newTab.click();

        String originalWindow = driver.getWindowHandle();
        //String originalTitle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String w : windowHandles) {
            if (!w.equals(originalWindow)) {
                driver.switchTo().window(w);
                break;
            }


        }
        Assertions.assertNotEquals(originalWindow, driver.getWindowHandle());
        driver.switchTo().window(originalWindow);
        Assertions.assertEquals(originalWindow, driver.getWindowHandle());
        driver.quit();

    }

    @Test(priority = 4)
    public void swithToAlert() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alert-button']"));
        alertButton.click();

        Alert a = driver.switchTo().alert();
        a.accept();

        driver.quit();


    }

    @Test(priority = 5)
    public void dragAndDrop() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement from = driver.findElement(By.xpath("//div[@id='image']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='box']"));

        Actions a = new Actions(driver);
        a.dragAndDrop(from, to).build().perform();
        driver.quit();


    }

    @Test(priority = 6)
    public void radioButtons() {

        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/radiobutton");

        WebElement r1 = driver.findElement(By.cssSelector("input#radio-button-1"));
        r1.click();
        Assertions.assertTrue(r1.getAttribute("defaultChecked").equals("true"));
        Assertions.assertTrue(r1.getAttribute("checked").equals("true"));

        WebElement r2 = driver.findElement(By.cssSelector("input[value='option2']"));
        r2.click();
        Assertions.assertTrue(r2.getAttribute("checked").equals("true"));

        WebElement r3 = driver.findElement(By.xpath("//div/input[@value='option3']"));
        r3.click();
        Assertions.assertTrue(r3.getAttribute("checked").equals("true"));


        driver.quit();


    }

    @Test(priority = 7)
    public void datePicker() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/datepicker");

        WebElement date = driver.findElement(By.className("form-control"));
        date.sendKeys("01/01/2024");
        date.sendKeys(Keys.RETURN);

        driver.quit();

    }

    @Test(priority = 8)
    public void dropDown() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.cssSelector("button#dropdownMenuButton"));
        dropDown.click();

        List<WebElement> selectOption = driver.findElements(By.xpath(
                "//div/a[@class='dropdown-item' and @href='/checkbox']"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        final Boolean until = wait.until(driver -> selectOption.get(1).isDisplayed());
        //final Boolean until = wait.until(ExpectedConditions.visibilityOfElementLocated());
        selectOption.get(1).click();

        driver.quit();
    }


}
