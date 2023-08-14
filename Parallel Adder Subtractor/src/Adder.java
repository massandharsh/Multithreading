import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable{
    Count count;
    Lock lock;
    //Lock lock2 = new ReentrantLock();

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        int k;
        for (int i=0; i<1000; i++){
//            lock.lock();
            synchronized (count)
            {
                k = count.getValue() + i;
                count.setValue(k);
            }

//            lock.unlock();

        }
    }
}
