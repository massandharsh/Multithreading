import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Sorter implements Callable <List<Integer>> {
    List<Integer> input;
    ExecutorService executorService;

    public Sorter(List<Integer> input, ExecutorService executorService) {
        this.input = input;
        this.executorService = executorService;
    }


    @Override
    public List<Integer> call() throws Exception {
        Random random = new Random();
        if (input.size() <= 1 ){
            return  new ArrayList<>(input);
        }


        int pivot = random.nextInt(input.size());
        System.out.println("pivot is " + pivot);
        System.out.println("Input is : " + input);
        int k = partition(input, pivot);
        Future<List<Integer>> left = executorService.submit(  new Sorter(input.subList(0,k), executorService  )   );
        Future<List<Integer>> right = executorService.submit( new Sorter(input.subList(k+1,input.size()), executorService  )   );

        boolean b = executorService.awaitTermination(10, TimeUnit.MILLISECONDS);

        List<Integer> finalOutput = new ArrayList<>();
        finalOutput.addAll(left.get());
        finalOutput.add(input.get(k));
        finalOutput.addAll(right.get());

        //System.out.println(finalOutput);
        return finalOutput;
    }
    int partition(List<Integer> inp, int pivot){
        int i = 0;
        int j = inp.size()-1;
        int start = 0;
        int end = input.size()-1;

        while (i < j) {

            while (input.get(i) <= input.get(pivot) && i < end) {
                i++;
            }

            while (input.get(j) > input.get(pivot) && j > start) {
                j--;
            }

            if(i <= j){
                swap(input, i, j);
            }
        }
        swap(input, pivot, j);
        return j;

    }


    public void swap(List<Integer> inp, int pos1, int pos2) {
        Collections.swap(inp, pos1, pos2);
    }
}
