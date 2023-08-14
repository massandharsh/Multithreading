package squaresWith_Runnable_IF;

public class SquarePrinter2 implements  Runnable{
    Integer number;

    public SquarePrinter2(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Current thread : " +Thread.currentThread().getName() +" "+  number*number);
    }
}
