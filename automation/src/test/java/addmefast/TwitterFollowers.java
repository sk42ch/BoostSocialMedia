package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.FB_PAGE_LIKES;
import static web.AddmefastMenu.TWITTER_FOLLOWERS;

public class TwitterFollowers extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void twitter_Likes_followers() {
        /**
         * Facebook Likes Follwers limit is 40 per day, Do not run this class twice a day
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(TWITTER_FOLLOWERS);
        for (int i = 0; i < 80; i++) {
            youtubeLike.twitter_Followers_Flow();
        }
    }
}
