public class Main {
    public static void main(String[] args) {

        System.out.println("Thread :" + Thread.currentThread().getName() +" Hello world from Main Method!");
        Runnable runnaable1 = new Adder();
        Runnable runnaable2 = new Subtractor();

        Thread t1 = new Thread(runnaable1);
        Thread t2 = new Thread(runnaable2);
        t1.setName("Adder Thread");
        t2.setName("Subtractor Thread");

        t1.start();
        t2.start();

        System.out.println("Bye Bye Main Method");

    }
}