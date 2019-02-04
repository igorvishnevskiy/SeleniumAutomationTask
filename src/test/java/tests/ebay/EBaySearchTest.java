package tests.ebay;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */

import org.openqa.selenium.support.PageFactory;
import pages.ebay.HomePage;
import pages.ebay.ProductDetailsPage;
import pages.ebay.SearchResultsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.TestBase;


public class EBaySearchTest extends TestBase {


    @AfterMethod
    public void quitDriver() {

        this.driver.quit();

    }


    @Test(description = "Grab eBay Item price using Firefox browser.")
    public void testEbaySearchFirefox() {

        this.setDriver("firefox");

        String price = getPriceTagSequence();

        this.LOGGER.info("Price from Firefox is: " + price);

    }


    @Test(description = "Grab eBay Item price using Chrome browser.")
         public void testEbaySearchChrome() {

        this.setDriver("chrome");

        String price = getPriceTagSequence();

        this.LOGGER.info("Price from Chrome is: " + price);

    }


    /** Sequence of steps to navigate through pages to
     * product details page and extract the product price. */
    private String getPriceTagSequence() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.navigateEbay();
        homePage.searchForItem();

        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        searchResultsPage.clickOnFirstItemInSearchResults();

        ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);
        return productDetailsPage.grabPriceTag();

    }





}

