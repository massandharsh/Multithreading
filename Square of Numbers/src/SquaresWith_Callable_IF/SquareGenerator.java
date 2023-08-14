package SquaresWith_Callable_IF;

import java.util.concurrent.Callable;

public class SquareGenerator implements Callable {
    Integer number;

    public SquareGenerator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("printed by " + " " + Thread.currentThread().getName() + " " + number*number);
        return number*number;
    }
}
