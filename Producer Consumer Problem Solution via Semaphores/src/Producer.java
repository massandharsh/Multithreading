import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable{
    private Integer bufferLimit;
    private Queue<UnitOfWork> buffer;
    private Semaphore Sp;
    private Semaphore Sc;


    public Producer(Queue<UnitOfWork> buffer, Integer bufferLimit, Semaphore Sp, Semaphore Sc) {
        this.bufferLimit = bufferLimit;
        this.buffer = buffer;
        this.Sp = Sp;
        this.Sc = Sc;
    }

    @Override
    public void run(){
        while (true){
            try {
                Sp.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            buffer.add(new UnitOfWork());
            Sc.release();

            System.out.println("Produced by thread " + Thread.currentThread().getName() + " and size is " + buffer.size() );
        }
    }
}
