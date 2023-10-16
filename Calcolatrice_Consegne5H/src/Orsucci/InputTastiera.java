package Orsucci;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTastiera {
        private static InputStreamReader input;
        private static BufferedReader reader;

        static {
            input = new InputStreamReader(System.in);
            reader = new BufferedReader(input);
        }

        public InputTastiera() {
        }

        public static int leggiInt() {
            int app = 0;
            boolean fatto = false;

            do {
                try {
                    app = Integer.parseInt(reader.readLine());
                    fatto = true;
                } catch (NumberFormatException var3) {
                    System.out.println("Formato errato, riprova:");
                } catch (IOException var4) {
                    var4.printStackTrace();
                }
            } while(!fatto);

            return app;
        }

        public static int leggiInt(String msg) {
            System.out.println(msg);
            return leggiInt();
        }

        public static double leggiDouble() {
            double app = 0.0;
            boolean fatto = false;

            do {
                try {
                    app = Double.parseDouble(reader.readLine());
                    fatto = true;
                } catch (NumberFormatException var4) {
                    System.out.println("Formato errato, riprova:");
                } catch (IOException var5) {
                    var5.printStackTrace();
                }
            } while(!fatto);

            return app;
        }

        public static double leggiDouble(String msg) {
            System.out.println(msg);
            return leggiDouble();
        }

        public static String leggiString() {
            String app = "";
            boolean fatto = false;

            do {
                try {
                    app = reader.readLine();
                    fatto = true;
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
            } while(!fatto);

            return app;
        }

        public static String leggiString(String msg) {
            System.out.println(msg);
            return leggiString();
        }
    }