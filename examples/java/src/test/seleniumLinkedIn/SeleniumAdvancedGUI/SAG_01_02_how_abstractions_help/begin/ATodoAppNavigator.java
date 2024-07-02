package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_01_02_how_abstractions_help.begin;

import org.openqa.selenium.WebDriver;

class ATodoAppNavigator {
    private final WebDriver driver;

    public ATodoAppNavigator(final WebDriver driver) {
        this.driver = driver;
    }

    public ATodoListsPage todoListsPage() {
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
        return new ATodoListsPage(driver);
    }

    public ATodoAppNavigator to(){
        return this;
    }

}
