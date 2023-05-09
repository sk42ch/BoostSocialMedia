package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.FACEBOOK_POST_LIKES;

public class FACEBOOK_POST_SHARE extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void fb_Post_Likes_followers() {
        /**
         * Facebook Likes Follwers limit is 40 per day, Do not run this class twice a day
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(FACEBOOK_POST_LIKES);
        for (int i = 0; i < 40; i++) {
            youtubeLike.facebook_Post_Share_Flow();
        }
    }
}
