import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket socketClient;

    private int porta = 6789;
    private BufferedReader in;
    private PrintWriter out;
    private Calcolatrice calcolatrice;

    public Server() {
        calcolatrice = new Calcolatrice();
    }

    public void comunica() {
        try {
            in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            out = new PrintWriter(socketClient.getOutputStream(), true);

            String richiesta;
            while ((richiesta = in.readLine()) != null) {
                System.out.println("Richiesta ricevuta dal client: " + richiesta);

                if (richiesta.equalsIgnoreCase("esci")) {
                    System.out.println("Il client ha chiuso la connessione.");
                    break;
                }

                String risposta = processaRichiesta(richiesta);
                out.println(risposta);
            }

            socketClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String processaRichiesta(String richiesta) {
        String[] parti = richiesta.split(" ");
        if (parti.length != 3) {
            return "Richiesta non valida.";
        }

        int a = Integer.parseInt(parti[1]);
        int b = Integer.parseInt(parti[2]);
        double risultato = 0;
        String operatore = parti[0].toLowerCase();

        switch (operatore) {
            case "somma":
                risultato = calcolatrice.somma(a, b);
                return "Risultato della somma: " + risultato;
            case "sottrai":
                risultato = calcolatrice.sottrai(a, b);
                return "Risultato della sottrazione: " + risultato;
            case "moltiplica":
                risultato = calcolatrice.moltiplica(a, b);
                return "Risultato della moltiplicazione: " + risultato;
            case "dividi":
                try {
                    risultato = calcolatrice.dividi(a, b);
                    return "Risultato della divisione: " + risultato;
                } catch (ArithmeticException ex) {
                    return "Errore: " + ex.getMessage();
                }
            case "esci":
                return "Il client ha chiuso la connessione.";
            default:
                return "Funzione non supportata.";
        }
    }

    public void attendi() {
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Server pronto, in ascolto sulla porta: " + porta);
            socketClient = serverSocket.accept();
            System.out.println("Connessione stabilita con un client.");

            // Non chiudere il serverSocket se si vuole accettare più connessioni.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.attendi();
        server.comunica();
    }
}
