package homework33.server;

public class ServerStarter {

    public static void main(String[] args) {

        new Thread(() -> {
            MultiClientServer server = new MultiClientServer();
            server.start();
        }).start();
    }
}
