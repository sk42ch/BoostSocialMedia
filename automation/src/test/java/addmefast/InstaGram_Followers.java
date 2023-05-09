package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.INSTAGRAM_FOLLOWERS;
import static web.AddmefastMenu.TIKTOK_FOLLOWERS;

public class InstaGram_Followers extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void insta_followers() {
        /**
         * Instagram Followers 55 follower per Account per day. No need to change settings
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(INSTAGRAM_FOLLOWERS);
        for (int i = 0; i < 255; i++) {
            System.out.println("TOtal Loopn Run " + i);
            youtubeLike.Instagram_Followers_Flow();
        }
    }
}
