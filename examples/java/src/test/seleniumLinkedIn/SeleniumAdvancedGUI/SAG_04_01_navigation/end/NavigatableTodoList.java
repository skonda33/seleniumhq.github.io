package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_01_navigation.end;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatableTodoList {

    private final WebDriver driver;

    public NavigatableTodoList(final WebDriver driver) {
        this.driver = driver;
    }

    public UseTodoListPage useTodoListNamed(final String todoListName) {
        driver.findElement(By.cssSelector(
                String.format("li[data-id='%s'] div.view a",
                                todoListName))).click();

        return new UseTodoListPage(driver);
    }
}
