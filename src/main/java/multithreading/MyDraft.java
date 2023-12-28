package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class MyDraft {
    public static int aa = 0;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);

//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        IntStream.range(0, 50000).forEach(i -> {
//            aa++;
//            Thread task = new Thread(() ->
//                    atomicInteger.updateAndGet(n -> n + 2));
//            executor.submit(task);
//        });
//        executor.shutdown();
////        Thread.sleep(100);
//        System.out.println(atomicInteger.get() + " atomicInteger");
//        System.out.println(aa + " int");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                aa++;
                atomicInteger.incrementAndGet();
            }

        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                aa++;
                atomicInteger.incrementAndGet();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                aa++;
                atomicInteger.incrementAndGet();

            }
        });

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1);
        System.out.println(atomicInteger.get() + " atomicInteger");
        System.out.println(aa + " int");

    }

}