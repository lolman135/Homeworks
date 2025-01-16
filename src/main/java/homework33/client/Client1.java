package homework33.client;

import homework33.utils.Constants;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {

    private static final Logger LOGGER = Logger.getLogger(Client1.class.getName());

    public static void main(String[] args) {

        try (Socket socket = new Socket(Constants.HOST, Constants.PORT)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Please, enter name: ");
            String clientName;
            while (true){
                System.out.print("Please, enter name: ");
                clientName = userInput.readLine();
                if (clientName != null && !clientName.trim().isEmpty()) {
                    break;
                }
                System.out.println("Invalid name, try again");
            }

            out.println(clientName);

            LOGGER.info("[CLIENT] connected as " + clientName);

            Thread serverListener = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        synchronized (System.out) {
                            System.out.print("\r" + " ".repeat(50) + "\r");
                            System.out.println(serverMessage);
                            System.out.print("Enter message or '/q' to end session: ");
                        }
                    }
                } catch (IOException e) {
                    LOGGER.warn("[CLIENT] Connection to server lost.");
                }
            });
            serverListener.start();

            String message;

            while (true) {
                System.out.print("Enter message or '/q' to end session:");
                message = userInput.readLine();
                out.println(message);

                if (message.equals("/q")) {
                    LOGGER.info("disconnected");
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error: connection failed ", e);
        }
    }
}
