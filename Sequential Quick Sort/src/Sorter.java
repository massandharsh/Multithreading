import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Sorter {
    private List<Integer> input;

    public Sorter(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> sort() {
        return quickSort(input, 0, input.size() - 1);
    }

    private List<Integer> quickSort(List<Integer> input, int start, int end) {
        Random random = new Random();
        if (end <= start)
            return input;

        int pivot = random.nextInt(end - start + 1) + start;

        int k = partition(input, start, end, pivot);
        List<Integer> left = quickSort(input.subList(0,k), 0, k-1 );
        List<Integer> right = quickSort(input.subList(k+1,input.size()), 0, input.size()-k-2);
        List<Integer> output = new ArrayList<>();
        output.addAll(left);
        output.add(input.get(k));
        output.addAll(right);
        System.out.println("temp out : "  + output);
        return output;
    }

    int partition(List<Integer> input, int start, int end, int pivot) {
        int i = 0;
        int j = input.size()-1;
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
        int temp = inp.get(pos1);
        inp.set(pos1, inp.get(pos2));
        inp.set(pos2, temp);
    }
}


