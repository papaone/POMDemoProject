package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebDriverFactory {

    static WebDriver driver;

    public static WebDriver createDriver(Browsers type){
        switch (type){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return driver = new OperaDriver();
            default:
                return driver = null;
        }
    }

    public static WebDriver createDriver(Browsers type, MutableCapabilities driverOptions){
        switch (type){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver( (ChromeOptions) driverOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) driverOptions);
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver((OperaOptions) driverOptions);
            default:
                return null;
        }
    }

    public static WebDriver getDriver()
    {
       return driver;
    }
}
