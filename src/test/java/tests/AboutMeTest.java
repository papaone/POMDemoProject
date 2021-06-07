package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utilities.Browsers;
import utilities.WebDriverFactory;

public class AboutMeTest extends BaseTest {
    WebDriver webDriver = WebDriverFactory.createDriver(Browsers.CHROME);
    MainPage mainPage = new MainPage(webDriver);

    @Test
    public void firstTest() {
        mainPage.goToPage();
    }
}
