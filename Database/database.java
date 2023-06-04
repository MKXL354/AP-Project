import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class database{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        users newUser = new users(null, null, null, null, null, 0, 0, null, null, null, null, null, null);

        String url = "jdbc:postgresql://localhost:5432/twitter";
        String username = "postgres";
        String password = "kiyan1234";
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (username, password, first_name, last_name, email, phone, country_code, bio, birth_date, profile, header, create_timestamp, update_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //pstmt.setInt(1, 1002);
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, sha256(newUser.getPassword()));
            pstmt.setString(3, newUser.getFirst_name());
            pstmt.setString(4, newUser.getLast_name());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getPhone());
            pstmt.setInt(7, newUser.getCountry_code());
            pstmt.setString(8, newUser.getBio());
            pstmt.setString(9, newUser.getBirth_date());
            pstmt.setString(10, newUser.getProfile());
            pstmt.setString(11, newUser.getHeader());
            pstmt.setString(12, newUser.getCreate_timestamp());
            pstmt.setString(13, newUser.getUpdate_timestamp());
            System.out.println("success");
        }catch (SQLException e){
            System.out.println("DATABASE connection ERROR : " + e);
        }
        
        
    }
    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) 
                  hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }
}
