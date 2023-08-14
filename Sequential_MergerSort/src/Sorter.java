import java.util.ArrayList;
import java.util.List;

public class Sorter {
    private List<Integer> input = new ArrayList<>();

    @Override
    public String toString() {
        //System.out.println("The Result is :");
        StringBuilder result= new StringBuilder();
        for (Integer inp : input){
            result.append(inp +" ");
        }
        return result.toString();
    }

    public Sorter(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> sort(){
        return mergeSort(input);
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
