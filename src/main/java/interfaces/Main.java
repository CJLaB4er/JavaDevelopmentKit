package interfaces;

public class Main {
    private static class Minotaurus implements Human, Bull {
        @Override
        public void walk() {
            System.out.println("Walk on two legs");
        }

        @Override
        public void talk() {
            System.out.println("Asks you a riddle");
        }
    }

    public static void main(String[] args) {
        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus minos = new Minotaurus();
        Human man1 = new Man();
        Bull ox2 = new Ox();
        Bull allBulls[] = {ox2, minos, minos0};
        Human[] allHumans = {man1, minos, minos1};
    }
}
