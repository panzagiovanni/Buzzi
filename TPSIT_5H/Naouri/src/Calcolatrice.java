public class Calcolatrice {
    public double somma(double a, double b) {
        return a + b;
    }

    public double sottrai(double a, double b) {
        return a - b;
    }

    public double moltiplica(double a, double b) {
        return a * b;
    }

    public double dividi(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Divisione per zero non consentita.");
        }
    }
}