public class Main {
    public static void main(String[] args) throws InterruptedException {



        for (int i=1;i<=10;i++){
            Count count = new Count(0);
            Count count2 = new Count(0);
            System.out.println("");
            System.out.println("Before start : ");
            System.out.println("count1 : " + count.getValue()  +"   count2 is : " + count2.getValue());
            System.out.print("args");
            Adder adder = new Adder(count, count2);
            Subtractor subtractor = new Subtractor(count, count2);

            Thread t1 = new Thread(adder);
            Thread t2 = new Thread(subtractor);
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("After end of iteration : " + i);
            System.out.println("count1 : " + count.getValue()  +"   count2 is : " + count2.getValue());
        }

    }
}