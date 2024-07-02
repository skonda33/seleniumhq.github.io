package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_06_functional_page_objects.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FunctionalPageObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void canCreateThenDeleteAList(){

        String listName = "my-new-list";

        TodoListsPage todolists = new TodoListsPage(driver);

        int defaultListCount = todolists.countLists();

        todolists.createTodoList(listName);

        Assertions.assertEquals(
                defaultListCount + 1,
                todolists.countLists());

        todolists.deleteTodoListNamed(listName);

        Assertions.assertEquals(
                defaultListCount,
                todolists.countLists());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class TodoListsPage {
        private final WebDriver driver;
        private final StructuralTodoListPageObject structural;


        public TodoListsPage(final WebDriver driver) {
            this.driver = driver;
            this.structural = new StructuralTodoListPageObject(driver);
        }

        public void createTodoList(final String listName) {
            structural.typeListName(listName);
            structural.submitListName();
        }

        public void deleteTodoListNamed(final String listName) {
            structural.clickDeleteButtonForListNamed(listName);
            structural.confirmDeleteAlert();
        }

        public int countLists(){
            return structural.countLists();
        }

    }
}
