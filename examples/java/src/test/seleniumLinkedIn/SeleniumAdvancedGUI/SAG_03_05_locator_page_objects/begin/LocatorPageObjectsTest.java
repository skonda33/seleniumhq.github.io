package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_05_locator_page_objects.begin;

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

public class LocatorPageObjectsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");

    }

    @Test
    public void canCreateThenDeleteAList(){

        String listName = "my-new-list";

        TodoListsStructuralPage todolists = new TodoListsStructuralPage(driver);

        int defaultListCount = todolists.countLists();
        todolists.typeListName(listName);
        //todolists.loseNameFocus();
        todolists.submitListName();

        Assertions.assertEquals(
                defaultListCount + 1,
                todolists.countLists());

        todolists.clickDeleteButtonForListNamed(listName);
        todolists.confirmDeleteAlert();

        Assertions.assertEquals(
                defaultListCount,
                todolists.countLists());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class TodoListsStructuralPage {
        private final WebDriver driver;

        final By newTodoListEntryField = By.cssSelector(".new-todo-list");
        final By pageHeading = By.tagName("h1");
        final By aDeleteButton = By.cssSelector("button.destroy");
        final By allListNameItems = By.cssSelector("ul.todo-list-list li");

        final WebElement inputField;

        public TodoListsStructuralPage(final WebDriver driver) {
            this.driver = driver;

            inputField =
                    driver.findElement(
                            newTodoListEntryField);
        }

        public void typeListName(final String listName) {
            inputField.sendKeys(listName);
        }

        public void loseNameFocus() {
            driver.findElement(pageHeading).click();
        }

        public void submitListName() {
            inputField.sendKeys(Keys.ENTER);
        }

        public void clickDeleteButtonForListNamed(final String listName) {

            final WebElement todoListEntry =
                    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                            ExpectedConditions.presenceOfElementLocated(
                                    By.cssSelector(
                                            "li[data-id='" + listName + "']")
                            ));

            todoListEntry.findElement(aDeleteButton).click();
        }

        public void confirmDeleteAlert() {
            driver.switchTo().alert().accept();
        }

        public int countLists(){
            return driver.findElements(
                    allListNameItems)
                    .size();
        }

    }
}
