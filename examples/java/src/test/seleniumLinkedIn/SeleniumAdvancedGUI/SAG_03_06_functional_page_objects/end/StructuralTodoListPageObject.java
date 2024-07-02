package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_03_06_functional_page_objects.end;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StructuralTodoListPageObject {

    private final WebDriver driver;

    final WebElement inputField;
    private final StructuralTodoListLocators locators;

    public StructuralTodoListPageObject(final WebDriver driver) {
        this.driver = driver;

        locators = new StructuralTodoListLocators();

        inputField =
                driver.findElement(
                        locators.getNewTodoListEntryField());
    }

    public void typeListName(final String listName) {
        inputField.sendKeys(listName);
    }

    public void loseNameFocus() {
        driver.findElement(locators.getPageHeading()).click();
    }

    public void submitListName() {
        inputField.sendKeys(Keys.ENTER);
    }

    public void clickDeleteButtonForListNamed(final String listName) {

        final WebElement todoListEntry =
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                        ExpectedConditions.presenceOfElementLocated(
                                locators.getListNamed(listName)
                        ));

        todoListEntry.findElement(locators.getaDeleteButton()).click();
    }

    public void confirmDeleteAlert() {
        driver.switchTo().alert().accept();
    }

    public int countLists(){
        return driver.findElements(
                locators.getAllListNameItems())
                .size();
    }
}
