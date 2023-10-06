import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MonitorClock monitor = new MonitorClock();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int tempo = random.nextInt(2000); // Tempo casuale tra 0 e 2000 millisecondi
            Thread thread = new Persona(monitor, tempo, i);
            thread.start();
        }
    }
}