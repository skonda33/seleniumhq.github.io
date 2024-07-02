package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_01_dsl.end;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TodoListsSteps {

    WebDriver driver;
    DslTodoUser user;
    DslTodoListName listName;

    @Before
    public void createDriver(){
        driver = new ChromeDriver();
    }

    @Given("a user in the todolist app")
    public void aUserInTheTodolistApp() {
        user = new DslTodoUser(driver);
    }

    @When("the user creates a todolist")
    public void theUserCreatesATodolist() {
        listName = new DslTodoListName();
        user.createTodoList(listName);
    }

    @Then("the todolist is displayed")
    public void theTodolistIsDisplayed() {
        Assertions.assertEquals(
                listName.getName(),
                new DslTodoListsPage(driver)
                        .getDisplayedListText(listName.getName()));
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
