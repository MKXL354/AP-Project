import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class ClientHandler implements Runnable {

    private Socket connectionSocket;

    public ClientHandler(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        DataObject dataObject;
        DataManager dataManager;

        try {
            OutputStream out = connectionSocket.getOutputStream();
            ObjectOutputStream outObj=new ObjectOutputStream(out);
            InputStream in = connectionSocket.getInputStream();
            ObjectInputStream inObj=new ObjectInputStream(in);
            while(true){
                dataObject=(DataObject)inObj.readObject();
                dataManager=new DataManager(dataObject);
                dataObject=dataManager.response();
                outObj.writeObject(dataObject);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
            	connectionSocket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}