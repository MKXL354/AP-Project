public class Tweet{
    protected int likesCount;
    protected int reTweetsCount;
    protected int commentsCount;
    protected String tweetDate;
    protected String hashTag;

    public Tweet(String tweetDate, String hashTag) {
        this.likesCount = 0;
        this.reTweetsCount = 0;
        this.commentsCount = 0;
        this.tweetDate = tweetDate;
        this.hashTag = hashTag;
    }

    public void addLike() {
        this.likesCount++;
    }

    public void addReTweet() {
        this.reTweetsCount++;
    }

    public void addComment() {
        this.commentsCount++;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }
}
// add imageTweet later
// add combinedTweet
// imageTweet multiple images