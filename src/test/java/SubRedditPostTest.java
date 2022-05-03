import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubRedditPostTest {
    private SubRedditPost subRedditPost;

    @BeforeEach
    void setup() {
        String username = "zy75UB3HCW2HPFsAbnVJWg";
        String password = "cWOWs6-5BmjnAcHPKfUTLsG8zmuvxA";
        String subReddit = "earthPorn";
        String searchType = "top";
        subRedditPost = new SubRedditPost(username, password, subReddit, searchType);
    }

    @Test
    void should_returnPostAuthor_when_RinchoaStress() {
        //  given
        String expected = "partiallycylon";
        //  when
        String actual = subRedditPost.getAuthor();
        //  then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnPostTitle_when_RinchoaStress() {
        //  given
        String expected = "Some parts of Oregon aren't waterfalls or forests or coastal cliffs or volcanos. [OC] [2160 × 1250]";
        //  when
        String actual = subRedditPost.getTitle();
        //  then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnImageURL_when_RinchoaStress() {
        //  given
        String expected = "https://i.redd.it/s54ivt0ow5x81.jpg";
        //  when
        String actual = subRedditPost.getImageUrl();
        //  then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnPostPermalink_when_RinchoaStress() {
        //  given
        String expected = "www.reddit.com/r/EarthPorn/comments/uh4rpx/some_parts_of_oregon_arent_waterfalls_or_forests/";
        //  when
        String actual = subRedditPost.getPermalink();
        //  then
        assertEquals(expected, actual);
    }

}