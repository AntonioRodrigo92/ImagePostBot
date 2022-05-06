import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubRedditPostTest {
    private SubRedditPost subRedditPost;

    @BeforeEach
    void setup() {
        String username = "";
        String password = "";
        String subReddit = "earthPorn";
        String searchType = "top";
        subRedditPost = new SubRedditPost(username, password, subReddit, searchType);
    }

    @Test
    void should_returnPostAuthor_when_RinchoaStress() {
        //  given
        String expected = "roseandcharles";
        //  when
        String actual = subRedditPost.getAuthor();
        //  then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnPostTitle_when_RinchoaStress() {
        //  given
        String expected = "Night sky over the badlands of southern Utah [OC][1920x1080]";
        //  when
        String actual = subRedditPost.getTitle();
        //  then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnImageURL_when_RinchoaStress() {
        //  given
        String expected = "https://i.redd.it/570zv6mijrx81.jpg";
        //  when
        String actual = subRedditPost.getImageUrl();
        //  then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnPostPermalink_when_RinchoaStress() {
        //  given
        String expected = "www.reddit.com/r/EarthPorn/comments/ujcxvj/night_sky_over_the_badlands_of_southern_utah/";
        //  when
        String actual = subRedditPost.getPermalink();
        //  then
        assertEquals(expected, actual);
    }

}
