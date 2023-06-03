import java.io.Serializable;
import java.awt.image.BufferedImage;

public class User implements Serializable{
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String passWord;
    private String country;
    private String birthDate;
    private String bio;
    private String location;
    private String webSiteAddress;
    private String signUpDate;
    private String lastModified;
    private BufferedImage avatar;
    private BufferedImage header;

    public User(String userName, String firstName, String lastName, String email, String phoneNumber, String passWord, String country, String birthDate){
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.passWord=passWord;
        this.country=country;
        this.birthDate=birthDate;
    }

    public void setBio(String bio){
        this.bio=bio;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public void setWebSiteAddress(String webSiteAddress){
        this.webSiteAddress=webSiteAddress;
    }

    public void setAvatar(BufferedImage avatar){
        this.avatar=avatar;
    }
    
    public void setHeader(BufferedImage header){
        this.header=header;
    }
}