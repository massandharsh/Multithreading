import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Queue<UnitOfWork> buffer = new ConcurrentLinkedDeque<>();
        Integer bufferLimit = 10;

        Producer producer = new Producer(buffer, bufferLimit);
        Consumer consumer = new Consumer(buffer, bufferLimit);

//        Executor executor = Executors.newFixedThreadPool(5);
//        executor.execute(producer);
//        executor.execute(consumer);

        Thread p1 = new Thread(producer);
        Thread p2 = new Thread(producer);
        Thread p3 = new Thread(producer);
        Thread p4 = new Thread(producer);
        Thread c1 = new Thread(consumer);
//        Thread c2 = new Thread(consumer);
//        Thread c3 = new Thread(consumer);
        p1.setName("Producer Thread_1");
        p2.setName("Producer Thread_2");
        p3.setName("Producer Thread_3");
        p4.setName("Producer Thread_4");
        c1.setName("Consumer Thread_1");


        p1.start();
        p2.start();
        p3.start();
        c1.start();
        p4.start();
    }
}