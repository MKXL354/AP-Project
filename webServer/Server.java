import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int counter = 0;
        try (ServerSocket welcomingSocket = new ServerSocket(5757)) {
            System.out.println("Server created");
            while (counter<1000) {
                Socket connectionSocket = welcomingSocket.accept();
                counter++;
                System.out.println("client accepted!");
                pool.execute(new ClientHandler(connectionSocket, counter));
            }
            pool.shutdown();
            System.out.println("Closing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}

// add condition for exiting the loop and closing the server