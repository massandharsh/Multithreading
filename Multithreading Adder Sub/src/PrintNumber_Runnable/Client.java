package PrintNumber_Runnable;

public class Client {
    public static void main(String[] args) {
        for (int i=0; i<= 10; i++){
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);

            t.start();
        }
    }
}
