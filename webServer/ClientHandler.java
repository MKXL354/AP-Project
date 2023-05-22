import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class ClientHandler implements Runnable {

    private Socket connectionSocket;
    private int clientNum;

    public ClientHandler(Socket connectionSocket, int clientNum) {
        this.connectionSocket = connectionSocket;
        this.clientNum=clientNum;
    }

    @Override
    public void run() {
        try {
            OutputStream out = connectionSocket.getOutputStream();
            InputStream in = connectionSocket.getInputStream();
            byte[] buffer = new byte[2048];
            String[] messages = {"salam", "khubam!", "salamati!"};
            for (String msg: messages) {
                int read = in.read(buffer);
                System.out.println("RECV from "+clientNum+": " + new String(buffer, 0, read));
                out.write(msg.getBytes());
                System.out.println("SENT to "+clientNum+": " + msg);
            }
        } catch (IOException e) {
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
// needs to be heavily modified