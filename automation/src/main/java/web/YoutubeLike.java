package web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import utils.BasePage;

import java.util.Iterator;
import java.util.Set;

import static utils.DriverFactory.getDriver;

public class YoutubeLike extends BasePage {
    private static final By CONFIRM_BUTTON = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Confirm']");
    private By amf_Yt_Like_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Like']");
    private By Yt_Like_Button_2 = By.xpath("(//yt-animated-icon[@animated-icon-type='LIKE'])[1]");
    private By amf_Yt_Subscribe_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Subscribe']");
    private By Yt_Subscribe_Button_2 = By.xpath("//div[@id='subscribe-button']//span[text()='Subscribe'] | //div[@id='subscribe-button']//yt-formatted-string[text()='Subscribe']");
    private By insta_Follow_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Follow']");
    private By insta_Follow_Button_2 = By.xpath("//button[@type='button']//div[text()='Follow']");
    private By insta_Likes_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Like']");
    private By insta_Likes_Button_2 = By.xpath("//span[@class='_aamw']/button[@type='button' and @class='_abl-']");

    public YoutubeLike Instagram_Likes_Flow() {
        amf_Flow("CONFIRM", insta_Likes_Button_1, insta_Likes_Button_2);
        return new YoutubeLike();
    }

    public YoutubeLike Instagram_Followers_Flow() {
        amf_Flow("CONFIRM", insta_Follow_Button_1, insta_Follow_Button_2);
        return new YoutubeLike();
    }

    public YoutubeLike Youtube_Subscribe_Flow() {
        amf_Flow("NA", amf_Yt_Subscribe_Button_1, Yt_Subscribe_Button_2);
        return new YoutubeLike();
    }

    public YoutubeLike Youtube_Like_Flow() {
        amf_Flow("NA", amf_Yt_Like_Button_1, Yt_Like_Button_2);
        return new YoutubeLike();
    }

    private void amf_Flow(String extraButton, By button_1, By button_2) {
        safeWaitSecond(3);
        clickOn(button_1);
        String parent = getDriver().getWindowHandle();
        Set<String> s = getDriver().getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                try {
                    getDriver().switchTo().window(child_window);
                    safeWaitSecond(7);
                    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                    executor.executeScript("arguments[0].click();", getDriver().findElement(button_2));
                    safeWaitSecond(3);
                } catch (NoSuchWindowException e) {
                    System.out.println("Now such Window Exception Happen");
                } catch (NoSuchElementException e) {
                    System.out.println("There is no button on Popup page");
                }
                if (!child_window.isEmpty()) {
                    try {
                        getDriver().close();
                    } catch (NoSuchWindowException e) {

                    }

                }
                getDriver().switchTo().window(parent);
                switch (extraButton) {
                    case "CONFIRM":
                        safeWaitSecond(1);
                        clickOn(CONFIRM_BUTTON);
                        break;
                    case "NA":
                        break;
                    default:
                        break;
                }
            }
        }
    }
}