package squaresWith_Runnable_IF;

import java.util.Arrays;
import java.util.List;

public class client {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        for(Integer value : values){
            Thread thread = new Thread(new SquarePrinter2(value));
            thread.start();
        }
    }
}
