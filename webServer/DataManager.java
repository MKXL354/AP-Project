import java.util.ArrayList;

public class DataManager {
    private DataObject dataObject;
    private String method;
    private Object object;
    private ArrayList<User> userList;

    public DataManager(DataObject dataObject){
        this.dataObject=dataObject;
        method=dataObject.getMethod();
        object=dataObject.getObject();
        userList=new ArrayList<>();
    }

    public void setData(DataObject dataObject){
        this.dataObject=dataObject;
        method=dataObject.getMethod();
    }

    public DataObject getData(){
        return dataObject;
    }

    public void runMethod(){
        if(method.equals("sign-up")){
            signUp((User)object);
        }
    }

    public void response(String response, Object responseObject){
        DataObject dataObject=new DataObject(response, responseObject);
        this.dataObject=dataObject;
    }

    public void signUp(User user){
        userList.add(user);
        response("successful", null);
    }
}
