package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_02_infrastructure_abstractions.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfrastructureAbstractionsTest {

    private WebDriver driver;

    InfrastuctureEnv env = new InfrastuctureEnv();

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        //driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void adminLogin(){


        driver.get(env.getAdminLoginUrl());

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
