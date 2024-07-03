package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_02_code_based_dsl.begin;

import org.openqa.selenium.WebDriver;

class CDslTodoUser {
    private final WebDriver driver;
    private final CDslTodoAppNavigator navigate;

    public CDslTodoUser(final WebDriver driver) {
        this.driver = driver;
        navigate = new CDslTodoAppNavigator(driver);
    }

    public void createsTodoList(final CDslTodoListName listName) {
        navigate.toTodoListsPage().
            enterTodoListName(listName.getName());
    }
}
