package SquaresWith_ThreadClass;

import java.util.Arrays;
import java.util.List;

/**
 *  Use Thread class and create threads manually
 *
 */


public class client {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5);
        for(Integer value : values){
            Thread thread = new SquarePrinter1(value);
            thread.start();
        }
    }
}
