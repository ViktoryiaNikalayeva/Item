package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class RegistrationPage extends Form {

    private final ITextBox passwordInput = AqualityServices.getElementFactory().getTextBox(By.cssSelector("[placeholder='Choose Password']"), "Password");
    private final ITextBox emailInput = AqualityServices.getElementFactory().getTextBox(By.cssSelector("[placeholder='Your email']"), "Email");
    private final ITextBox domainDropDown = AqualityServices.getElementFactory().getTextBox(By.cssSelector("[placeholder='Domain']"), "Domain");
    private final ICheckBox termsAgree = AqualityServices.getElementFactory().getCheckBox(By.className("checkbox__box"), "Terms Agree checkbox");
    private final IButton dropDownButton = AqualityServices.getElementFactory().getButton(By.className("dropdown__field"), "Dropdown button");
    private final IButton nextButton = AqualityServices.getElementFactory().getButton(By.className("button--secondary"), "Next button");
    private final IButton closingHelpButton = AqualityServices.getElementFactory().getButton(By.className("highlight"), "Closing help button");
    private final IButton notReallyNoButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--transparent']"), "Not really no button");
    private final ILabel cookiesForm = AqualityServices.getElementFactory().getLabel(By.className("cookies"), "Cookies Form");
    private final ITextBox timer = AqualityServices.getElementFactory().getTextBox(By.xpath("//div[@class='timer timer--white timer--center']"), "Timer");

    public RegistrationPage(By locator, String name) {
        super(locator, name);
    }

    public void registrationFormActions(String email, String password, String domain, String endDomain) {
        passwordInput.clearAndType(email);
        emailInput.clearAndType(password);
        domainDropDown.clearAndType(domain);
        dropDownButton.click();
        getEndOfDomain(endDomain);
        termsAgree.click();
        nextButton.click();
    }

    public void getEndOfDomain(String randomString) {
         AqualityServices.getElementFactory().getButton
                 (By.xpath("//div[@class='dropdown__list-item' and contains(., '"
                         + randomString + "')]"), "End of domain button").click();
        }


    public void hidingHelpFormAndWaitForFormIsHidden() {
        closingHelpButton.click();
        closingHelpButton.state().waitForNotDisplayed();
    }
    public IButton getClosingHelpButton() {
        return closingHelpButton;
    }
    public ILabel getCookiesForm() {
        return cookiesForm;
    }

    public void closingCookieForm() {
        notReallyNoButton.click();
    }

    public String gettingTimerValue() {
        return timer.getText();
    }
}
