package Moda;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProvaServerMulti {
	public static void main(String[] args) {
		ServerMulti ser=new ServerMulti();
		try {
			ser.connessione();
		} catch (Exception ex) {
			Logger.getLogger(ProvaServerMulti.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
