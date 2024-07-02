package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_03_domain.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*

“The purpose of abstraction is not to be vague,
but to create a new semantic level in which
one can be absolutely precise.”

E.W Dijkstra - The Humble Programmer

 */
public class DomainObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void canCreateAList(){

        TodoListName listName = new TodoListName();

        DomainObjectsTodoListsPage todolists = new DomainObjectsTodoListsPage(driver);

        todolists.enterTodoListName(listName.getName());

        Assertions.assertEquals(
                listName.getName(),
                todolists.getDisplayedListText(listName.getName()));

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class TodoListName {
        private final String name;

        public TodoListName() {
            this.name = new RandomDomainString("-").generate();
            System.out.println("Generate TODO LIST: " + name);
        }

        public String getName() {
            return name;
        }

    }
}
