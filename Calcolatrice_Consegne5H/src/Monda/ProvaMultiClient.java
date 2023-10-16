package Monda;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProvaMultiClient {
	//dichiarzione variabili
	Socket mioClient;
	int porta=12000;
	//stresm per gestire flusso in input
	InputStream in;
	InputStreamReader input;
	BufferedReader sIn;
	//gest flusso in output
	OutputStream out;
	PrintWriter sOut;

	BufferedReader tastiera;

	//metodo connessione
	public Socket connessione() throws Exception{
		mioClient=new Socket(InetAddress.getLocalHost(), porta);
		System.out.println("3_Apertura connessione con server: "+InetAddress.getLocalHost()+ "su porta: "+porta);
		tastiera=new BufferedReader(new InputStreamReader(System.in));
		//inizializzazione flusso output
		out=mioClient.getOutputStream();
		sOut=new PrintWriter(out);
		//inizializzazione flusso input
		in=mioClient.getInputStream();
		input=new InputStreamReader(in);
		sIn=new BufferedReader(input);

		return mioClient;
	}
	public void comunica() throws Exception{
		while(true){
			System.out.println("5_Immetti stringa da trasmettere al server: ");
			String mexUtente=tastiera.readLine();
			//spediamola al server
			System.out.println("6_Invio messaggio al server..");
			sOut.write(mexUtente+'\n');
			sOut.flush();
			//leggo la risposta dal server
			String mexRisposta=sIn.readLine();
			System.out.println("7_Il server ha risposto: "+mexRisposta);
		} 
	}
	public static void main(String[] args) {
		ProvaMultiClient c=new ProvaMultiClient();
		try {
			c.connessione();
			c.comunica();
		} catch (Exception ex) {
			Logger.getLogger(ProvaMultiClient.class.getName()).log(Level.SEVERE, null, ex);
		}



	}

}


