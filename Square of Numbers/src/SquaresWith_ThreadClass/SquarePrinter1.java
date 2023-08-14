package SquaresWith_ThreadClass;

public class SquarePrinter1 extends Thread{
    Integer number;

    public SquarePrinter1(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Current thread : " +Thread.currentThread().getName() +" "+  number*number);
    }
}
