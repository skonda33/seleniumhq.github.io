package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_02_data.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void canCreateAList(){

        String listName = new RandomString("-").generate();

        DataObjectsTodoListsPage todolists = new DataObjectsTodoListsPage(driver);

        todolists.enterTodoListName(listName);

        Assertions.assertEquals(
                listName,
                todolists.getDisplayedListText(listName));
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
