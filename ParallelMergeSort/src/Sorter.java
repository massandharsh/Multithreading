import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private final List<Integer> input;
    ExecutorService es;

    public Sorter(List<Integer> inputList, ExecutorService es) {
        this.input= inputList;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(input.size() <= 1)
            return input;

        int mid = input.size()/2;
        List<Integer> left = input.subList(0,mid);
        List<Integer> right = input.subList(mid, input.size());

        Future<List<Integer>> leftSorted = es.submit(new Sorter(left, es));
        Future<List<Integer>> rightSorted = es.submit(new Sorter(right, es));

        return merge(leftSorted.get(), rightSorted.get());
    }

    private List<Integer> mergeSort(List<Integer> input){
        if(input.size() <= 1)
            return input;

        int mid = input.size()/2;
        List<Integer> Left  = mergeSort(input.subList(0,mid));
        List<Integer> Right = mergeSort(input.subList(mid,input.size()));

        return merge(Left, Right);
    }

    private List<Integer> merge(List<Integer>left, List<Integer>right){
        int l_index = 0;
        int r_index = 0;
        List<Integer> mergedResult = new ArrayList<>();

        while(l_index < left.size()  &&  r_index < right.size()){
            if(left.get(l_index) <= right.get(r_index)){
                mergedResult.add(left.get(l_index));
                l_index++;
            }
            else{
                mergedResult.add(right.get(r_index));
                r_index++;
            }
        }

        while (l_index < left.size()){
            mergedResult.add(left.get(l_index));
            l_index++;
        }

        while (r_index < right.size()){
            mergedResult.add(right.get(r_index));
            r_index++;
        }


        return mergedResult;
    }
}
