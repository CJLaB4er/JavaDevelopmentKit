package developers;

public interface BackendAction {
    default void serverCoding(){
        System.out.println("Making server code");
    }
}
