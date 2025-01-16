package homework33.server;

import homework33.utils.Constants;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class MultiClientServer {

    private static final ConcurrentHashMap<String, Socket> activeConnections = new ConcurrentHashMap<>();
    private static final Logger LOGGER = Logger.getLogger(MultiClientServer.class.getName());

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(Constants.PORT)){
            LOGGER.info("server starts at port: " + Constants.PORT);

            while(true){
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String clientName = in.readLine();
                activeConnections.put(clientName, clientSocket);
                LOGGER.info(clientName + " successfully connected to the server");
                ClientHandler clientHandler = new ClientHandler(clientSocket, clientName, activeConnections, LOGGER);
                new Thread(clientHandler).start();
            }
        } catch (Exception e){
            LOGGER.error("Error: connection failed", e);
        }
    }
}
