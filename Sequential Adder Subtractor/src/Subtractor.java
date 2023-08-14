public class Subtractor implements Runnable{
    Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        int k;
        for (int i=0; i<1000; i++){
            k = count.getValue() - i;
            count.setValue(k);
        }
    }
}
