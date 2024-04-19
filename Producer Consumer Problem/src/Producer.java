import java.util.Queue;

public class Producer implements Runnable{
    private Integer bufferLimit;
    private Queue<UnitOfWork> buffer;


    public Producer(Queue<UnitOfWork> buffer, Integer bufferLimit) {
        this.bufferLimit = bufferLimit;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            if(buffer.size() < bufferLimit ){
                buffer.add(new UnitOfWork());
                System.out.println("Produced by thread " +Thread.currentThread().getName() + " and size is "+ buffer.size());
            }
        }
    }
}
