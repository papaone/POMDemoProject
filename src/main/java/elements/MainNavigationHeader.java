package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainNavigationHeader extends BaseElement{

    private final By
    userLogoDropDown = By.xpath("//div[@class='header2-menu']"),
    personalAreaOption = By.xpath("//a[contains(@title,'Личный кабинет')]");

    public MainNavigationHeader(WebDriver driver) {
        super(driver);
    }

    public void openPersonalArea() {
        waitForElementToAppear(userLogoDropDown);
        driver.findElement(userLogoDropDown).click();
        waitForElementToAppear(personalAreaOption);
        driver.findElement(personalAreaOption).click();
    }
}
