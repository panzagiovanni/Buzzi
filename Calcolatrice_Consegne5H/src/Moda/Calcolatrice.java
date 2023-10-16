package Moda;

public class Calcolatrice {
	
	public static float calcola (float a, float b, String op) {
		float app=0;
		switch (op) {
		case "+":
			app=a+b;
			break;
		case "-":
			app=a-b;
			break;
		case "*":
			app=a*b;
			break;
		case "/":
			app=a/b;
			break;
		}
		return app;
	}
}
