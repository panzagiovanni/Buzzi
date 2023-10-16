import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcolatriceServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Calcolatrice in attesa di connessioni...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata da " + clientSocket.getInetAddress());

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            //creo gli oggetti per l'input output sul Socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            Calcolatrice calcolatrice = new Calcolatrice();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length != 3) {
                    writer.println("Formato del comando non valido. Usa: [operazione] [numero1] [numero2]");
                    continue;
                }

                String operazione = tokens[0];
                double num1 = Double.parseDouble(tokens[1]);
                double num2 = Double.parseDouble(tokens[2]);

                double risultato = 0;

                try {
                    switch (operazione.toLowerCase()) {
                        case "somma":
                            risultato = calcolatrice.somma(num1, num2);
                            break;
                        case "sottrazione":
                            risultato = calcolatrice.sottrazione(num1, num2);
                            break;
                        case "moltiplicazione":
                            risultato = calcolatrice.moltiplicazione(num1, num2);
                            break;
                        case "divisione":
                            risultato = calcolatrice.divisione(num1, num2);
                            break;
                        default:
                            writer.println("Operazione non valida. Usa: somma, sottrazione, moltiplicazione o divisione.");
                            continue;
                    }

                    writer.println("Risultato: " + risultato);
                } catch (ArithmeticException e) {
                    writer.println("Errore: " + e.getMessage());
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
