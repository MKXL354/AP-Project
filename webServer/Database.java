import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/myDatabase";
            String userName="root";
            String passWord="1402AP";

            Connection conn=DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connected to database");
            return conn;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized DataObject addUser(User user){
        return null;
    }
}