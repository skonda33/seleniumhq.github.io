package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_04_driver_Abstractions.end;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@ExtendWith(SeleniumExtension.class)
public class JupiterDriverAbstractionsTest {

    //static String browserToUse =
    //          System.setProperty("sel.jup.default.browser","safari");

    @Test
    public void testit(WebDriver driver){
        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");
        driver.findElement(By.cssSelector("input.new-todo")).
                sendKeys("todo 1" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo")).
                sendKeys("todo 2" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo")).
                sendKeys("todo 3" + Keys.ENTER);
        By todoItemCheckbox = By.cssSelector("ul.todo-list input.toggle");
        List<WebElement> checkboxes = driver.findElements(todoItemCheckbox);
        Assertions.assertEquals(3, checkboxes.size());
        driver.close();
    }
}
