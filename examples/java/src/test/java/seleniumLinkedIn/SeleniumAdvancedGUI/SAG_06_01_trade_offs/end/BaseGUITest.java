package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_01_trade_offs.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseGUITest {

    public WebDriver driver;
    public final String MAINURL =
            new BaseInfrastructure().getMainPageUrl();

    @BeforeEach
    public void startBrowser(){
        driver = new BaseDriverAbstraction().open();
        driver.get(MAINURL);
    }

    public void createTodoList(String listName){
        new BaseTodoListsPage(driver).enterTodoListName(listName);
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
