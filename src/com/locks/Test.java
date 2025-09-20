package com.locks;

public class Test {
    public static void main(String[] args) {
        BankAccount brac = new BankAccount();
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                brac.withdraw(50);
            }
        };
        Thread t2 = new Thread(t1, "Thread 1");
        Thread t3 = new Thread(t1, "Thread 2");
        t2.start();
        t3.start();
    }
}
