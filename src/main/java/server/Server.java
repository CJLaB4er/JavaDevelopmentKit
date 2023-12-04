package server;

public class Server implements ListenerBtn {
    boolean serverWorking = false;
    private final Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        this.serverWorking = false;
    }

    private void start() {
        if (!serverWorking) {
            serverWorking = true;
            listener.messageRes("Server start");
        } else listener.messageRes("Сервер уже был запущен");
    }

    private void stop() {
        if (serverWorking) {
            serverWorking = false;
            listener.messageRes("Server down");
        } else listener.messageRes("Сервер уже остановлен");
    }

    @Override
    public void btnListen(boolean status) {
        if (!status) {
            stop();
        } else start();
    }
}
