package web;

import org.openqa.selenium.*;
import utils.BasePage;

import java.util.List;

import static utils.DriverFactory.getDriver;

public class Youtube extends BasePage {
    private String youtube_Channel_Switcher_URL = "https://www.youtube.com/channel_switcher";
    private By search_Your_Channel_Field = By.xpath("//*[@id='input-1']/input");

    public Youtube select_Youtube_Channel_and_Navigate_to_AddmefastPage_(String youtubeChannelName) {
        getDriver().navigate().to(youtube_Channel_Switcher_URL);
        setValue(search_Your_Channel_Field, youtubeChannelName);
        webAction(search_Your_Channel_Field).sendKeys(Keys.ENTER);
        safeWaitSecond(2);
        clickOn(By.xpath("//*[@id='channel-title' and text()='" + youtubeChannelName + "']"));
        safeWaitSecond(2);
        return this;
    }

    public YoutubeLike clickOn_Amf_Menu(String menuItem) {
       // String url = "https://addmefast.com";
      //  getDriver().navigate().to(url);
        boolean isSpinnerDisplayed = isElementPresent(By.xpath("//div[@id='challenge-spinner']"));
        if (isSpinnerDisplayed){
            safeWaitSecond(60);
        }
        try {
            if (getDriver().getTitle().contains(menuItem)) {
            } else {
                clickOn(By.xpath("//div[@class='menu_item_sub']/img[@title='" + menuItem + "']/following-sibling::a"));
            }
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,250)", "");
            safeWaitSecond(1);
            clickOn(By.xpath("//div[@class='menu_item_sub']/img[@title='" + menuItem + "']/following-sibling::a"));
        }
        safeWaitSecond(3);
        return new YoutubeLike();
    }
}
