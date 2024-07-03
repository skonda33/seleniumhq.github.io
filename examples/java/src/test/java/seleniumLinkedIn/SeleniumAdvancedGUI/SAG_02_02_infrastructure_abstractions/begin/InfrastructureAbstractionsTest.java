package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_02_infrastructure_abstractions.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfrastructureAbstractionsTest {

    private WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void adminLogin(){

        //String env = "https://testpages.herokuapp.com/styled/cookies/adminlogin.html";
        String env = "https://eviltester.github.io/simpletodolist/adminlogin.html";
        driver.get(env);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("AdminPass");
        driver.findElement(By.id("login")).click();

        Assertions.assertEquals(
                "Admin View",
                driver.findElement(By.tagName("h1")).getText());

    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

}
