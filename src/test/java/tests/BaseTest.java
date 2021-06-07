package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class BaseTest {

    WebDriver driver;

    @After
    public void closeDriver() {
        driver = WebDriverFactory.getDriver();
        if (driver != null) {
            driver.close();
        }
    }
}
