import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
    private Integer bufferLimit;
    private Queue<UnitOfWork> buffer;
    private Lock lock;

    public Consumer(Queue<UnitOfWork> buffer, Integer bufferLimit, Lock lock){
        this.bufferLimit = bufferLimit;
        this.buffer = buffer;
        this.lock = lock;
    }


    @Override
    public void run() {
        while (true){
            //lock.lock();
            synchronized (buffer) {
                if (buffer.size() > 0) {
                    buffer.remove();
                    System.out.println("Consumed by thread " + Thread.currentThread().getName() + " and size is " + buffer.size());
                }
            }
            //lock.unlock();
        }
    }


}
