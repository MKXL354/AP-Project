public class DataObject {
    private String method;
    private Object object;

    public DataObject(String method, Object object){
        this.method=method;
        this.object=object;
    }

    public String getMethod() {
        return method;
    }

    public Object getObject() {
        return object;
    }
}
