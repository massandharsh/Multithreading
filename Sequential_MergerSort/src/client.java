import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main(String[] args) {
        List<Integer>ArrayToBeSorted = new ArrayList<>();
        for(int i=0; i<50000; i++){
            ArrayToBeSorted.add(0,i);
        }

        //System.out.println("time starts ");
        LocalDateTime startTime = LocalDateTime.now();

        Sorter sorter = new Sorter(ArrayToBeSorted);
        //System.out.println("List Before sorting is :");
        //System.out.println(sorter);

        //calling sort
        List<Integer> sortedResult = sorter.sort();

        //System.out.println("List After sorting is :");
        Sorter sorter2 = new Sorter(sortedResult);
        //System.out.println(sorter2);

        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Time taken by code is "+ duration.toMillis());

    }
}
