package Orsucci;

import java.net.*;

public class MultiServer {
    //definiamo le variabili
    ServerSocket mioServer;
    Socket connessione;
    int porta=12000;
    
   public void connessione() throws Exception{
       mioServer=new ServerSocket(porta);
       
        while(true){
             System.out.println("Servizio avviato su porta: "+porta);
             System.out.println("In attesa di richieste...");
             Socket socket=mioServer.accept();
             System.out.println("Connesione stabilita con: "+socket);
             //generiamo un thread
             ServerThread sThread=new ServerThread(socket);
             sThread.start();
        }
   }
}
