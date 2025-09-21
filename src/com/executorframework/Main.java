package com.executorframework;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        long startTime = System.currentTimeMillis();
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        for (int i = 1; i < 10; i++) {
//            int finalI = i;
//            executor.submit(()->{
//                long result = factorial(finalI);
//                System.out.println("Factorial of is: "+result);
//            });
//
//        }
//        executor.shutdown();
//        try {
//            executor.awaitTermination(100, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Total time: "+(System.currentTimeMillis()-startTime) + " ms" );

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        //Callable
//        Callable<Integer> callable = ()->42;
//        Future<Integer> future = executorService.submit(callable);
//        //Direct use of callable using lambda
//        //Future<Integer> future = executorService.submit(()->41);
//
//        try {
//            Integer result = future.get();
//            if(future.isDone()) {
//
//
//                System.out.println("Result: "+result);
//                System.out.println("Task is completed....");
//
//            }else{
//                System.out.println("Task is not completed yet....");
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        executorService.shutdown();
//    }

//    private static long factorial(int n){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        long result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
//        return result;

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<Integer> submit = executorService.submit(()->1+2);
//        Integer i = submit.get();
//        System.out.println(i);
//        executorService.shutdown();
        //System.out.println(executorService.isShutdown());
        //Thread.sleep(1000);
        //System.out.println(executorService.isTerminated());

//        Callable<Integer> c1 = ()->{
//            System.out.println("Task 1 started");
//            return 1;
//        };
//        Callable<Integer> c2 = ()->{
//            System.out.println("Task 2 started");
//            return 2;
//        };
//        Callable<Integer> c3 = ()->{
//            System.out.println("Task 3 started");
//            return 3;
//        };
//
//        List<Callable<Integer>> list = Arrays.asList(c1,c2,c3);
//        List<Future<Integer>> result = executorService.invokeAll(list);
//        for(Future<Integer> f: result){
//            System.out.println(f.get());
//        }
//        executorService.shutdown();
//        System.out.println("All tasks are completed" );

        //ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.schedule(
//                ()-> System.out.println("Task executed after 5 seconds"),
//                5,
//                TimeUnit.SECONDS
//        );
        scheduler.scheduleAtFixedRate(()->
                System.out.println("Task executed after every 5 seconds" ),
                5,5, TimeUnit.SECONDS
        );

        scheduler.scheduleWithFixedDelay(()->
                        System.out.println("Task executed after every 5 seconds" ),
                5,5, TimeUnit.SECONDS
                );

        scheduler.schedule(()->{
                    System.out.println("Initiating shutdown...");
                    scheduler.shutdown();

                },20, TimeUnit.SECONDS
                );
 }

}
