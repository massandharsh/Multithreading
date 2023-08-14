package squaresWith_Runnable_Executor;

public class SquarePrinter3 implements Runnable {
    Integer number;

    public SquarePrinter3(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Current thread : " +Thread.currentThread().getName() +" "+  number*number);
    }
}
