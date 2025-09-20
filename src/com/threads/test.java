package com.threads;

public class test {
    public static void main(String[] args) {
        World world = new World(); //new state (thread)
        Thread thread = new Thread(world);
        thread.start();//runnable
        for (int i = 1; i <= 100000000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

/*
Thread life cycle
new state->runnable->running->waiting/blocking->terminated
 */