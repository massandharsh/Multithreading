import java.util.Queue;

public class Consumer implements Runnable{
    private Integer bufferLimit;
    private Queue<UnitOfWork> buffer;
//    private String name;

    public Consumer(Queue<UnitOfWork> buffer, Integer bufferLimit){
        this.bufferLimit = bufferLimit;
        this.buffer = buffer;
    }


    @Override
    public void run() {
        while (true){
            if(buffer.size() > 0){
                buffer.remove();
                System.out.println("Consumed by thread " +Thread.currentThread().getName() + " and size is "+ buffer.size());
            }
        }
    }


}
