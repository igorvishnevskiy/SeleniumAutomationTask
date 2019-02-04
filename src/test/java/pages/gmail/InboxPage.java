package pages.gmail;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;


public class InboxPage {

    WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    static final String profileIconXPath = "/html/body/div[7]/div[3]/div/div[1]/div[4]/header/div[2]/div[3]/div/div[2]/div/a/span";
    @FindBy(how= How.XPATH, using=profileIconXPath) static WebElement userProfileIcon;


    /** Returns boolean, True is profileIconXPath on the page, False is doesn't exist */
    public static boolean isProfileIconDisplayed() {

        Utils.waitUntil(userProfileIcon);
        return userProfileIcon.isDisplayed();

    }

}
