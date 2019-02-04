package pages.gmail;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;


import java.util.List;
import java.util.logging.Logger;


public class SignInPage {

    public final Logger LOGGER = Logger.getLogger(SignInPage.class.getName());

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    static final String GMAIL_URL = "https://www.gmail.com";
    static final String VALID_GMAIL_USER_ID = "itgeosrt@gmail.com";
    static final String VALID_GMAIL_PASSOWRD = "test!@#ig";
    static final String WRONG_GMAIL_USER_ID = "idontexistajhvdjadgcadh873532@gmail.com";
    static final String WRONG_GMAIL_PASSWORD = "neverexistedm3";


    @FindBy(how= How.XPATH, using="//input[@type='email']") static WebElement emailInputBox;
    @FindBy(how= How.XPATH, using="//input[@type='password']") static WebElement passwordInputBox;
    @FindBy(how = How.ID, using="identifierNext") static WebElement emailScreenNextButton;
    @FindBy(how = How.ID, using="passwordNext") static WebElement passwordScreenNextButton;
    @FindAll(@FindBy(how= How.XPATH, using=".//*")) static List<WebElement> allElements;



    public void launchGMail() {

        /** Launch GMail Website */
        driver.get(GMAIL_URL);
        driver.manage().window().maximize();

    }


    public boolean isGoogleEmailErrorExists() {

        for (WebElement element : allElements) {
            if (element.getText().equalsIgnoreCase("Couldn't find your Google Account")) {
                return true;
            }
        }
        return false;
    }


    public boolean isWrongPasswordErrorExists() {


        for (WebElement element : allElements) {
            if (element.getText().startsWith("Wrong password")) {
                return true;
            }
        }
        return false;
    }


    public void signInValidLogin() {
        signIn(VALID_GMAIL_USER_ID, VALID_GMAIL_PASSOWRD);
    }



    public void signInInvalidPassword() {
        signIn(VALID_GMAIL_USER_ID, WRONG_GMAIL_PASSWORD);
    }


    public void enterEmailAndClickNext(String userEmail) {

        /** Locate Email Input Box and insert Email Address */
        Utils.waitUntil(emailInputBox);
        emailInputBox.sendKeys(userEmail);

        /** Click Next button */
        Utils.waitUntil(emailScreenNextButton);
        emailScreenNextButton.click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            LOGGER.info("Exception: "+e);
        }

    }

    public void enterWrongEmailAndClickNext() {

        enterEmailAndClickNext(WRONG_GMAIL_USER_ID);
    }


    public void enterPasswordAndClickNext(String password) {

        /** Locate Password Input Box and insert password */
        Utils.waitUntil(passwordInputBox);
        passwordInputBox.sendKeys(password);


        /** Click Next button */
        Utils.waitUntil(passwordScreenNextButton);
        passwordScreenNextButton.click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            LOGGER.info("Exception: "+e);
        }

    }


    public void clickSignInBtn() {

        /** Locate and click on "Sign In" button */
        for (WebElement element : allElements) {
            if (element.getText().equalsIgnoreCase("Sign In")) {
                element.click();
            }
        }

    }


    public void signIn(String userEmail, String password) {

        clickSignInBtn();
        enterEmailAndClickNext(userEmail);
        enterPasswordAndClickNext(password);

    }

}
