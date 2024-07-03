package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_02_code_based_dsl.end;

import org.openqa.selenium.WebDriver;

class CDslTodoUser {
    private final WebDriver driver;
    private final CDslTodoAppNavigator navigate;
    private CDslTodoListName listName;

    public CDslTodoUser(final WebDriver driver) {
        this.driver = driver;
        navigate = new CDslTodoAppNavigator(driver);
    }

    public CDslTodoUser createsTodoList(final CDslTodoListName listName) {
        this.listName=listName;
        navigate.toTodoListsPage().
            enterTodoListName(listName.getName());
        return this;
    }

    public CDslTodoUser thinksOfATodoListName() {
        listName = new CDslTodoListName();
        return this;
    }

    public CDslTodoUser and() {
        return this;
    }

    public CDslTodoUser createsTodoList() {
        if(listName==null){
            thinksOfATodoListName();
        }
        createsTodoList(this.listName);
        return this;
    }

    public CDslTodoUser then() {
        return this;
    }

    public CDslTodoUser usesTodoList() {
        navigate.toTodoListsPage().
                clickOnList(listName.getName());
        return this;
    }

    public CDslTodoUser addsTodo(String my_todo) {
        new CDslTodoListPage(driver).enterTodo(my_todo);
        return this;
    }
}
