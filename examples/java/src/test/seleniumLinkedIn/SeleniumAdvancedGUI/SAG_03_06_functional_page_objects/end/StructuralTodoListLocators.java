package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_06_functional_page_objects.end;

import org.openqa.selenium.By;

public class StructuralTodoListLocators {

    private final By newTodoListEntryField = By.cssSelector(".new-todo-list");
    private final By pageHeading = By.tagName("h1");
    private final By aDeleteButton = By.cssSelector("button.destroy");
    private final By allListNameItems = By.cssSelector("ul.todo-list-list li");

    public By getNewTodoListEntryField() {
        return newTodoListEntryField;
    }

    public By getPageHeading() {
        return pageHeading;
    }

    public By getaDeleteButton() {
        return aDeleteButton;
    }

    public By getAllListNameItems() {
        return allListNameItems;
    }

    public By getListNamed(final String listName) {
        return By.cssSelector(
                "li[data-id='" + listName + "']");
    }
}
