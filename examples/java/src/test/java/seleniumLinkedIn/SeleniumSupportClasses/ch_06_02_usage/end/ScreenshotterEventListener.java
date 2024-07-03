package seleniumLinkedIn.SeleniumSupportClasses.ch_06_02_usage.end;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;
import java.io.IOException;

public class ScreenshotterEventListener implements WebDriverListener {

    @Override
    public void afterFindElement( WebDriver driver,By by, WebElement element) {
        File screenshot = ((TakesScreenshot) driver).
                                getScreenshotAs(OutputType.FILE);

        File screenshotFolder = new File(System.getProperty("user.dir"),
                                "screenshots");

        screenshotFolder.mkdirs();

        try {
            FileUtils.copyFile(screenshot, new File(screenshotFolder,
                    System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
