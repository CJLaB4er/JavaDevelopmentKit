package multithreading;

public class Switcher {
    private static volatile boolean switcher = true;
    private static volatile boolean shutdown = false;
    private static int count = 8;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (!switcher) {
                System.out.println(count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count--;
                if (count < 1) break;
            }
            shutdown = !shutdown;
        });
        thread.start();
        while (!shutdown) {
            switcher = !switcher;
            Thread.sleep(3000);
            System.out.println("Переключение");
        }
        System.out.println("Счетчик дошел до 0, программа завершена");
    }
}
