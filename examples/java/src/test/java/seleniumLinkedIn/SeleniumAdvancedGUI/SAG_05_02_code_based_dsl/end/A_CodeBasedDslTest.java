package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_02_code_based_dsl.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_CodeBasedDslTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
    }

    @Test
    public void canCreateAList(){
        /*
        user thinks of a todo list name and
        creates the todo list then
        uses the todo list and
        adds a todo "my todo" and
        adds a todo "my other todo"
         */

        CDslTodoUser user = new CDslTodoUser(driver);

        user.thinksOfATodoListName().and().
                createsTodoList().then().
                usesTodoList().and().
                addsTodo("my todo").and().
                addsTodo("my other todo");

        Assertions.assertEquals(
                2,
                new CDslTodoListPage(driver)
                        .countTodos());

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
