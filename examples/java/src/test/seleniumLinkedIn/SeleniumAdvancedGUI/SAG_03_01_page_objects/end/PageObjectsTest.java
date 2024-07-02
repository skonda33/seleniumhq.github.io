package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_01_page_objects.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void usingAPageFactoryObject(){

        TodosListPageFactory todosList = new TodosListPageFactory(driver);

        String listName = "New-TODO-List";
        todosList.createTodoList.sendKeys(listName + Keys.ENTER);

        Assertions.assertEquals(2, todosList.lists.size());
    }

    @Test
    public void usingAPageObject(){

        BasicTodosListPage todosList = new BasicTodosListPage(driver);

        String listName = "New-TODO-List";
        todosList.createTodoList(listName);


        Assertions.assertEquals(2, todosList.getLists().size());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
