package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.*;

public class YT_Channel_101 extends DriverFactory {
    private static final String STEP_1 = "yt_Subscribers";
    private static final String STEP_2 ="yt_Like";
    private static final String STEP_3="insta_Followers";
    private static final String STEP_4 = "insta_Likes";
    private static final String STEP_5 = "tiktok_Follow";
    Youtube youtube;
    YoutubeLike youtubeLike;

//    @Test
//    public void yt_Subscribers() {
//        youtube = new Youtube();
//        youtubeLike = youtube.select_Youtube_Channel_and_Navigate_to_AddmefastPage_("RanaRahman101").clickOn_Amf_Menu(YOUTUBE_SUBSCRIBE);
//        for (int i = 0; i < 20; i++) {
//            youtubeLike.Youtube_Subscribe_Flow();
//        }
//    }
//
//    @Test(dependsOnMethods = STEP_1, alwaysRun = true)
//    public void yt_Like() {
//        youtubeLike = youtube.clickOn_Amf_Menu(YOUTUBE_LIKES);
//        for (int i = 0; i < 1; i++) {
//            youtubeLike.Youtube_Like_Flow();
//        }
//    }
//
//    @Test(dependsOnMethods = STEP_2, alwaysRun = true)
//    public void insta_Followers() {
//        youtubeLike = youtube.clickOn_Amf_Menu(INSTAGRAM_FOLLOWERS);
//        for (int i = 0; i < 10; i++) {
//            youtubeLike.Instagram_Followers_Flow();
//        }
//    }
//
//    @Test(dependsOnMethods = STEP_3, alwaysRun = true)
//    public void insta_Likes() {
//        youtubeLike = youtube.clickOn_Amf_Menu(INSTAGRAM_LIKES);
//        for (int i = 0; i < 20; i++) {
//            youtubeLike.Instagram_Likes_Flow();
//        }
//    }

    @Test//(dependsOnMethods = STEP_4,alwaysRun = true)
    public void tiktok_Follow() {
       youtube = new Youtube();
        youtubeLike = youtube.clickOn_Amf_Menu(TIKTOK_FOLLOWERS);
        for (int i = 0; i < 20; i++) {
            youtubeLike.tikTok_Follow_Flow();
        }
    }

    @Test(dependsOnMethods = STEP_5, alwaysRun = true)
    public void tiktok_Video_Likes() {
        youtubeLike = youtube.clickOn_Amf_Menu(TIKTOK_VIDEO_LIKES);
        for (int i = 0; i < 40; i++) {
            youtubeLike.tikTok_Video_Like_Flow();
        }
    }
}
