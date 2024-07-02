package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_01_page_objects.end;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TodosListPageFactory {

    @FindBy(how = How.CSS, using = ".new-todo-list")
    public WebElement createTodoList;

    @FindBy(how = How.CSS, using = "ul.todo-list-list li div.view")
    public List<WebElement> lists;

    public TodosListPageFactory(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
