package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_03_component_abstractions.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComponentAbstractionsTest {


    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");

    }

    @Test
    public void canCreateAList(){

        String listName = "my-new-list";

        TodoListsPage todolists = new TodoListsPage(driver);

        int currentLists = todolists.countLists();

        todolists.enterTodoListName(listName);

        Assertions.assertEquals(currentLists+1,
                                todolists.countLists());
    }

    @Test
    public void canCreateTodos(){

        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");

        TodoListPage todolist = new TodoListPage(driver);

        int currentTodos = todolist.countTodos();

        String todoItemNamed = "Do this thing";
        todolist.enterTodo(todoItemNamed);

        Assertions.assertEquals(currentTodos+1,
                                todolist.countTodos());

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class TodoListsPage {
        private final WebDriver driver;

        public TodoListsPage(final WebDriver driver) {
            this.driver = driver;
        }

        public void enterTodoListName(final String listName) {
            new CreateInputBox(driver, ".new-todo-list").enter(listName);
        }

        public int countLists(){
            return driver.findElements(
                    By.cssSelector("ul.todo-list-list li div.view"))
                    .size();
        }
    }

    private class TodoListPage {
        private final WebDriver driver;

        public TodoListPage(final WebDriver driver) {
            this.driver=driver;
        }

        public void enterTodo(final String todoItemNamed) {
            new CreateInputBox(driver,"input.new-todo" ).
                    enter(todoItemNamed);
        }

        public int countTodos() {
            return driver.findElements(
                    By.cssSelector("ul.todo-list li div.view")).
                    size();
        }
    }


    private class CreateInputBox {
        private final WebDriver driver;
        private String cssSelector;

        public CreateInputBox(WebDriver driver, String cssSelector) {
            this.driver = driver;
            this.cssSelector = cssSelector;
        }

        public void enter(String text) {
            final WebElement inputField =
                    driver.findElement(
                            By.cssSelector(cssSelector));

            inputField.sendKeys(text + Keys.ENTER);
        }
    }
}
