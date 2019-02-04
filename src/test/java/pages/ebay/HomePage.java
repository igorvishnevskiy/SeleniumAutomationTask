package pages.ebay;


/**
 * Created by igorvishnevskiy on 2/2/19.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;


public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    static final String EBAY_URL = "https://www.ebay.com";

    @FindBy(how = How.NAME, using = "_nkw") static WebElement searchBox;
    @FindBy(how = How.ID, using = "gh-btn") static WebElement searchBtn;


    /** Launch Ebay Website */
    public void navigateEbay() {

        driver.get(EBAY_URL);
        driver.manage().window().maximize();

    }


    /** Search for "Electric Guitar" on Ebay Website */
    public void searchForItem() {

        String searchString = "Electric Guitar";
        Utils.waitUntil(searchBox);
        searchBox.sendKeys(searchString);

        Utils.waitUntil(searchBtn);
        searchBtn.click();

    }


}
