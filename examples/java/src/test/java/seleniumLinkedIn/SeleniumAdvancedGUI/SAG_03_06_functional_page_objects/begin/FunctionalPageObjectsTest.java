package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_06_functional_page_objects.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FunctionalPageObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void canCreateThenDeleteAList(){

        String listName = "my-new-list";

        TodoListsPage todolists = new TodoListsPage(driver);

        int defaultListCount = todolists.countLists();

        todolists.enterTodoListName(listName);

        Assertions.assertEquals(
                defaultListCount + 1,
                todolists.countLists());

        todolists.clickDeleteForListNamed(listName);

        Assertions.assertEquals(
                defaultListCount,
                todolists.countLists());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class TodoListsPage {
        private final WebDriver driver;

        final By newTodoListEntryField = By.cssSelector(".new-todo-list");
        final By aDeleteButton = By.cssSelector("button.destroy");
        final By allListNameItems = By.cssSelector("ul.todo-list-list li");

        public TodoListsPage(final WebDriver driver) {
            this.driver = driver;
        }

        public void enterTodoListName(final String listName) {
            final WebElement inputField =
                    driver.findElement(
                            newTodoListEntryField);

            inputField.sendKeys(listName + Keys.ENTER);
        }

        public void clickDeleteForListNamed(final String listName) {

            final WebElement todoListEntry =
                    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                            ExpectedConditions.presenceOfElementLocated(
                                    By.cssSelector(
                                            "li[data-id='" + listName + "'] div.view")
                            ));

            todoListEntry.findElement(aDeleteButton).click();

            driver.switchTo().alert().accept();
        }

        public int countLists(){
            return driver.findElements(
                    allListNameItems)
                    .size();
        }

    }
}
