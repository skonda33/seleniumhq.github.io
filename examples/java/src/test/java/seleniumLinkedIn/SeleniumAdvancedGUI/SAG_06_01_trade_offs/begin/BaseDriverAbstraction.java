package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_01_trade_offs.begin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriverAbstraction {
    public WebDriver open() {
        switch (System.getProperty("driverabstractions.browser", "")){
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}