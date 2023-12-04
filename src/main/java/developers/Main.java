package developers;

public class Main {
    public static void main(String[] args) {
        Developer backender = new Backender();
        if (backender instanceof Backender) ((Backender) backender).serverCoding();

        Developer frontender = new Frontender();
        if (frontender instanceof Frontender) ((Frontender) frontender).frontendCoding();

        Developer fullStackMan = new FullStackMan();
        if (fullStackMan instanceof FullStackMan) {
            ((FullStackMan) fullStackMan).serverCoding();
            ((FullStackMan) fullStackMan).frontendCoding();
        }
    }
}
