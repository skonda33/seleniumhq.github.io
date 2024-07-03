package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_05_technology_abstractions.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StorageTechnologyAbstractionsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver(); // SafariDriver does not support WebStorage Interface at time of writing
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }


    @Test
    public void injectATodo(){

        WebStorage storage = (WebStorage) driver;

        final Set<String> keys = storage.getLocalStorage().keySet();

        // app has a default list called todos-eviltester
        Assertions.assertTrue(keys.contains("todos-eviltester"));

        // the values in storage are a stringified array of objects [{}]
        // the objects have title, completed and id e.g.
        // [{"title":"todo 1","completed":false,"id":1583428868451}]

        // Use the browser itself to parse the JSON in the localStorage
        List<Map<String, Object>> values =
            (List<Map<String, Object>>)
                ((JavascriptExecutor)driver).
                    executeScript("return JSON.parse(arguments[0])",
                        storage.getLocalStorage().getItem("todos-eviltester"));

        //create a new todo as a hash, and add to the list
        Map<String, Object>newTodo = new HashMap<>();
        newTodo.put("completed", true);
        newTodo.put("id", System.currentTimeMillis());
        newTodo.put("title", "my newest todo");
        values.add(newTodo);

        // use browser to convert the list of hashmaps into a JSON String
        String newjson = (String)((JavascriptExecutor)driver).
                    executeScript(
                        "return JSON.stringify(arguments[0]);", values);

        // use the WebDriver technology abstraction for local storage to write the data
        storage.getLocalStorage().setItem("todos-eviltester", newjson);

        // visit list and check data exists
        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");
        final List<WebElement> listItems =
                driver.findElements(
                        By.cssSelector("ul.todo-list li div.view"));

        Assertions.assertEquals(1, listItems.size());

        System.out.println(keys);
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
