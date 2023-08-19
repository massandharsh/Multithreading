package src;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() +": "+ "Hello Main");
        CountPrinter cp = new CountPrinter();
        Thread t1 = new Thread(cp);
        Thread t2 = new Thread(cp);
        t1.start();;
        t2.start();
        System.out.println(Thread.currentThread().getName() +": "+ "Bye Bye Main");
    }
}