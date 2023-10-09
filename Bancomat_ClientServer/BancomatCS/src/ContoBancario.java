import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ContoBancario {
    private double saldo = 0;

    public double getSaldo() {
        return saldo;
    }

    public synchronized void versamento(double importo) {
        saldo += importo;
    }

    public synchronized boolean prelievo(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
            return true;
        }
        return false;
    }
}