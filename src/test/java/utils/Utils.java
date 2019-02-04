package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by igorvishnevskiy on 2/4/19.
 */

public class Utils {

    public static void waitUntil(WebElement element) {
        ExpectedConditions.visibilityOf(element);
    }

    public static void waitForElementToLoadByLocator(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
