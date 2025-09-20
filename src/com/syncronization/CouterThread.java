package com.syncronization;

public class CouterThread extends Thread {

    private Counter counter;
    public CouterThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
