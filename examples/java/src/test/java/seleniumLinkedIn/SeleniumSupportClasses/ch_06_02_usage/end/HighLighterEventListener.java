package seleniumLinkedIn.SeleniumSupportClasses.ch_06_02_usage.end;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

public class HighLighterEventListener implements WebDriverListener {
    private WebElement lastElement;

    // JavaScript to set style off use element.style.border = 'none';
    // JavaScript to set style on use element.style.border='10px dashed red';
    // e.g.
    // document.getElementById("resend-select").style.border='10px dashed red';
    // JavascriptExecutor uses arguments[0] for the elements passed in as params


    @Override
    public void beforeFindElement( WebDriver driver,By by) {
        if(lastElement!=null){
            try {
                ((JavascriptExecutor)driver).executeScript(
                        "arguments[0].style.border='none'",lastElement
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        lastElement=null;
    }

    @Override
    public void afterFindElement(WebDriver driver,By by, WebElement element) {
        lastElement = element;
        ((JavascriptExecutor)driver).executeScript(
            "arguments[0].style.border='10px dashed red'",element
        );
    }
}
