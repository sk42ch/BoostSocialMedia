package addmefast;

import org.testng.annotations.Test;
import utils.DriverFactory;
import web.Youtube;
import web.YoutubeLike;

import static web.AddmefastMenu.INSTAGRAM_LIKES;
import static web.AddmefastMenu.PINTAREST_SAVE;

public class PintarestSave extends DriverFactory {
 Youtube youtube;
   YoutubeLike youtubeLike;
//NGB_017  NGB_018, NGB_030
    @Test
    public void insta_followers() {
        /**
         * Instagram Followers 55 follower per Account per day. No need to change settings
         */
        youtube = new Youtube();
       youtubeLike=  youtube.clickOn_Amf_Menu(PINTAREST_SAVE);
        for (int i = 0; i < 255; i++) {
            System.out.println("TOtal Loopn Run " + i);
            youtubeLike.pintarest_Save_Flow();
        }
        //    @Test(dependsOnMethods = STEP_3, alwaysRun = true)
//    public void insta_Likes() {
//        youtubeLike = youtube.clickOn_Amf_Menu(INSTAGRAM_LIKES);
//        for (int i = 0; i < 20; i++) {
//            youtubeLike.Instagram_Likes_Flow();
//        }
//    }
    }
}
