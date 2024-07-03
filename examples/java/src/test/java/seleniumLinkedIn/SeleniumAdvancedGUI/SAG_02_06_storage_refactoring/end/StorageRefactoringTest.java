package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_06_storage_refactoring.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

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

        String listName = "todos-eviltester";
        TodoInject todolist = new TodoInject(listName);
        todolist.getValues();
        todolist.addTodo("my newest todo", true);
        todolist.storeValues();

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

    private class TodoInject {
        private final String listName;
        List<Map<String, Object>> values;

        public TodoInject(String listName) {
            this.listName = listName;
            this.values = new ArrayList<>();
        }

        public void getValues() {
            // the values in storage are a stringified array of objects [{}]
            // the objects have title, completed and id e.g.
            // [{"title":"todo 1","completed":false,"id":1583428868451}]

            // completely use JS to access local storage and get data

            values =
                    (List<Map<String, Object>>)
                            ((JavascriptExecutor)driver).
                                    executeScript(
                    "return JSON.parse(localStorage.getItem('" + listName + "'))");
        }

        public void addTodo(String todoName, boolean completed) {
            //create todo in hashmap and add to list
            Map<String, Object>newTodo = new HashMap<>();
            newTodo.put("completed", completed);
            newTodo.put("id", System.currentTimeMillis());
            newTodo.put("title", todoName);
            values.add(newTodo);
        }

        public void storeValues() {
            // inject list as json into local storage
            ((JavascriptExecutor)driver).
                    executeScript(
                            "localStorage.setItem('" + listName + "'," +
                                    " JSON.stringify(arguments[0]));", values);
        }
    }
}
