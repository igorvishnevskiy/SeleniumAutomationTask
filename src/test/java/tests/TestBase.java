package tests;

/**
 * Created by igorvishnevskiy on 2/2/19.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.logging.Logger;


public class TestBase {

    public WebDriver driver;
    public final Logger LOGGER = Logger.getLogger(TestBase.class.getName());


    /** Open privided URL in the browser and maximize browser window */
    public void get(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


    /** Will set WebDriver to the one requested per Factory Design Pattern */
    public void setDriver(String browserType) {

        if(browserType.equalsIgnoreCase("firefox")){
            driver = this.getFirefoxDriver();

        } else if(browserType.equalsIgnoreCase("chrome")){
            driver = this.getChromeDriver();
            
        } else {
            driver = null;
        }
    }


    /** Initializes and returns FirefoxDriver */
    private WebDriver getFirefoxDriver() {
        String path = "src/test/java/drivers/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);
        return new FirefoxDriver();
    }

    /** Initializes and returns ChromeDriver */
    private WebDriver getChromeDriver() {
        String path = "src/test/java/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        return new ChromeDriver();
    }


}
