class Persona extends Thread {
    private MonitorClock monitor;
    private int tempo, matricola;



    public Persona(MonitorClock monitor, int tempo, int matricola) {
        this.monitor = monitor;
        this.tempo = tempo;
        this.matricola = matricola;
    }

    @Override
    public void run() {
        try {
            monitor.svegliaPersona(matricola, tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}