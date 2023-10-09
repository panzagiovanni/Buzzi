import java.io.IOException;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Qui puoi gestire la logica specifica per il client, ad esempio leggere/scrivere dati
        // Utilizza clientSocket.getInputStream() e clientSocket.getOutputStream() per comunicare con il client
        // Chiudi la connessione quando hai finito
        while (true)
        {

        }
    }
}