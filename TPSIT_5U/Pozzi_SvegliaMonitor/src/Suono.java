package monitorSveglia;

public class Suono implements Runnable{
	Sveglia sveglia;
	public Suono (Sveglia sveglia) {
		this.sveglia=sveglia;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200);
				sveglia.sveglia();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
