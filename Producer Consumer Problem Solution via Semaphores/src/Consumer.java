import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
    private Integer bufferLimit;
    private Queue<UnitOfWork> buffer;
    private Semaphore Sc;
    private Semaphore Sp;

    public Consumer(Queue<UnitOfWork> buffer, Integer bufferLimit, Semaphore Sc, Semaphore Sp){
        this.bufferLimit = bufferLimit;
        this.buffer = buffer;
        this.Sc  = Sc;
        this.Sp = Sp;
    }


    @Override
    public void run() {
        while (true){
            try {
                Sc.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            buffer.remove();
            Sp.release();

            System.out.println("Consumed by thread " + Thread.currentThread().getName() + " and size is " + buffer.size());
        }
    }


}
