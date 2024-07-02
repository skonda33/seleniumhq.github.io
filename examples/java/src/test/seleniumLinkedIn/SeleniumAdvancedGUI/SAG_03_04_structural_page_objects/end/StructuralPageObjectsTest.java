package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_04_structural_page_objects.end;

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

public class StructuralPageObjectsTest {

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

        todolists.typeListName(listName);
        //todolists.submitListName();
        todolists.loseNameFocus();


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

    private class TodoListsPage {
        private final WebDriver driver;

        final By newTodoListEntryField = By.cssSelector(".new-todo-list");
        final By aDeleteButton = By.cssSelector("button.destroy");
        final By allListNameItems = By.cssSelector("ul.todo-list-list li");
        private WebElement inputField;
        private By pageHeading = By.tagName("h1");

        public TodoListsPage(final WebDriver driver) {
            this.inputField =
                    driver.findElement(
                            newTodoListEntryField);
            this.driver = driver;
        }

        public void typeListName(final String listName) {
            inputField.sendKeys(listName);
        }

        public void submitListName() {
            inputField.sendKeys(Keys.ENTER);
        }
        public void clickDeleteButtonForListNamed(final String listName) {

            final WebElement todoListEntry =
                    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector(
                                    "li[data-id='" + listName + "'] div.view")
                    ));

            todoListEntry.findElement(aDeleteButton).click();

        }

        public int countLists(){
            return driver.findElements(
                    allListNameItems)
                    .size();
        }

        public void loseNameFocus() {
            driver.findElement(pageHeading).click();
        }

        public void confirmDeleteAlert() {
            driver.switchTo().alert().accept();
        }
    }
}
