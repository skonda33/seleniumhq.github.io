package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_03_domain.begin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class DomainObjectsTodoListsPage {
    private final WebDriver driver;

    public DomainObjectsTodoListsPage(final WebDriver driver) {
        this.driver = driver;
    }

    public void enterTodoListName(final String listName) {
        final WebElement inputField =
                driver.findElement(
                        By.cssSelector(".new-todo-list"));

        inputField.sendKeys(listName + Keys.ENTER);
    }

    public String getDisplayedListText(final String listName) {
        WebElement todoListEntry = driver.findElement(
                By.cssSelector(
                        "li[data-id='" + listName + "']"));

        return todoListEntry.findElement(
                By.tagName("label")).getText();
    }

    public void clickOnList(final String listName) {
        WebElement todoListEntry = driver.findElement(
                By.cssSelector(
                        "li[data-id='" + listName + "']"));

        todoListEntry.findElement(By.tagName("a")).click();
    }
}
