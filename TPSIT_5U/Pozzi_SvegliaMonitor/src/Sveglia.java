import java.util.Random;

public class Sveglia{	
	
	Sveglia sveglia=this;
	
	public Sveglia() {
		Thread suono= new Thread(new Suono(sveglia));
		suono.start();
	}
	public synchronized int wake() throws InterruptedException {
		Random random = new Random();
		int i = (random.nextInt(10)+1)*1000;;
		return i;
	}
	public synchronized void waiting() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void sveglia() {
		notifyAll();
	}
}
