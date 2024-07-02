package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_01_dsl.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Implement using Cucumber

    https://cucumber.io

    https://github.com/cucumber/cucumber-jvm

    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>5.6.0</version>
        <scope>test</scope>
    </dependency>

 */
public class A_DslTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
    }

    @Test
    public void canCreateAList(){


        DslTodoListName listName = new DslTodoListName();

        DslTodoUser user = new DslTodoUser(driver);
        user.createTodoList(listName);

        Assertions.assertEquals(
                listName.getName(),
                new DslTodoListsPage(driver)
                        .getDisplayedListText(listName.getName()));

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
