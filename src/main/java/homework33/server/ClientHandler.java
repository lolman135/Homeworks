package homework33.server;

import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class ClientHandler implements Runnable{

    private final Socket cleintSocket;
    private final String clientName;
    private final ConcurrentHashMap<String, Socket> activeConnections;
    private final Logger LOGGER;

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(cleintSocket.getInputStream()))){
            String inputLine;

            sendMessage(clientName + " entered chat.", null);

            while ((inputLine = in.readLine()) != null){
                LOGGER.info("received from " + clientName + ": " + inputLine);

                if (inputLine.equals("/q")){
                    LOGGER.info(clientName + " disconnected");
                    activeConnections.remove(clientName);
                    sendMessage(clientName + " leave chat.", null);
                    break;
                }

                sendMessage('(' + clientName + "):" + inputLine, clientName);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                cleintSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendMessage(String message, String senderName){
        activeConnections.forEach((name, socket) -> {
            try{
                PrintWriter clientOut = new PrintWriter(socket.getOutputStream(), true);
                clientOut.println(message);
            } catch (IOException e){
                LOGGER.error("Error: failed to send message", e);
            }
        });
    }
}
