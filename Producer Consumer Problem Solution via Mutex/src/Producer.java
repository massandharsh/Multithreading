import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable{
    private Integer bufferLimit;
    private Queue<UnitOfWork> buffer;
    private Lock lock;


    public Producer(Queue<UnitOfWork> buffer, Integer bufferLimit, Lock lock) {
        this.bufferLimit = bufferLimit;
        this.buffer = buffer;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            //lock.lock();
            synchronized (buffer){
                if (buffer.size() < bufferLimit) {
                    buffer.add(new UnitOfWork());
                    System.out.println("Produced by thread " + Thread.currentThread().getName() + " and size is " + buffer.size());
                }
            }
            //lock.unlock();
        }
    }
}
