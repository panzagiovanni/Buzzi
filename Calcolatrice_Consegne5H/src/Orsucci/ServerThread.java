package Orsucci;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    Socket connessione;
    OutputStream out;
    PrintWriter sOut;
    InputStream in;
    InputStreamReader input;
    BufferedReader sIn;
    
    public ServerThread(Socket socket){
        this.connessione = socket;
    }
    
    @Override
    public void run(){
        try {
            comunica();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void comunica() throws Exception {
        out = connessione.getOutputStream();
        sOut = new PrintWriter(out);
        in = connessione.getInputStream();
        input = new InputStreamReader(in);
        sIn = new BufferedReader(input);

        // Leggiamo n1, operatore e n2 separatamente
        String operatore = sIn.readLine();
        String n1 = sIn.readLine();
        String n2 = sIn.readLine();

        System.out.println("Ricevuto n1: " + n1);
        System.out.println("Ricevuto operatore: " + operatore);
        System.out.println("Ricevuto n2: " + n2);

        double risultato = 0.0;

        switch (operatore) {
            case "+":
                risultato = Double.parseDouble(n1) + Double.parseDouble(n2);
                break;
            case "-":
                risultato = Double.parseDouble(n1) - Double.parseDouble(n2);
                break;
            case "*":
                risultato = Double.parseDouble(n1) * Double.parseDouble(n2);
                break;
            case "/":
                if (Double.parseDouble(n2) != 0) {
                    risultato = Double.parseDouble(n1) / Double.parseDouble(n2);
                } else {
                    sOut.println("Divisione per zero non consentita");
                    sOut.flush();
                    connessione.close();
                    return;
                }
                break;
            default:
                sOut.println("Operatore non valido");
                sOut.flush();
                connessione.close();
                return;
        }

        // Inviamo il risultato al client
        sOut.println("Risultato: " + risultato);
        sOut.flush();

        // Chiudiamo i canali di stream e il socket
        sOut.close();
        sIn.close();
        System.out.println("Chiusura socket: " + connessione);
        connessione.close();
    }
}
