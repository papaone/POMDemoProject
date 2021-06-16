package tests;

import elements.MainNavigationHeader;
import elements.PersonalAreaHeader;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.PersonalAreaPage;

public class AboutMeTest extends BaseTest {


    @Test
    public void firstTest() {
        String firstName = "Test";
        String firstNameLatin = "Test";
        String lastName = "Test";
        String lastNameLatin = "Test";
        String blogName = "Test";
        String dateOfBirth = "11.06.1994";
        String country = "Россия";
        String city = "Москва";
        String englishLevel = "Начальный уровень (Beginner)";
        String firstContact = "Test";
        String secondContact = "Test";
        String work = "Test";
        String company = "Test";

        MainPage mainPage = new MainPage(driver);
        MainNavigationHeader mainNavigationHeader = new MainNavigationHeader(driver);
        PersonalAreaHeader personalAreaHeader = new PersonalAreaHeader(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);

        mainPage.goToMainPage();
        mainPage.clickLoginButton();
        mainPage.enterEmailValue(getUser().getEmail());
        mainPage.enterPasswordValue(getUser().getPassword());
        mainPage.clickEnterButton();
        mainNavigationHeader.openPersonalArea();
        personalAreaHeader.clickAboutYouButton();
        personalAreaPage.inputFirstName(firstName);
        personalAreaPage.inputFirstNameLatin(firstNameLatin);
        personalAreaPage.inputLastName(lastName);
        personalAreaPage.inputLastNameLatin(lastNameLatin);
        personalAreaPage.inputBlogName(blogName);
        personalAreaPage.inputDateOfBirth(dateOfBirth);
        personalAreaPage.selectCountryValue(country);
        personalAreaPage.selectCityValue(city);
        personalAreaPage.selectEnglishLevelValue(englishLevel);
        personalAreaPage.inputFirstContact(firstContact, "Тelegram");
        personalAreaPage.inputSecondContact(secondContact, "OK");
        personalAreaPage.inputWorkValue(work);
        personalAreaPage.inputCompanyValue(company);
        personalAreaPage.clickSaveAndContinueButton();
        resetDriverSession();
        mainPage.goToMainPage();
        mainPage.clickLoginButton();
        mainPage.enterEmailValue(getUser().getEmail());
        mainPage.enterPasswordValue(getUser().getPassword());
        mainPage.clickEnterButton();
        mainNavigationHeader.openPersonalArea();
        personalAreaHeader.clickAboutYouButton();
        Assert.assertEquals(firstName, personalAreaPage.getFirstName());
        Assert.assertEquals(lastName, personalAreaPage.getLastName());
        Assert.assertEquals(firstNameLatin, personalAreaPage.getFirstNameLatin());
        Assert.assertEquals(lastNameLatin, personalAreaPage.getLastNameLatin());
        Assert.assertEquals(blogName, personalAreaPage.getBlogNameValue());
        Assert.assertEquals(dateOfBirth, personalAreaPage.getDateOfBirthValue());
        Assert.assertEquals(country, personalAreaPage.getCountryValue());
        Assert.assertEquals(city, personalAreaPage.getCityValue());
        Assert.assertEquals(englishLevel, personalAreaPage.getEnglishLevelValue());
        Assert.assertEquals(firstContact, personalAreaPage.getFirstContactValue());
        Assert.assertEquals(secondContact, personalAreaPage.getSecondContactValue());
        Assert.assertEquals(work, personalAreaPage.getWorkValue());
        Assert.assertEquals(company, personalAreaPage.getCompanyValue());
        personalAreaPage.removePreviouslyAddedContact();
    }
}
