package Falcone;
import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    Socket connessione;
    //creiamo i canali di stream
    OutputStream out;
    PrintWriter sOut;
    InputStream in;
    InputStreamReader input;
    BufferedReader sIn;
    String risposta;
    String mexRicevuto;
    String op;
    String n1;
    String n2;
    
    
    //definiamo il costruttore
    public ServerThread(Socket socket){
        this.connessione=socket;
    }
    //definiamo il metodo run
    @Override
    public void run(){
        try {
            comunica();
        } catch (Exception ex) {System.out.println(ex.getMessage());}
    }
    public void comunica() throws Exception{
        //inizializzazione flusso output
        out=connessione.getOutputStream();
        sOut=new PrintWriter(out);
        //inizializzazione flusso input
        in=connessione.getInputStream();
        input=new InputStreamReader(in);
        sIn=new BufferedReader(input);
        
        //n1
        n1=sIn.readLine();
        System.out.println(n1);
        risposta=n1;
        sOut.println(risposta);
        sOut.flush();
        
        //op
        op=sIn.readLine();
        System.out.println(mexRicevuto);
        risposta+=op;
        sOut.println(risposta);
        sOut.flush();
        
        //n2
        n2=sIn.readLine();
        System.out.println(n2);
        switch (op) {
        case "+":
        	risposta=String.valueOf(Double.parseDouble(n1)+Double.parseDouble(n2));
        	break;
        	
        case "-":
        	risposta=String.valueOf(Double.parseDouble(n1)-Double.parseDouble(n2));
        	break;
        	
        case "*":
        	risposta=String.valueOf(Double.parseDouble(n1)*Double.parseDouble(n2));
        	break;
        	
        case "/":
        	risposta=String.valueOf(Double.parseDouble(n1)/Double.parseDouble(n2));
        	break;
        	
        default:
        	risposta="Operatore errato";
        	break;
        }
       
        
        sOut.println(n1+op+n2+"="+risposta);
        sOut.flush();
        
        //chiudiamo i canali di stram
        sOut.close();
        sIn.close();
        System.out.println("Chiusura socket: "+connessione);
        connessione.close();
        
    }
}
