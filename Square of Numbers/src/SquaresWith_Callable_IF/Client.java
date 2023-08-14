package SquaresWith_Callable_IF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> values = Arrays.asList(4,54,6,7);

        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Future<Integer>> arr = new ArrayList<>();
        for(Integer value : values){
            Future<Integer> fo =  es.submit(new SquareGenerator(value));
            arr.add(fo);
        }

        System.out.println("in the mean time ......going to sleep ");
        Thread.sleep(2000);
        System.out.println("in the mean time ......waking up from  sleep ");

        for(Future<Integer> val : arr){
            System.out.println(val.get() + "printed by " + " " + Thread.currentThread().getName());
        }
    }
}
