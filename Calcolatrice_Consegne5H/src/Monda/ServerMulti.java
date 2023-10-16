package Monda;
import java.net.*;
public class ServerMulti {
    //definiamo le variabili
    ServerSocket mioServer;
    Socket connessione;
    int porta=12000;
    
   public void connessione() throws Exception{
       mioServer=new ServerSocket(porta);
       
        while(true){
             System.out.println("1_Servizio avviato su porta: "+porta);
             System.out.println("2_in attesa di richieste...");
             Socket socket=mioServer.accept();
             System.out.println("3_Connesione stabilita"+socket);
             //generiamo un thread
             ServerThread sThread=new ServerThread(socket);
             sThread.start();
        }
   }
}
