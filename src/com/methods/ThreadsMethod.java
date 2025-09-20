package com.methods;

public class ThreadsMethod extends Thread {
//Naming the Threads
//    public ThreadsMethod(String name){
//        super(name);
//    }

    @Override
    public void run() {

//        for(int i=1; i<10;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }

//        for(int i=1; i<=10;i++){
//            System.out.println(Thread.currentThread().getName()+" - Priority: "+Thread.currentThread().getPriority());
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        try {
//            Thread.sleep(1000);
//            System.out.println("running");
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted "+e.getMessage());;
//        }

        //yield()
//        for(int i=1; i<=10;i++){
//            System.out.println(Thread.currentThread().getName()+" - is running ");
//
//            Thread.yield();
//        }

    }
    public static void main(String[] args) {
        //setPriority
        /*
        ThreadsMethod threadsMethod = new ThreadsMethod("Low");
        ThreadsMethod t1 = new ThreadsMethod("Medium");
        ThreadsMethod t2 = new ThreadsMethod("High");
        threadsMethod.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        threadsMethod.start();
        t1.start();
        t2.start();
         */
        ThreadsMethod threadsMethod = new ThreadsMethod();
        Thread t1 = new Thread(threadsMethod);
        threadsMethod.start();
        t1.start();

        //threadsMethod.interrupt();
    }
}
