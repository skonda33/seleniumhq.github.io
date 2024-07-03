package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_04_driver_Abstractions.begin;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class JupiterTemplateAbstractionsTest {

    @RegisterExtension
    static SeleniumExtension seleniumExtension = new SeleniumExtension();

    //https://bonigarcia.github.io/selenium-jupiter/#configuration
    //{"browsers": [[{"type":"chrome"}],[{"type":"firefox"}]]}
    static String property = 
       System.setProperty("sel.jup.browser.template.json.content",
            "{\"browsers\": [[{\"type\":\"chrome\"}],[{\"type\":\"firefox\"}]]}");


    @TestTemplate
    public void testit(WebDriver driver){
        driver.get("https://eviltester.github.io/simpletodolist/todo.html#/&eviltester");
        driver.findElement(By.cssSelector("input.new-todo")).
                sendKeys("todo 1" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo"))
                .sendKeys("todo 2" + Keys.ENTER);
        driver.findElement(By.cssSelector("input.new-todo"))
                .sendKeys("todo 3" + Keys.ENTER);
        By todoItemCheckbox = By.cssSelector("ul.todo-list input.toggle");
        List<WebElement> checkboxes = driver.findElements(todoItemCheckbox);
        Assertions.assertEquals(3, checkboxes.size());
        driver.close();
    }




}
