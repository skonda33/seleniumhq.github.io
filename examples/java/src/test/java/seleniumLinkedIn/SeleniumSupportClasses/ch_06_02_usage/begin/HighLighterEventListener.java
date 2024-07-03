package seleniumLinkedIn.SeleniumSupportClasses.ch_06_02_usage.begin;

//import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

public class HighLighterEventListener implements WebDriverListener {

    // JavaScript to set style off use element.style.border = 'none';
    // JavaScript to set style on use element.style.border='10px dashed red';
    // e.g.
    // document.getElementById("resend-select").style.border='10px dashed red';
    // JavascriptExecutor uses arguments[0] for the elements passed in as params

    // TODO: create a beforeFindBy that sets last element style to none
    // TODO: create an afterFindBy that sets last element to current and style to 10px dashed red

}
