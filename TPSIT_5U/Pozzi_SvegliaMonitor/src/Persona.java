package monitorSveglia;

class Persona implements Runnable {
		
	private int num_mat;
	private Sveglia sveglia;
	private int tempo;
	
	public Persona (int i , Sveglia sveglia) throws InterruptedException {
		this.num_mat = i;
		this.sveglia = sveglia;
		tempo=sveglia.wake();
	}

	@Override
	public void run() {
		System.out.println("La matricola numero: " + num_mat + " si e' messa a dormire.");
		long tempoIni=System.currentTimeMillis();
		while(true) {
			sveglia.waiting();
			if(System.currentTimeMillis()-tempoIni>tempo) {
				break;
			}
		}
		System.out.println("La matricola numero " + num_mat + " e' sveglia");
	}
}
