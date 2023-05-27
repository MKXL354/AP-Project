public class DataManager {
    private DataObject dataObject;
    private String method;

    public DataManager(DataObject dataObject){
        this.dataObject=dataObject;
        method=dataObject.getMethod();
    }

    public void runMethod(){
        // if-else for methods
    }

    public DataObject response(){
        return dataObject;
        // new dataObject
        // needs to be completed
    }
}
