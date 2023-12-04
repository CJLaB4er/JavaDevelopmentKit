package developers;

public interface FrontendAction {
    default void frontendCoding(){
        System.out.println("Making frontend code");
    }
}
