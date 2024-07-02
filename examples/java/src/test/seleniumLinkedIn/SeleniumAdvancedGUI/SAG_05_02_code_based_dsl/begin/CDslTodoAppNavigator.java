package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_02_code_based_dsl.begin;

import org.openqa.selenium.WebDriver;

class CDslTodoAppNavigator {
    private final WebDriver driver;

    public CDslTodoAppNavigator(final WebDriver driver) {
        this.driver = driver;
    }

    public CDslTodoListsPage toTodoListsPage() {
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
        return new CDslTodoListsPage(driver);
    }
}
