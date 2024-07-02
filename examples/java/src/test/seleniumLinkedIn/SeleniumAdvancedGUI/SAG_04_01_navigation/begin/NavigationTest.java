package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_01_navigation.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void navigationInPage(){

        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
        NavigatableTodoList todolist = new NavigatableTodoList(driver);
        final UseTodoListPage todopage = todolist.useTodoListNamed("eviltester");

        todopage.createTodo("Do This");

        Assertions.assertEquals(1, todopage.countActiveTodos());
    }

    @Test
    public void loginToAdmin(){

        driver.get("https://eviltester.github.io/simpletodolist/adminlogin.html");
        AdminLoginPage login = new AdminLoginPage(driver);
        final AdminViewPage admin = login.loginAs("Admin", "AdminPass");
        Assertions.assertEquals(1, admin.countLists());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
