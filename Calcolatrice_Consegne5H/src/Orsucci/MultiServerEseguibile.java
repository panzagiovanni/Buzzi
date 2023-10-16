package Orsucci;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiServerEseguibile {
	public static void main(String[] args) {
		MultiServer ser=new MultiServer();
		try {
			ser.connessione();
		} catch (Exception ex) {
			Logger.getLogger(MultiServerEseguibile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
