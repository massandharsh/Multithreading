import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        {
            Queue<UnitOfWork> buffer = new ConcurrentLinkedDeque<>();
            Integer bufferLimit = 10;
            Lock lock = new ReentrantLock();

            Producer producer = new Producer(buffer, bufferLimit, lock);
            Consumer consumer = new Consumer(buffer, bufferLimit, lock);


            Thread p1 = new Thread(producer);
            Thread p2 = new Thread(producer);
            Thread p3 = new Thread(producer);
            Thread p4 = new Thread(producer);
            Thread c1 = new Thread(consumer);


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
}


