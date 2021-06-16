package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pojo_models.users.User;
import utilities.Browsers;
import utilities.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    private final Logger logger = LogManager.getLogger(BaseTest.class);

    @Before
    public void start() {
        driverSetUp();
        logger.info("Driver started");
    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.close();
            logger.info("Driver stop");
        }
    }

    public void resetDriverSession() {
        driver.manage().deleteAllCookies();
    }

    public User getUser() {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(new File("src/main/java/test_data/users/users.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("File not found");
        }
        return user;
    }


    public void driverSetUp() {
        driver = WebDriverFactory.create(Browsers.CHROME);
       if (driver == null) {
            logger.info("Driver not started");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
