package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_02_pojo_page_objects.begin;

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

public class PojoPageObjectsTest {


    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");

    }

    @Test
    public void canCreateAList(){

        String listName = "my-new-list";

        final WebElement inputField =
                driver.findElement(
                        By.cssSelector(".new-todo-list"));

        inputField.sendKeys(listName + Keys.ENTER);

        WebElement todoListEntry = driver.findElement(
                                        By.cssSelector(
                                                "li[data-id='" + listName + "']"));
        Assertions.assertEquals(listName,
                todoListEntry.findElement(By.tagName("label")).getText());
    }

    @Test
    public void canCreateTodos(){

        // should not really re-use tests - re-use abstractions instead
        canCreateAList();

        // click on the list name
        String listName = "my-new-list";

        WebElement todoListEntry = driver.findElement(
                By.cssSelector(
                        "li[data-id='" + listName + "']"));

        todoListEntry.findElement(By.tagName("a")).click();

        // create a todo in the list
        final WebElement createTodo =
                driver.findElement(By.cssSelector("input.new-todo"));

        String todoItemNamed = "Do this thing";
        createTodo.sendKeys(todoItemNamed + Keys.ENTER);

        // check one item in list
        final List<WebElement> todoItems =
                                driver.findElements(
                                        By.cssSelector("ul.todo-list li div.view"));

        Assertions.assertEquals(1, todoItems.size());

        // i could refactor this into local methods to make it readable
        // but we know we are going to use page objects so refactor this into page objects
        // do not put assertions in the page objects - these belong in the tests
        // initially refactor to page objects
        // then write the code you want to see and create,
        // refactoring the page object as you go
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

}
