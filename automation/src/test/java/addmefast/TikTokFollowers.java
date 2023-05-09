package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.TIKTOK_FOLLOWERS;
import static web.AddmefastMenu.TWITTER_FOLLOWERS;

public class TikTokFollowers extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void tiktok_followers() {
        /**
         * Facebook Likes Follwers limit is 40 per day, Do not run this class twice a day
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(TIKTOK_FOLLOWERS);
        for (int i = 0; i < 40; i++) {
            System.out.println("TOtal Loopn Run " + i);
            youtubeLike.tikTok_Follow_Flow();
        }
    }
}
