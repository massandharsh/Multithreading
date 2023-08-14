public class Adder implements Runnable{
    private Count count;
    private Count count2;

    public Adder(Count count, Count count2) {
        this.count = count;
        this.count2 = count2;
    }

    @Override
    public void run() {
        int k1, k2;
        for (int i=0; i<10000; i++){

        synchronized (count){
            k1 = count.getValue();
            k1+=i;
            count.setValue(k1);
        }


        synchronized (count2){
            k2 = count2.getValue();
            k2+=i;
            count2.setValue(k2);
        }

        }
    }
}
