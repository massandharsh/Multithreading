package squaresWith_Runnable_Executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class client {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(6,5,4,3,2,1,12,13,14,15);
        Executor executor = Executors.newFixedThreadPool(1);
        for(Integer value: values){
            executor.execute(new SquarePrinter3(value));
        }
    }
}
