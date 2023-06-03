import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.net.Socket;

class ClientHandler implements Runnable {

    private Socket connectionSocket;

    public ClientHandler(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        DataObject dataObject=new DataObject(null, null);
        DataManager dataManager=new DataManager(dataObject);

        try {
            OutputStream out = connectionSocket.getOutputStream();
            ObjectOutputStream outObj=new ObjectOutputStream(out);
            InputStream in = connectionSocket.getInputStream();
            ObjectInputStream inObj=new ObjectInputStream(in);
            while(true){
                try{
                    dataObject=(DataObject)inObj.readObject();
                } catch(StreamCorruptedException sce){
                    outObj.writeObject(new DataObject("failed to receive data", null));
                }
                dataManager.setData(dataObject);
                dataManager.runMethod();
                outObj.writeObject(dataManager.getData());
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