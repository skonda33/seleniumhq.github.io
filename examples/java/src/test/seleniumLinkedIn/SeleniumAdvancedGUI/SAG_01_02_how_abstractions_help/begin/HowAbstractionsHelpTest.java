package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_01_02_how_abstractions_help.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowAbstractionsHelpTest {

    private WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist");
    }

    @Test
    public void canCreateATodoList(){

        // ATodoAppNavigator
        // ATodoListsPage

    }

    @Test
    public void canCreateAnotherTodoList() {

        // ATodoAppUser
        // ATodoListsPage

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
