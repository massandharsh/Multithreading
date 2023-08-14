import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToBeSorted = new ArrayList<>();
        for(int i=0; i<50000; i++){
            listToBeSorted.add(0,i);
        }

        //System.out.println("Before sort : " + listToBeSorted);
        LocalDateTime startTime = LocalDateTime.now();

        ExecutorService es = Executors.newCachedThreadPool();
        Future<List<Integer>> output = es.submit(new Sorter(listToBeSorted, es));
        //System.out.println(output.get());

        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime,endTime);
        System.out.println("Time taken : " + duration.toMillis());

        es.shutdown();
    }
}
