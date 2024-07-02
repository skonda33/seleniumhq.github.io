package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_01_03_refactoring_to_abstractions.begin;

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

        final WebElement todoListNameInput =
                driver.findElement(
                        By.cssSelector("input.new-todo-list"));

        todoListNameInput.sendKeys(
                "My First Todo List" + Keys.ENTER);

        final WebElement listitem = driver.findElement(
                By.cssSelector(
                        "li[data-id='My-First-Todo-List']"));

        final WebElement rendername = listitem.findElement(
                By.tagName("label"));

        Assertions.assertEquals("My-First-Todo-List",
                rendername.getText());

        driver.close();
    }
}
