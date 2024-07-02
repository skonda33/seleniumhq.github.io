package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_06_01_trade_offs.begin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseGUITest {

    public WebDriver driver;
    public final String MAINURL =
            "https://eviltester.github.io/simpletodolist/todolists.html";

    public void startBrowser(){
        driver = new ChromeDriver();
        driver.get(MAINURL);
    }

    public void closeBrowser(){
        driver.close();
    }
}
