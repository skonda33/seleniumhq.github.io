package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_01_trade_offs.end;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTodoListsPage {

    private final WebDriver driver;

    public BaseTodoListsPage(final WebDriver driver) {
        this.driver = driver;
    }

    public void enterTodoListName(final String listName) {
        final WebElement inputField =
                driver.findElement(
                        By.cssSelector(".new-todo-list"));

        inputField.sendKeys(listName + Keys.ENTER);
    }


    public void clickOnList(final String listName) {
        WebElement todoListEntry = driver.findElement(
                By.cssSelector(
                        "li[data-id='" + listName + "']"));

        todoListEntry.findElement(By.tagName("a")).click();
    }

    public int countLists(){
        return driver.findElements(
                By.cssSelector("ul.todo-list-list li"))
                .size();
    }
}
