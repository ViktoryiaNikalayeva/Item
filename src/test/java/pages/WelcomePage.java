package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class WelcomePage extends Form {

    private final ILink startLink = AqualityServices.getElementFactory().getLink(By.className("start__link"), "Here link");

    public WelcomePage(By locator, String name) {
        super(locator, name);
    }

    public void transitionToRegistrationPage() {
        startLink.click();
    }

}
