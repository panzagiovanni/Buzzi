import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    public static void main(String[] args) {
        int port = 12345; // Porta su cui il server ascolterà le connessioni

        try {
            // Creazione del server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server in ascolto sulla porta " + port);

            while (true) {
                // Accettare una connessione da un client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connesso da " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

                // Creare un nuovo thread per gestire la connessione del client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}