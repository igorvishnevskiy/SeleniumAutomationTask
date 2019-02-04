package tests.gmail;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */

import org.openqa.selenium.support.PageFactory;
import pages.gmail.InboxPage;
import pages.gmail.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.TestBase;


public class GMailLoginTest extends TestBase {


    @AfterMethod
    public void quitDriver() {

        this.driver.quit();

    }


    @Test(description = "Testing login to GMail using Firefox browser.")
    public void testGmailLoginInFirefox() {

        this.setDriver("firefox");

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        InboxPage inboxPage = PageFactory.initElements(driver, InboxPage.class);

        signInPage.launchGMail();

        signInPage.signInValidLogin();

        Assert.assertTrue(inboxPage.isProfileIconDisplayed());

    }


    @Test(description = "Testing login to GMail using Chrome browser.")
     public void testGmailLoginInChrome() {

        this.setDriver("chrome");

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        InboxPage inboxPage = PageFactory.initElements(driver, InboxPage.class);

        signInPage.launchGMail();

        signInPage.signInValidLogin();

        Assert.assertTrue(inboxPage.isProfileIconDisplayed());

    }


    @Test(description = "Testing negative scenario when user provides unregistered " +
                        "email when logging in to GMail using Firefox browser.")
    public void testGmailLoginWithInvalidEmailInFirefox() {

        this.setDriver("firefox");

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.launchGMail();

        signInPage.enterWrongEmailAndClickNext();

        Assert.assertTrue(signInPage.isGoogleEmailErrorExists());

    }


    @Test(description = "Testing negative scenario when user provides unregistered " +
                        "email when logging in to GMail using Chrome browser.")
    public void testGmailLoginWithInvalidEmailInChrome() {

        this.setDriver("chrome");

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.launchGMail();

        signInPage.enterWrongEmailAndClickNext();

        Assert.assertTrue(signInPage.isGoogleEmailErrorExists());

    }


    @Test(description = "Testing negative scenario when user provides wrong " +
            "password when logging in to GMail using Firefox browser.")
    public void testGmailLoginWithInvalidPasswordInFirefox() {

        this.setDriver("firefox");

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.launchGMail();

        signInPage.signInInvalidPassword();

        Assert.assertTrue(signInPage.isWrongPasswordErrorExists());

    }


    @Test(description = "Testing negative scenario when user provides wrong " +
            "password when logging in to GMail using Chrome browser.")
    public void testGmailLoginWithInvalidPasswordInChrome() {

        this.setDriver("chrome");

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.launchGMail();

        signInPage.signInInvalidPassword();

        Assert.assertTrue(signInPage.isWrongPasswordErrorExists());

    }

}

