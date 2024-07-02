package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_02_data.end;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
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

        TodoListName listName = new TodoListName();

        DataObjectsTodoListsPage todolists = new DataObjectsTodoListsPage(driver);

        todolists.enterTodoListName(listName.getName());

//        Assertions.assertEquals(
//                listName,
//                todolists.getDisplayedListText(listName));
        for(int x=0;x<15;x++){
            todolists.enterTodoListName(new TodoListName().getName());
        }
        System.out.println("Use the app now");
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class TodoListName {
        private final String name;

        public TodoListName(){
            this.name = new Faker().lorem().sentence().replace(" ","-");
            //this.name = new RandomString("-").generate();
            System.out.println("Create Todo List " + name);
        }

        public String getName() {
            return name;
        }
    }
}
