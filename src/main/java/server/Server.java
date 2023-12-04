package server;

public class Server {
    boolean serverWorking = false;
    private final Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        this.serverWorking = false;
    }

    public void start(){
        if (!serverWorking) {
            serverWorking = true;
            listener.messageRes("Server start");
        }
    }
    public void stop(){
        if (serverWorking) {
            serverWorking = false;
            listener.messageRes("Server down");
        }
    }
}
