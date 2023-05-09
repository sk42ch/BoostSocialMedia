package web;

import org.openqa.selenium.*;
import utils.BasePage;

import java.util.Iterator;
import java.util.Set;

import static utils.DriverFactory.getDriver;

public class YoutubeLike extends BasePage {
    private static final By CONFIRM_BUTTON = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Confirm']");
    private static final By FOLLOW_BUTTON_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Follow']");
    private static final By LIKE_BUTTON_1= By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Like']");
    private static final By SHARE_BUTTON_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Share']");
    private static final By SAVE_BUTTON_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Save']");
    private By amf_Yt_Like_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Like']");
    private By Yt_Like_Button_2 = By.xpath("(//yt-animated-icon[@animated-icon-type='LIKE'])[1]");
    private By amf_Yt_Subscribe_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Subscribe']");
    private By Yt_Subscribe_Button_2 = By.xpath("//div[@id='subscribe-button']//span[text()='Subscribe'] | //div[@id='subscribe-button']//yt-formatted-string[text()='Subscribe']");
    private By insta_Follow_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Follow']");
    private By insta_Follow_Button_2 = By.xpath("//button[@type='button']//div[text()='Follow']");
    private By insta_Likes_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Like']");
    private By insta_Likes_Button_2 = By.xpath("//span[@class='_aamw']/button[@type='button' and @class='_abl-']");
    private By tiktok_Follow_Button_2 = By.xpath("//button[@type='button' and @data-e2e='follow-button']");
    private By tiktok_Video_Like_Button_2 = By.xpath("//button[@type='button']/span[@data-e2e='like-icon']");
    private By facebook_Likes_Follow_Button_1 = By.xpath("//div[@class='likedPagesSingle']//div[@class='btn3' and text()='Like/Follow']");
private By facebook_Likes_Follow_Button_2 = By.xpath("//div[@aria-label='Like' and @role='button'] | //div[@aria-label='Follow' and @role='button'] ");
private By twitter_Follow_Button_2 = By.xpath("//div[@data-testid='confirmationSheetDialog']//following-sibling::div//span[text()='Follow']");
private By facebook_Post_Like_Button_2 = By.xpath("//*[@class='story_body_container']/following::div/a[text()='Like' and @role='button'] | (//*[@aria-label='Like' and @role='button'])[1]");
private By facebook_Post_Share_Button_2 = By.xpath("//button[@name='__CONFIRM__' and @type='submit']");
private By pintarest_Save_Button_2 = By.xpath("//div[@data-test-id='PinBetterSaveButton']//div[text()='Save']");
   private By pintarest_Follow_Button_2 = By.xpath("//div[@data-test-id='user-follow-button']//div[text()='Follow']");

    public YoutubeLike pintarest_Follow_Flow() {
        amf_Flow("NA", FOLLOW_BUTTON_1, pintarest_Follow_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike pintarest_Save_Flow() {
        amf_Flow("NA", SAVE_BUTTON_1, pintarest_Save_Button_2,3,4);
        return new YoutubeLike();
    }
public YoutubeLike twitter_Followers_Flow() {
        amf_Flow("CONFIRM", FOLLOW_BUTTON_1, twitter_Follow_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike facebook_Post_Share_Flow() {
        amf_Flow("NA", SHARE_BUTTON_1, facebook_Post_Share_Button_2,2,10);
        return new YoutubeLike();
    }

    public YoutubeLike Facebook_Post_Likes_Flow() {
        amf_Flow("CONFIRM", LIKE_BUTTON_1, facebook_Post_Like_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike Facebook_Likes_Followers_Flow() {
        amf_Flow("CONFIRM", facebook_Likes_Follow_Button_1, facebook_Likes_Follow_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike tikTok_Video_Like_Flow() {
        amf_Flow("NA",LIKE_BUTTON_1, tiktok_Video_Like_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike tikTok_Follow_Flow() {
        amf_Flow("NA", FOLLOW_BUTTON_1, tiktok_Follow_Button_2,5,5);

        return new YoutubeLike();
    }

    public YoutubeLike Instagram_Likes_Flow() {
        amf_Flow("CONFIRM", insta_Likes_Button_1, insta_Likes_Button_2,3,2);
        return new YoutubeLike();
    }

    public YoutubeLike Instagram_Followers_Flow() {
        amf_Flow("CONFIRM", insta_Follow_Button_1, insta_Follow_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike Youtube_Subscribe_Flow() {
        amf_Flow("NA", amf_Yt_Subscribe_Button_1, Yt_Subscribe_Button_2,3,4);
        return new YoutubeLike();
    }

    public YoutubeLike Youtube_Like_Flow() {
        amf_Flow("NA", amf_Yt_Like_Button_1, Yt_Like_Button_2,4,4);
        return new YoutubeLike();
    }

    private void amf_Flow(String extraButton, By button_1, By button_2, int beforeWait, int afterWait) {
        safeWaitSecond(3);
        try{
            clickOn(button_1);
        }catch (TimeoutException e){
            getDriver().navigate().refresh();
        }


        String parent = getDriver().getWindowHandle();
        Set<String> s = getDriver().getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                try {
                    getDriver().switchTo().window(child_window);
                    webAction(button_2);
                    safeWaitSecond(beforeWait);
                    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                    executor.executeScript("arguments[0].click();", getDriver().findElement(button_2));
                    safeWaitSecond(afterWait);
                } catch (NoSuchWindowException e) {
                    System.out.println("Now such Window Exception Happen");
                } catch (NoSuchElementException e) {
                    System.out.println("There is no button on Popup page");
                }catch (TimeoutException e){

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