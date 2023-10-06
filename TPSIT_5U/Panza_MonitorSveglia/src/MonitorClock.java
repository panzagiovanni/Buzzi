class MonitorClock {
    public synchronized void svegliaPersona(int matricola, int tempo) throws InterruptedException {
        System.out.println("La persona con matricola"+matricola+" si sveglierà dopo " + tempo + " millisecondi.");
        wait(tempo);
        System.out.println("La persona con matricola"+matricola+"si è svegliata dopo " + tempo + " millisecondi.");
    }
}