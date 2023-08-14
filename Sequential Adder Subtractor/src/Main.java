public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count(0);
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        System.out.println("before start : value of count is " + count.getValue());
        Thread t1 = new Thread(adder);
        t1.start();
        t1.join();
        Thread t2 = new Thread(subtractor);
        t2.start();
        t2.join();

        System.out.println("After end : value of count is " + count.getValue());

    }
}