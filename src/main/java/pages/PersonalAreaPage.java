package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalAreaPage extends BasePage {


    private final By

            firstNameField = By.name("fname"),
            lastNameField = By.name("lname"),
            firstNameLatinField = By.name("fname_latin"),
            lastNameLatinField = By.name("lname_latin"),
            blogNameField = By.name("blog_name"),
            dateOfBirthField = By.name("date_of_birth"),
            countryDropDown = By.xpath("//input[@name='country']/following-sibling::div"),
            cityDropDown = By.xpath("//div/span[contains(text(),'Город')] "),
            cityDropDownValue = By.xpath("//input[@name='city']/following-sibling::div"),
            englishLevelDropDown = By.xpath("//input[@name='english_level']/following-sibling::div"),
            addContactButton = By.xpath("//button[contains(text(), 'Добавить')]"),
            removeContactButton = By.xpath("//button[contains(text(), 'Удалить')]"),
            firstContactField = By.id("id_contact-0-value"),
            firstContactMethod = By.xpath("//input[@name='contact-0-service']/following-sibling::div"),
            secondContactField = By.id("id_contact-1-value"),
            secondContactMethod = By.xpath("//input[@name='contact-1-service']/following-sibling::div"),
            genderDropDown = By.id(""),
            companyInputField = By.name("company"),
            workInputField = By.name("work"),

    saveAndContinueButton = By.xpath("//button[contains(text(),'Сохранить и продолжить')]");

    public PersonalAreaPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public String getFirstName() {
        String firstNameValue = driver.findElement(firstNameField).getAttribute("value");//.getText();
        return firstNameValue;
    }

    public void inputFirstNameLatin(String firstNameLatin) {
        driver.findElement(firstNameLatinField).clear();
        driver.findElement(firstNameLatinField).sendKeys(firstNameLatin);
    }

    public String getFirstNameLatin() {
        String firstNameLatinValue = driver.findElement(firstNameLatinField).getAttribute("value");
        return firstNameLatinValue;
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public String getLastName() {
        String lastNameValue = driver.findElement(lastNameLatinField).getAttribute("value");
        return lastNameValue;
    }

    public void inputLastNameLatin(String lastNameLatin) {
        driver.findElement(lastNameLatinField).clear();
        driver.findElement(lastNameLatinField).sendKeys(lastNameLatin);
    }

    public String getLastNameLatin() {
        String lastNameLatinValue = driver.findElement(lastNameLatinField).getAttribute("value");
        return lastNameLatinValue;
    }

    public void inputBlogName(String blogName) {
        driver.findElement(blogNameField).clear();
        driver.findElement(blogNameField).sendKeys(blogName);
    }

    public String getBlogNameValue() {
        String blogNameValue = driver.findElement(blogNameField).getAttribute("value");
        return blogNameValue;
    }

    public void inputDateOfBirth(String dateBirth) {
        driver.findElement(dateOfBirthField).clear();
        driver.findElement(dateOfBirthField).sendKeys(dateBirth);
    }

    public String getDateOfBirthValue() {
        String dateOfBirthValue = driver.findElement(dateOfBirthField).getAttribute("value");
        return dateOfBirthValue;
    }

    public void selectCountryValue(String country) {

        driver.findElement(countryDropDown).click();
        driver.findElement(By.xpath("//div/button[@title='" + country + "']")).click();
    }

    public String getCountryValue() {
        String countryValue = driver.findElement(countryDropDown).getText();
        return countryValue;
    }

    public void selectCityValue(String city) {
        waitForElementToBeClickable(cityDropDown);
        driver.findElement(cityDropDown).click();
        waitForElementToBeClickable(By.xpath("//div/button[contains(text(),'" + city + "')]"));
        driver.findElement(By.xpath("//div/button[contains(text(),'" + city + "')]")).click();
    }

    public String getCityValue() {
        String cityValue = driver.findElement(cityDropDownValue).getText();
        return cityValue;
    }

    public void selectEnglishLevelValue(String englishLevel) {
        driver.findElement(englishLevelDropDown).click();
        driver.findElement(By.xpath("//div/button[@title='" + englishLevel + "']")).click();
    }

    public String getEnglishLevelValue() {
        String englishLevelValue = driver.findElement(englishLevelDropDown).getText();
        return englishLevelValue;
    }

    public void inputFirstContact(String contact, String method) {
        driver.findElement(firstContactMethod).click();
        driver.findElement(By.xpath("//div[not(contains(@class, 'js-custom-select-options-container hide'))]/div/button[@title='" + method + "']")).click();
        driver.findElement(firstContactField).clear();
        driver.findElement(firstContactField).sendKeys(contact);
    }

    public String getFirstContactValue() {
        String firstContactValue = driver.findElement(firstContactField).getAttribute("value");
        return firstContactValue;
    }

    public void inputSecondContact(String contact, String method) {
        driver.findElement(addContactButton).click();
        waitForElementToAppear(secondContactField);
        driver.findElement(secondContactMethod).click();
        driver.findElement(By.xpath("//div[not(contains(@class, 'js-custom-select-options-container hide'))]/div/button[@title='" + method + "']")).click();
        driver.findElement(secondContactField).clear();
        driver.findElement(secondContactField).sendKeys(contact);
    }

    public String getSecondContactValue() {
        String secondContactValue = driver.findElement(secondContactField).getAttribute("value");
        return secondContactValue;
    }

    public void removePreviouslyAddedContact() {
        List<WebElement> removeButtons = getClickableElements(removeContactButton);
        for (WebElement button : removeButtons
        ) {
            button.click();
        }
    }

    public void inputCompanyValue(String company) {
        driver.findElement(companyInputField).clear();
        driver.findElement(companyInputField).sendKeys(company);
    }

    public String getCompanyValue() {
        String companyValue = driver.findElement(companyInputField).getAttribute("value");
        return companyValue;
    }

    public void inputWorkValue(String work) {
        driver.findElement(workInputField).clear();
        driver.findElement(workInputField).sendKeys(work);
    }

    public String getWorkValue() {
        String workValue = driver.findElement(workInputField).getAttribute("value");
        return workValue;
    }

    public void clickSaveAndContinueButton() {
        driver.findElement(saveAndContinueButton).click();
    }
}
