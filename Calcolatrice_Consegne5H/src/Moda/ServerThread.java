package Moda;
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
        
        String testo;
		//sOut.write("Inserisci operazione:" +'\n');
		testo=sIn.readLine();
		String app[]=testo.split(" ");
		String a=app[0];
		String op=app[1];
		String b=app[2];
		
		String risultato=String.valueOf(Calcolatrice.calcola(Float.parseFloat(a), Float.parseFloat(b), op));
		sOut.write(risultato+'\n');
        
        
        /*
        while(true){
        String mexRicevuto=sIn.readLine();
        System.out.println("4_Messaggio ricevuto..");
        if(" ".equals(mexRicevuto)||mexRicevuto.equals("FINE")){
            sOut.println(mexRicevuto+" Server in chiusura");
           
            break;
        } else {
            String risposta="Ciao "+mexRicevuto+"!";
            sOut.println(risposta);
            sOut.flush();
        }
        }*/
        //chiudiamo i canali di stram
        sOut.close();
        sIn.close();
        System.out.println("Chiusura socket: "+connessione);
        connessione.close();
        
    }
}
