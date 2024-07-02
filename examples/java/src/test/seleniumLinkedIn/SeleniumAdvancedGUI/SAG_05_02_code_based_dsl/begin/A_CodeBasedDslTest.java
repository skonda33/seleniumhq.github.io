package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_02_code_based_dsl.begin;

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

        CDslTodoUser user = new CDslTodoUser(driver);

        CDslTodoListName listName = new CDslTodoListName();
        user.createsTodoList(listName);

        Assertions.assertEquals(
                listName.getName(),
                new CDslTodoListsPage(driver)
                        .getDisplayedListText(listName.getName()));

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
