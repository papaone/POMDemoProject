package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    String url = "https://otus.ru/";

    private final By
            loginButton = By.xpath("//button[contains(text(),'Вход')]"),
            emailField = By.xpath("//input[contains(@class,'js-email-input')]"),
            passwordField = By.xpath("//input[contains(@class,'js-psw-input')]"),
            submitButton = By.xpath("//div//button[contains(text(),'Войти')]");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToMainPage() {
        driver.get(url);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterEmailValue(String login) {
        waitForElementToAppear(emailField);
        driver.findElement(emailField).sendKeys(login);
    }

    public void enterPasswordValue(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickEnterButton() {
        driver.findElement(submitButton).click();
    }
}
