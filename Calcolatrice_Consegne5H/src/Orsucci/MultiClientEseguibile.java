package Orsucci;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiClientEseguibile {
    // Dichiarazione variabili
    Socket mioClient;
    int porta = 12000;
    // Stream per gestire il flusso in input
    InputStream in;
    InputStreamReader input;
    BufferedReader sIn;
    // Stream per gestire il flusso in output
    OutputStream out;
    PrintWriter sOut;

    // Metodo connessione
    public Socket connessione() throws Exception {
        mioClient = new Socket(InetAddress.getLocalHost(), porta);
        System.out.println("Apertura connessione con il server: " + InetAddress.getLocalHost() + " sulla porta: " + porta);
        InputTastiera inputTastiera = new InputTastiera();
        // Inizializzazione flusso output
        out = mioClient.getOutputStream();
        sOut = new PrintWriter(out);
        // Inizializzazione flusso input
        in = mioClient.getInputStream();
        input = new InputStreamReader(in);
        sIn = new BufferedReader(input);

        return mioClient;
    }

    public void comunica() throws Exception {
        
        // Prendiamo il segno dall'utente
        System.out.println("Immetti segno dell'operazione: ");
        System.out.println("Opzioni: \n+ Somma\n- Sottrazione\n* Moltiplicazione\n/ Divisione");
        String segno = InputTastiera.leggiString();

        System.out.println("Immetti il primo numero:");
        double n1 = InputTastiera.leggiDouble();
        sOut.println(segno);
        sOut.println(n1);
        sOut.flush();

        System.out.println("Immetti il secondo numero:");
        double n2 = InputTastiera.leggiDouble();
        sOut.println(n2);
        sOut.flush();

        // Leggiamo la risposta dal server
        String risultato = sIn.readLine();
        System.out.println("Il server ha risposto: " + risultato);
    }

    public static void main(String[] args) {
        MultiClientEseguibile c = new MultiClientEseguibile();
        try {
            c.connessione();
            c.comunica();
        } catch (Exception ex) {
            Logger.getLogger(MultiClientEseguibile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
