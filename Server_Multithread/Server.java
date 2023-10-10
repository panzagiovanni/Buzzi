public class Server {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(new Handler(socket));
            thread.start();
        }
    }

    private class Handler implements Runnable {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = in.readLine();
                out.println("Messaggio ricevuto: " + message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
