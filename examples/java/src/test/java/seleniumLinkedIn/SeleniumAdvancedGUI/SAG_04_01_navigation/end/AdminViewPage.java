package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_04_01_navigation.end;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminViewPage {
    private final WebDriver driver;

    public AdminViewPage(final WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().contentEquals("Todo Admin View")){
            throw new RuntimeException("Not on Admin Page");
        }
    }

    public int countLists() {
        return driver.findElements(
                By.cssSelector("ul#reportlist li")).size();
    }
}
