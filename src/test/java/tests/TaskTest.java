package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DetailsPage;
import pages.ImageInterestsPage;
import pages.RegistrationPage;
import pages.WelcomePage;
import utils.DataSettingsUtils;
import utils.EnumUtils;
import utils.RandomUtils;

import java.awt.*;

public class TaskTest extends BaseTest {
    

    @Test
    public void task2() {
        WelcomePage welcomePage = new WelcomePage(By.className("start__link"), "Welcome Page");
        welcomePage.transitionToRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(By.className("login-form__terms-conditions"), "Registration Page");
        registrationPage.hidingHelpFormAndWaitForFormIsHidden();
        Assert.assertFalse(registrationPage.getClosingHelpButton().state().isDisplayed(), "Help form is displayed");
    }

    @Test
    public void task3() {
        WelcomePage welcomePage = new WelcomePage(By.className("start__link"), "Welcome Page");
        welcomePage.transitionToRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(By.className("login-form__terms-conditions"), "Registration Page");
        registrationPage.closingCookieForm();
        Assert.assertFalse(registrationPage.getCookiesForm().state().isDisplayed(), "Cookies is displayed");
    }

    @Test
    public void task4() {
        WelcomePage welcomePage = new WelcomePage(By.className("start__link"), "Welcome Page");
        welcomePage.transitionToRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(By.className("login-form__terms-conditions"), "Registration Page");
        Assert.assertEquals(registrationPage.gettingTimerValue(), DataSettingsUtils.getElement("nullTimer"), "Time is not equal");
    }
}
