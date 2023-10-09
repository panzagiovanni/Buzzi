import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SportelloBancomatClient {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost"; // Modifica questo indirizzo se il server è in esecuzione su un altro host
        final int SERVER_PORT = 12345;

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            /*prendo le indicazioni fornite dal Server su come inserire i dati*/
            String input;
            String app= reader.readLine(); //leggo dal socket
            System.out.println(app);
            while (true) {

                input = scanner.nextLine();

                if (input.equalsIgnoreCase("fine")) {
                    break;
                }

                writer.println(input);
                String response = reader.readLine();
                System.out.println("Risposta dal server: " + response);
            }

            socket.close();
            reader.close();
            writer.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
