package web;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import utils.BasePage;

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
        getDriver().navigate().to("https://addmefast.com");
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
