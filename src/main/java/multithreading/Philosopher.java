package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Philosopher extends Thread {
    private final String name;
    private int count = 1;
    private Random random = new Random();

    public Philosopher(String name) {
        this.name = name;
    }

    private void eat() throws InterruptedException {
        System.out.println("Филосов " + name + " приступил к приёму пищи в " + count + " раз.");
        Thread.sleep(500);
        int thoughts = random.nextInt(500, 3001);
        System.out.println("Филосов " + name + " поел и решил поразмышлять " + thoughts/1000.0 + " секунд.");
        Thread.sleep(thoughts);
    }

    @Override
    public void run() {
        while (count < 4) {
            try {
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
        System.out.println("Филосов " + name + " закончил свой путь.");

    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> philList = new ArrayList<>();
        philList.add(new Philosopher("Аристотель"));
        philList.add(new Philosopher("Платон"));
        philList.add(new Philosopher("Теофраст"));
        philList.add(new Philosopher("Евклид"));
        philList.add(new Philosopher("Гиппократ"));

        for (Thread phil :
                philList) {
            phil.start();
        }
        for (Thread phil :
                philList) {
            phil.join();
        }
        System.out.println("Все философы поели по три зара и закончили свой путь.");
    }
}
