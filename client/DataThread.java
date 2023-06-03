import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.net.Socket;

public class DataThread extends Thread{

    private DataManager dataManager;
    private DataObject dataObject;

    public DataThread(){
        dataObject=new DataObject(null, null);
        dataManager=new DataManager(dataObject);
    }

    public void setData(DataObject dataObject){
        this.dataObject=dataObject;
        dataManager.setData(dataObject);
    }
    
    @Override
    public void run() {

        try (Socket client = new Socket("127.0.0.1", 5757)) {
            System.out.println("Connected to server.");
            OutputStream out = client.getOutputStream();
            ObjectOutputStream outObj=new ObjectOutputStream(out);
            InputStream in = client.getInputStream();
            ObjectInputStream inObj=new ObjectInputStream(in);

            while(true){
                synchronized(this){
                    this.wait();
                }
                outObj.writeObject(dataObject);
                try{
                    dataObject=(DataObject)inObj.readObject();
                } catch(StreamCorruptedException sce){
                    outObj.writeObject(new DataObject("failed to receive data", null));
                }
                dataManager.setData(dataObject);
                System.out.println(dataObject.getMethod());
            }

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("done.");
    }
}