public class Adder implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread :" + Thread.currentThread().getName() + " Hello I am Adder Class");
    }
}
