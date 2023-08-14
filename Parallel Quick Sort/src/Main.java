import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> input = Arrays.asList(2,8,1,14,7);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Sorter sorter = new Sorter(input, executorService);
        Future<List<Integer>> output = executorService.submit(sorter);

        System.out.println("After sorting values are : ");
        System.out.println(output.get());

        executorService.shutdown();
    }
}