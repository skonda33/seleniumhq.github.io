package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_01_navigation.end;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UseTodoListPage {
    private final WebDriver driver;

    public UseTodoListPage(final WebDriver driver) {
        this.driver = driver;
    }

    public void createTodo(final String do_this) {

        final WebElement createTodo =
                driver.findElement(By.cssSelector("input.new-todo"));

        createTodo.sendKeys(do_this + Keys.ENTER);
    }

    public int countActiveTodos() {
        final List<WebElement> todoItems =
                driver.findElements(
                        By.cssSelector("ul.todo-list li div.view"));

        return todoItems.size();
    }
}
