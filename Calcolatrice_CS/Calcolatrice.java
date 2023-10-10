public class Calcolatrice {
    public double somma(double num1, double num2) {
        return num1 + num2;
    }

    public double sottrazione(double num1, double num2) {
        return num1 - num2;
    }

    public double moltiplicazione(double num1, double num2) {
        return num1 * num2;
    }

    public double divisione(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divisione per zero non consentita");
        }
        return num1 / num2;
    }
}
