public class Adder implements Runnable {
    protected int a;
    protected int b;

    public Adder(int a, int b){
        this.a = a;
        this.b = b;
    }

    public Adder(){
    }

    @Override
    public void run() {
        System.out.println("Thread :" + Thread.currentThread().getName() + " Hello I am Adder Class");
        System.out.println("The result of sum is mentioned below");
        System.out.println("Result : " + this.a + this.b);
        System.out.println("Thread :" + Thread.currentThread().getName() + " Ending Adder Class");
    }
}
