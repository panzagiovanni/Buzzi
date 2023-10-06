/*Realizzare programma JAVA con un monitor che gestisce più thread che 
  'dormono' e un thread che li sveglia dopo un tempo che è definito dai 
  thread 'dormienti', per ogni thread questo tempo deve essere diverso*/

public class MonitorSveglia {
	public static void main(String[] args) {
		try {	
			int i=0;
	    	Sveglia sveglia = new Sveglia();
	    	while (true) {
	    		
	    		Thread persona = new Thread(new Persona (i++, sveglia));
	    		persona.start();
	    		Thread.sleep(1000);
	    	}
		}
	    	catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
