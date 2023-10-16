package Falcone;
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
	String mexRisposta;

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
		//n1
		System.out.println("Inserisci il primo numero: ");
		String n1=tastiera.readLine();
		sOut.println(n1);
		sOut.flush();
		mexRisposta=sIn.readLine();
		System.out.println(mexRisposta);
		
		//op
		System.out.println("Inserisci l'operatore: ");
		String op=tastiera.readLine();
		sOut.println(op);
		sOut.flush();
		mexRisposta=sIn.readLine();
		System.out.println(mexRisposta);
		
		//n2
		System.out.println("Inserisci il secondo numero: ");
		String n2=tastiera.readLine();
		sOut.println(n2);
		sOut.flush();
		mexRisposta=sIn.readLine();
		System.out.println("Risultato: "+mexRisposta);
		
		
		
		
		//leggo la risposta dal server
		String mexRisposta=sIn.readLine();
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


