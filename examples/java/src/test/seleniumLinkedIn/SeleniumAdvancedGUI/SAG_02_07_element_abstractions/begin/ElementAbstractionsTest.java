package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_07_element_abstractions.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ElementAbstractionsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){

        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");

        driver.findElement(By.cssSelector("input.new-todo")).
            sendKeys("todo 1" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo")).
            sendKeys("todo 2" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo")).
            sendKeys("todo 3" + Keys.ENTER);
    }

    @Test
    public void elementAbstraction(){

        By todoItemCheckbox = By.cssSelector("ul.todo-list input.toggle");

        List<WebElement> checkboxes = driver.findElements(todoItemCheckbox);
        Assertions.assertEquals(3, checkboxes.size());

        // toggle the 2nd (middle) todo
        WebElement checkbox2 = checkboxes.get(1);
        checkbox2.click();

        // assert that todos we created are in state we expect
        Assertions.assertEquals(false, checkboxes.get(0).isSelected());
        Assertions.assertEquals(true, checkboxes.get(1).isSelected());
        Assertions.assertEquals(false, checkboxes.get(2).isSelected());

        // A Checkbox Element Abstraction would have semantics
        // e.g. isChecked(), toggle(), check(), uncheck()
        // ideally create an element abstraction for checkbox

        // isChecked would return true or false, but seems semantically
        // more accurate than isSelected

        // toggle would switch the state and act like a click

        // check() would make sure it was checked after calling
        // even if already checked

        // uncheck() would make sure it was not checked after calling
        // even if already checked

        // it might be useful to access the WebElement
    }


    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class Checkbox implements WrapsElement{
        private final WebElement element;

        public Checkbox(final WebElement webElement) {
            this.element = webElement;
        }

        public boolean isChecked() {
            return element.isSelected();
        }

        public void toggle() {
            element.click();
        }

        public void check() {
            if(isChecked()){
                return;
            }
            toggle();
        }

        public void uncheck() {
            if(!isChecked()){
                return;
            }
            toggle();
        }

        @Override
        public WebElement getWrappedElement() {
            return element;
        }
    }
}
