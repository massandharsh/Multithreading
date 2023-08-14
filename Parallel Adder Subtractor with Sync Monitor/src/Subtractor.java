public class Subtractor implements Runnable{
    Count count;
    Count count2;

    public Subtractor(Count count, Count count2) {
        this.count = count;
        this.count2 = count2;
    }

    @Override
    public void run() {
        int k1, k2;
        for (int i=0; i<10000; i++){

            synchronized (count) {

                k1 = count.getValue();
                k1-=i;
                count.setValue(k1);
            }


            synchronized (count){
                k2 = count2.getValue();
                k2+=i;
                count2.setValue(k2);
            }

        }
    }
}
