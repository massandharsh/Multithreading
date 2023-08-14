import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(8,7);
//        List<Integer> input =new ArrayList<>();
//        for(int i=0;i<20;i++){
//            input.add(0,i);
//        }
        System.out.println(input);
        Sorter sorter = new Sorter(input);
        List<Integer> output =  sorter.sort();
        System.out.println("After sort method");
        System.out.println(output);
        System.out.println(input);



    }
}