package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DetailsPage extends Form {

    private final ITextBox thirdPageIndicator = AqualityServices.getElementFactory().getTextBox(By.xpath("//div[@class='page-indicator' and contains(., '3 / 4')]"), "Third Page Indicator");
    public DetailsPage(By locator, String name) {
        super(locator, name);
    }

    public String getThirdPageIndicatorText() {
        return thirdPageIndicator.getText();
    }
}
