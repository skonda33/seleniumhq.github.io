package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_01_dsl.end;

import org.openqa.selenium.WebDriver;

class DslTodoUser {
    private final WebDriver driver;
    private final DslTodoAppNavigator navigate;

    public DslTodoUser(final WebDriver driver) {
        this.driver = driver;
        navigate = new DslTodoAppNavigator(driver);
    }

    public void createTodoList(final DslTodoListName listName) {
        DslTodoListsPage todolists =
                            navigate.toTodoListsPage();
        todolists.enterTodoListName(listName.getName());
    }
}
