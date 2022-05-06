import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import twitter4j.TwitterException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TweetAPITest {
    private TweetAPI tweetAPI;

    @BeforeEach
    void setup() {
        String api_key = "uJ7QjrC590jkS73JFn5Y0l4X0";
        String api_secret = "rT5JAWD1KAGvXKDMspMxfpWBJoz3QtiGhaJSP2qsF0Uj3uyBnf";
        String access_token = "1309402936213221377-B46Xp0aeIHDb33JodR7lEeb0ORfRJc";
        String access_token_secret = "yigmJIsf7YTdBIBgpCE1Bxmfqsd219CdB8yKwOmtFh79s";
        tweetAPI = new TweetAPI(api_key, api_secret, access_token, access_token_secret);
    }

    @Test
    void should_returnTimeLine_when_correctInput() throws TwitterException {
        //  given
        List<String> expected = new ArrayList<>();
        //  when
        List<String> actual = tweetAPI.getTimeline();
        //  then
        assertEquals(expected.getClass(), actual.getClass());
    }

    @Test
    void should_throwTwitterException_when_incorrectInput() throws TwitterException {
        //  given
        tweetAPI = mock(TweetAPI.class);
        doThrow(TwitterException.class).when(tweetAPI).getTimeline();
        //  when
        Executable executable = () -> tweetAPI.getTimeline();
        //  then
        assertThrows(TwitterException.class, executable);
    }

    @Test
    void should_postPostTweet_when_correctInput() throws TwitterException {
        //  given
        tweetAPI = mock(TweetAPI.class);
        //  when
        tweetAPI.postTweet(anyString());
        //  then
        verify(tweetAPI, times(1)).postTweet(anyString());
        verifyNoMoreInteractions(tweetAPI);
    }

    @Test
    void should_throwExceptionPostPostTweet_when_incorrectInput() throws TwitterException {
        //  given
        tweetAPI = mock(TweetAPI.class);
        doThrow(TwitterException.class).when(tweetAPI).postTweet(anyString());
        //  when
        Executable executable = () -> tweetAPI.postTweet("placehold");
        //  then
        assertThrows(TwitterException.class, executable);
    }

//    @Test
//    void should_postImagePostTweet_when_correctInput() throws TwitterException {
//        //  given
//        tweetAPI = mock(TweetAPI.class);
//        Twitter twitter = mock(Twitter.class);
//        //  when
//        tweetAPI.postImageTweet(anyString(), any(), anyString());
//        //  then
//        verify(twitter, times(1)).uploadMedia(anyString(), any());
//    }

    @Test
    void should_postImagePostTweet_when_correctInput() throws TwitterException {
        //  given
        tweetAPI = mock(TweetAPI.class);
        //  when
        tweetAPI.postImageTweet(anyString(), any(), anyString());
        //  then
        verify(tweetAPI, times(1)).postImageTweet(anyString(), any(), anyString());
        verifyNoMoreInteractions(tweetAPI);
    }

    @Test
    void should_throwExceptionPostImagePostTweet_when_incorrectInput() throws TwitterException {
        //  given
        tweetAPI = mock(TweetAPI.class);
        doThrow(TwitterException.class).when(tweetAPI).postImageTweet(anyString(), any(), anyString());
        //  when
        Executable executable = () -> tweetAPI.postImageTweet(anyString(), any(), anyString());
        //  then
        assertThrows(TwitterException.class, executable);
    }

}