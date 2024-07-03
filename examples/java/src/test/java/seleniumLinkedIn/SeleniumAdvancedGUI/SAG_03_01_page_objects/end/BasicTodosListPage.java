package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_01_page_objects.end;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(inputField));

        inputField.sendKeys(listName + Keys.ENTER);
    }

    public List<WebElement> getLists() {
        return driver.findElements(
                By.cssSelector("ul.todo-list-list li div.view"));
    }
}
