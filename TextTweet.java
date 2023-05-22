public class TextTweet extends Tweet{
    private String text;

    public TextTweet(String text, String tweetDate, String hashTag){
        super(tweetDate, hashTag);
        this.text=text;
    }
}