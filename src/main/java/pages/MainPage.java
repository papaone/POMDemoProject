package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    String url = "https://www.edureka.co/community/52217/how-create-base-class-in-selenium-and-use-it-with-test-scripts";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage()
    {
        driver.get(url);
    }
}
