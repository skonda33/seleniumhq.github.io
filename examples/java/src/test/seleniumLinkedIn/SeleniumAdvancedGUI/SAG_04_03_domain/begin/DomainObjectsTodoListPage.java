package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_03_domain.begin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class DomainObjectsTodoListPage {
    private final WebDriver driver;

    public DomainObjectsTodoListPage(final WebDriver driver) {
        this.driver=driver;
    }

    public void enterTodo(final String todoItemNamed) {
        final WebElement createTodo =
                driver.findElement(By.cssSelector("input.new-todo"));

        createTodo.sendKeys(todoItemNamed + Keys.ENTER);
    }

    public int countTodos() {
        return
                driver.findElements(
                        By.cssSelector("ul.todo-list li div.view")).size();
    }
}
