package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_04_driver_Abstractions.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DriverAbstractionsTest {

    WebDriver driver;

    @BeforeEach
    public void startBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void testit(){

        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");
        driver.findElement(By.cssSelector("input.new-todo")).
            sendKeys("todo 1" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo"))
            .sendKeys("todo 2" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo"))
            .sendKeys("todo 3" + Keys.ENTER);
        By todoItemCheckbox = By.cssSelector("ul.todo-list input.toggle");
        List<WebElement> checkboxes = driver.findElements(todoItemCheckbox);
        Assertions.assertEquals(3, checkboxes.size());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

}
