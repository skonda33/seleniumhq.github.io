package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_01_page_objects.begin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicTodosListPage {

    private final WebDriver driver;

    public BasicTodosListPage(final WebDriver driver) {
        this.driver = driver;
    }

    public void createTodoList(final String listName) {
        final WebElement inputField =
                driver.findElement(
                        By.cssSelector(".new-todo-list"));

        inputField.sendKeys(listName + Keys.ENTER);
    }

    public List<WebElement> getLists() {
        return driver.findElements(
                By.cssSelector("ul.todo-list-list li div.view"));
    }
}
