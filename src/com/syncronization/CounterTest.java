package com.syncronization;

public class CounterTest {

    public static void main(String[] args) {
        Counter counter = new Counter();
        CouterThread couterThread = new CouterThread(counter);
        CouterThread couterThread1 = new CouterThread(counter);
        couterThread.start();
        couterThread1.start();

        try{
            couterThread.join();
            couterThread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
