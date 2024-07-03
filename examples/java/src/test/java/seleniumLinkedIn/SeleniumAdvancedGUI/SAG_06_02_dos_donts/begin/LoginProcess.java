package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_02_dos_donts.begin;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginProcess {
    private final WebDriver driver;

    public LoginProcess(final WebDriver driver) {
        String env = "https://eviltester.github.io/simpletodolist/adminlogin.html";
        this.driver = driver;
        driver.get(env);
    }

    public void login(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("adminview.html"));
    }
}
