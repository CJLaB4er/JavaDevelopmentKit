package developers;

public class Main {
    public static void main(String[] args) {
        Backender backender = new Backender();
        Frontender frontender = new Frontender();
        FullStackMan fullStackMan = new FullStackMan();

        backender.serverCoding();
        frontender.frontendCoding();
        fullStackMan.serverCoding();
        fullStackMan.frontendCoding();
    }
}
