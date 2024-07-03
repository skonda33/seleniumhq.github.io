package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_01_trade_offs.end;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class InheritanceExampleTest extends BaseGUITest{

    @Test
    public void canCreateATodo(){
        String listName = "My First Todo List";

        createTodoList(listName);

        Assertions.assertEquals(2,
                driver.findElements(
                    By.cssSelector("ul.todo-list-list li"))
                .size());
    }
}
