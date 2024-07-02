package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_06_storage_refactoring.before;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StorageRefactoringTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver(); // SafariDriver does not support WebStorage Interface at time of writing
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void injectATodoUsingJSDirect(){

        // the values in storage are a stringified array of objects [{}]
        // the objects have title, completed and id e.g.
        // [{"title":"todo 1","completed":false,"id":1583428868451}]

        // completely use JS to access local storage and get data
        List<Map<String, Object>> values =
                (List<Map<String, Object>>)
                    ((JavascriptExecutor)driver).
                        executeScript(
            "return JSON.parse(localStorage.getItem('todos-eviltester'))");


        //create todo in hashmap and add to list
        Map<String, Object>newTodo = new HashMap<>();
        newTodo.put("completed", true);
        newTodo.put("id", System.currentTimeMillis());
        newTodo.put("title", "my newest todo");
        values.add(newTodo);

        // inject list as json into local storage
        ((JavascriptExecutor)driver).
                executeScript(
                "localStorage.setItem('todos-eviltester'," +
                        " JSON.stringify(arguments[0]));", values);

        // visit list and check data exists
        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");
        final List<WebElement> listItems =
                driver.findElements(
                        By.cssSelector("ul.todo-list li div.view"));

        Assertions.assertEquals(1, listItems.size());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

}
