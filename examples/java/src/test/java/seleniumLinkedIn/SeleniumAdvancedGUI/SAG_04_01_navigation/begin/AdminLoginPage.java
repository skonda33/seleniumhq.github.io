package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_01_navigation.begin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

    private final WebDriver driver;

    public AdminLoginPage(final WebDriver driver) {
        this.driver = driver;
    }

    public AdminViewPage loginAs(final String username, final String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        return new AdminViewPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("h2.loginmessage")).getText();
    }

    public void failToLoginAs(final String username, final String password) {
        loginAs(username, password);
    }
}
