import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count(0);
        Lock lock = new ReentrantLock();
        Count count2 = new Count(0);
        System.out.println("before start : value of count is 1 " + count.getValue());
        System.out.println("before start : value of count is 2 " + count2.getValue());
        for (int i = 0; i<30; i++){
            Adder adder = new Adder(count, lock);
            Adder adder2 = new Adder(count2, lock);
            Subtractor subtractor = new Subtractor(count, lock);
            Subtractor subtractor2 = new Subtractor(count2, lock);
            Thread t1 = new Thread(adder);
            t1.start();
            Thread t2 = new Thread(subtractor);
            t2.start();

            Thread t3 = new Thread(adder2);
            t3.start();
            Thread t4 = new Thread(subtractor2);
            t4.start();

            t1.join();
            t2.join();

            t3.join();
            t4.join();

            System.out.println("After end : value of count 1 is " + count.getValue());
            System.out.println("After end : value of count 2 is " + count2.getValue());
        }
    }
}