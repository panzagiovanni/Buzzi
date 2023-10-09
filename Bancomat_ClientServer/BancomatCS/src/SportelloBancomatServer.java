import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SportelloBancomatServer {
    public static void main(String[] args) {
        final int PORT = 12345; // Porta su cui il server è in ascolto

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Sportello Bancomat in attesa di connessioni...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Il primo client si è connesso " + clientSocket.getInetAddress());

            Socket clientSocket2=serverSocket.accept();
            System.out.println("Il secondo client si è connesso " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

            String line;
            String app="Benvenuto allo Sportello Bancomat!" +
                    "       Operazioni supportate: versamento, prelievo" +
                    "Per uscire, digita 'fine'." +
                    "Inserisci l'operazione (versamento/prelievo/fine): ";
            writer.println(app);
            writer.flush();
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("versamento")) {
                    writer.println("Inserisci l'importo del versamento:");
                    double amount = Double.parseDouble(reader.readLine());
                    // Qui puoi aggiornare il saldo del conto bancario
                    writer.println("Versamento di " + amount + " effettuato con successo.");
                } else if (line.equalsIgnoreCase("prelievo")) {
                    writer.println("Inserisci l'importo del prelievo:");
                    double amount = Double.parseDouble(reader.readLine());
                    // Qui puoi verificare se il saldo è sufficiente e quindi eseguire il prelievo
                    writer.println("Prelievo di " + amount + " effettuato con successo.");
                } else if (line.equalsIgnoreCase("fine")) {
                    // Chiudi la connessione quando il cliente termina
                    break;
                } else {
                    writer.println("Comando non valido. Usa 'versamento', 'prelievo' o 'fine'.");
                }
            }

            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
