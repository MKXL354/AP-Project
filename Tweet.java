import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Tweet implements Serializable{
    private int likesCount;
    private int reTweetsCount;
    private int commentsCount;
    private String tweetDate;
    private String hashTag;
    private String message;
    private ArrayList<BufferedImage> images;

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