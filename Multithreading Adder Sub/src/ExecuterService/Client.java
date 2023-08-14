package ExecuterService;

import PrintNumber_Runnable.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=0; i<= 10; i++){
            PrintNumber_Runnable.NumberPrinter np = new NumberPrinter(i);
            es.execute(np);
        }
    }
}
