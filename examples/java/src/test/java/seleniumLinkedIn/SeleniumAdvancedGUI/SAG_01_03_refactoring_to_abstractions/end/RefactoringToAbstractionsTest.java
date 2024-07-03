package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_01_03_refactoring_to_abstractions.end;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RefactoringToAbstractionsTest {

    @Test
    public void aTestWithNoAbstractions(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");

        createTodoList(driver, "My First Todo List");

        WebElement rendername;
        String listDataId = "My-First-Todo-List";

        rendername = getTodoListNameElement(driver, listDataId);

        Assertions.assertEquals(listDataId,
                rendername.getText());

        driver.close();
    }

    private WebElement getTodoListNameElement(WebDriver driver, String listDataId) {
        WebElement rendername;
        final WebElement listitem = driver.findElement(
                By.cssSelector(
                        "li[data-id='" + listDataId + "']"));

        rendername = listitem.findElement(
                By.tagName("label"));
        return rendername;
    }

    private void createTodoList(WebDriver driver, String listName) {
        final WebElement todoListNameInput =
                driver.findElement(
                        By.cssSelector("input.new-todo-list"));

        todoListNameInput.sendKeys(
                listName + Keys.ENTER);
    }

}
