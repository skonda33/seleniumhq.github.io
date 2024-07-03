package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_02_dos_donts.begin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DosDontsTest {

    WebDriver driver;

    @BeforeEach
    public void setupData(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }

    @Test
    public void doUseFluentNaming(){
        Navigator navigate = new Navigator(driver);

        navigate.to().loginPage();

        Assertions.assertTrue(
            driver.getCurrentUrl().
                endsWith("adminlogin.html"));
    }

    // inner classes can help organise code
    // and we can refactor them to be public later
    private class Navigator {
        private final WebDriver driver;
        private final String root=
                "https://eviltester.github.io/simpletodolist/";

        public Navigator(final WebDriver driver) {
            this.driver = driver;
        }

        public Navigator to(){
            return this;
        }

        public void loginPage(){
            driver.get(root + "adminlogin.html");
        }
    }

    @Test
    public void doNotAssertInAbstractions(){

        final LoginProcess process = new LoginProcess(driver);
        process.login("Admin", "AdminPass");

        Assertions.assertTrue(driver.getCurrentUrl().endsWith("adminview.html"));

        // when try to test fail to login the abstraction fails my test
//        process.login("nouser", "nopassword");
//        Assertions.assertEquals("Login Details Incorrect",
//            driver.findElement(
//                    By.cssSelector(".loginmessage")).getText());
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }


}
