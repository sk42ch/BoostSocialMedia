package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.FACEBOOK_POST_LIKES;
import static web.AddmefastMenu.FB_PAGE_LIKES;

public class FacebookPostLikes extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void fb_Post_Likes_followers() {
        /**
         * Facebook Likes Follwers limit is 40 per day, Do not run this class twice a day
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(FACEBOOK_POST_LIKES);
        for (int i = 0; i < 240; i++) {
            youtubeLike.Facebook_Post_Likes_Flow();
        }
    }
}
