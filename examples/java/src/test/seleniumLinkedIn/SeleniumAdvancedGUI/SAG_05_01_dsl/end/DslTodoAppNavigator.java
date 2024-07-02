package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_01_dsl.end;

import org.openqa.selenium.WebDriver;

class DslTodoAppNavigator {
    private final WebDriver driver;

    public DslTodoAppNavigator(final WebDriver driver) {
        this.driver = driver;
    }

    public DslTodoListsPage toTodoListsPage() {
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
        return new DslTodoListsPage(driver);
    }
}
