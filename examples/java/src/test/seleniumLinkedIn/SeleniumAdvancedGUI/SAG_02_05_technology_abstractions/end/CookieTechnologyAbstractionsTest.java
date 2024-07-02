package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_05_technology_abstractions.end;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieTechnologyAbstractionsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void checkCookieCreated(){

        Cookie cookie = driver.manage().getCookieNamed("loggedin");

        // cookie should not exist
        Assertions.assertNull(cookie);

        final WebElement loginlink = driver.findElement(By.id("navadminlogin"));
        loginlink.click();

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("AdminPass");
        driver.findElement(By.id("login")).click();

        cookie = driver.manage().getCookieNamed("loggedin");

        // cookie should now exist
        Assertions.assertNotNull(cookie);
    }

    @Test
    public void useInBuiltTechnologyAbstractionToBypassLoginFlow(){

        // inject the loggedin cookie to bypass login flow
        new UserState().forceUserLoggedIn();

        driver.get("https://eviltester.github.io/simpletodolist/adminview.html");

        // if we are not logged in then we would be redirected
        Assertions.assertEquals("Todo Admin View", driver.getTitle());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    private class UserState {
        public void forceUserLoggedIn() {
            driver.manage().addCookie(new Cookie("loggedin", "Admin", "/"));
        }
    }
}
