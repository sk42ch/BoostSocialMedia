package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.FB_PAGE_LIKES;

public class FacebookLikesFollowers extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void fb_Likes_followers() {
        /**
         * Facebook Likes Follwers limit is 40 per day, Do not run this class twice a day
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(FB_PAGE_LIKES);
        for (int i = 0; i < 40; i++) {
            youtubeLike.Facebook_Likes_Followers_Flow();
        }
    }
}
