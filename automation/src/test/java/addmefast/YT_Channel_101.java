package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.YOUTUBE_LIKES;
import static web.AddmefastMenu.YOUTUBE_SUBSCRIBE;

public class YT_Channel_101 extends DriverFactory {
    private static final String STEP_1 = "yt_Subscribers";
    Youtube youtube;
    YoutubeLike youtubeLike;

    @Test
    public void yt_Subscribers() {
        youtube = new Youtube();
        youtubeLike = youtube.select_Youtube_Channel_and_Navigate_to_AddmefastPage_("RanaRahman103").clickOn_Amf_Menu(YOUTUBE_SUBSCRIBE);
        for (int i = 0; i < 1; i++) {
            youtubeLike.Youtube_Subscribe_Flow();
        }
    }

    @Test(dependsOnMethods = STEP_1, alwaysRun = true)
    public void yt_Like() {
        youtubeLike = youtube.clickOn_Amf_Menu(YOUTUBE_LIKES);
        for (int i = 0; i < 1; i++) {
            youtubeLike.Youtube_Like_Flow();
        }
    }
}
