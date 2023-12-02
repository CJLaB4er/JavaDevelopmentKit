package interfaces;

public interface Human {
    default void walk(){
        System.out.println("Walks ot two feet");
    }

    public void talk();
}
