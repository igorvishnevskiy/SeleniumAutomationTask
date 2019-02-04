package pages.ebay;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;


public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(how = How.ID, using = "srp-river-results-listing1") static WebElement firstSearchItem;


    /** Locate and click on the title of the top search result */
    public void clickOnFirstItemInSearchResults() {

        Utils.waitUntil(firstSearchItem);
        WebElement firstSearchItemLink = firstSearchItem.findElements(By.className("s-item__title")).get(0);

        firstSearchItemLink.click();

    }

}
