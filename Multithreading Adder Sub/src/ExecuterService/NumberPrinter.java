package ExecuterService;

public class NumberPrinter implements Runnable {
    private int NumberToPrint;

    public NumberPrinter(int numberToPrint) {
        this.NumberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName() + " " + NumberToPrint );
    }
}
