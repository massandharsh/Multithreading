import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Thread :" + Thread.currentThread().getName() +
                            "Hello world from Main Method!");
        Scanner sc = new Scanner(System.in);
        System.out.print("enter 1 st number : ");
        int a = sc.nextInt();
        System.out.print("enter 2 nd number : ");
        int b = sc.nextInt();;

        Runnable r1 = new Adder(a,b);
        Thread t1 = new Thread(r1);
        t1.start();
        System.out.println("Bye Bye Main Method");
    }
}