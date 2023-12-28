package multithreading.myThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        MyThreadClass myThreadClass = new MyThreadClass();
//        myThreadClass.start();
//        MyThreadClass myThreadClass2 = new MyThreadClass();
//        myThreadClass2.start();
//        Thread.sleep(5);
//        System.out.println("MAIN THREAD!!!!!!!!!!!!!");

        Thread thread = new Thread(new MyRunnerClass(), "RuunableThread");
        thread.start();
    }

}

class MyThreadClass extends Thread {
    public void run() {
        for (int i = 100; i >= 0; i--) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyRunnerClass implements Runnable {

    @Override
    public void run() {
        for (int i = 15; i >= 0; i--) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
