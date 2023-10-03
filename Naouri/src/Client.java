import java.io.*;
import java.net.*;

public class Client {
    Socket mioSocket = null;
    int porta = 6789;
    DataInputStream in;
    DataOutputStream out;
    BufferedReader tastiera;

    public void comunica() {
        try {
            do {
                tastiera = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Inserisci un'operazione (somma n1 n2, sottrai ..., moltiplica ... , dividi ..., oppure  esci): ");
                String scelta = tastiera.readLine();
                out.writeBytes(scelta + "\n");

                if (scelta.equalsIgnoreCase("esci")) {
                    break;
                }
                
                /* 
                 Prof. Panza: la parte di codice sottostante che ti ho commentato generava dei problemi perchè il programma Server 
                 è fatto per ricevere gli operandi e l'operatore in un unico input (somma 5 3, ecc.)
                System.out.print("Inserisci il primo numero: ");
                int num1 = Integer.parseInt(tastiera.readLine());

                System.out.print("Inserisci il secondo numero: ");
                int num2 = Integer.parseInt(tastiera.readLine());

                out.writeBytes(num1 + " " + num2 + "\n");
                */
                System.out.println("Attendo risposta dal server...");
                String risposta = in.readLine();
                System.out.println("Risposta del Server: " + risposta);
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket connetti() {
        try {
            System.out.println("Provo a connettermi al Server...");

            Socket mioSocket = new Socket(InetAddress.getLocalHost(), porta);
            System.out.println("Connesso!");
            in = new DataInputStream(mioSocket.getInputStream());
            out = new DataOutputStream(mioSocket.getOutputStream());

            return mioSocket;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.connetti();
        c.comunica();
    }
}
