package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_01_trade_offs.begin;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InheritanceExampleTest extends BaseGUITest{

    @BeforeEach
    public void start(){
        startBrowser();
    }

    @Test
    public void canCreateATodo(){

        String listName = "My First Todo List";

        final WebElement todoListNameInput =
                driver.findElement(
                        By.cssSelector("input.new-todo-list"));

        todoListNameInput.sendKeys(
                listName + Keys.ENTER);

        Assertions.assertEquals(2,
                driver.findElements(
                    By.cssSelector("ul.todo-list-list li"))
                .size());

    }

    @AfterEach
    public void close(){
        closeBrowser();
    }
}
