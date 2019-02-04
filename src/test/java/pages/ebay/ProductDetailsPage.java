package pages.ebay;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;


public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "prcIsum") static WebElement priceTag;

    /** Extract and return as String the price tag of the item on this product details page */
    public String grabPriceTag() {

        Utils.waitUntil(priceTag);
        return priceTag.getText();

    }

}
