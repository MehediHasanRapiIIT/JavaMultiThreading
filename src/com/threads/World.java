package com.threads;

//public class World extends Thread {
//    @Override
//    public void run() {
//        for (int i = 1; i <= 100000000; i++) {
//            System.out.println(Thread.currentThread().getName());
//        }
//    }
//}
public class World implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100000000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}