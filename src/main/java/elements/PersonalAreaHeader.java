package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaHeader extends BaseElement{

    private final By
        aboutYouButton = By.xpath("//a[contains(@title,'О себе')]");

    public PersonalAreaHeader(WebDriver driver) {
        super(driver);
    }

    public void clickAboutYouButton()
    {
        driver.findElement(aboutYouButton).click();
    }
}
