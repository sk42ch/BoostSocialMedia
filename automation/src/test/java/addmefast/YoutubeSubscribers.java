package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.YOUTUBE_LIKES;
import static web.AddmefastMenu.YOUTUBE_SUBSCRIBE;

public class YoutubeSubscribers extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;

    @Test
    public void yt_Likes_flow() {
        /**
         * Facebook Likes Follwers limit is 40 per day, Do not run this class twice a day
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(YOUTUBE_SUBSCRIBE);
        for (int i = 0; i < 150; i++) {
            youtubeLike.Youtube_Subscribe_Flow();
        }
    }
}
