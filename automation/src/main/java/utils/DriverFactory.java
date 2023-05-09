package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;


public class DriverFactory{

    //  private static ConfigReader configReader = new ConfigReader();
    //  private static final String SAUCE_URL = "https://" + configReader.getSauceUsername() + ":" + configReader.getSauceKey() + "@ondemand.saucelabs.com:443/wd/hub";
    private static WebDriver driver = null;

    @BeforeSuite
    public static void before() {
        /**
         * C:\Program Files\Google\Chrome\Application
         * chrome.exe --remote-debugging-port=9224 --user-data-dir=sass=C:\Users\sohel\Desktop\ChromeData
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        opt.setExperimentalOption("debuggerAddress", "localhost:9224");
        driver = new ChromeDriver(opt);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


   // @AfterSuite
    public static void after() {
        if (driver != null) {
            //driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
