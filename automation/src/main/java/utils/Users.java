package utils;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

public class Users extends BasePage{

  private String byPassUrl = "https://work4cashamf.weebly.com/";
   private String addmefast_URL = "https://addmefast.com/";
   private By userNameField = By.xpath("//input[@name='email' and @type='email']");
   private By passwordField =By.xpath("//input[@name='password' and @type='password']");
   private By loginButton =By.name("login_button");
  private   By amfLink = By.xpath("//a[text()='LoginAMF']");


    @BeforeClass
    public void login_with_addmefast_credential() throws InterruptedException {
        DriverFactory.getDriver().navigate().to(byPassUrl);
        clickOn(amfLink);
        Thread.sleep(4000);
        if (isElementPresent(loginButton)){
            setValue(userNameField,"ranarahmannyc@gmail.com");
            setValue(passwordField,"$$UAD22o");
            clickOn(loginButton);
        }
    }
}
