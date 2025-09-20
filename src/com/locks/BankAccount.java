package com.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()+"attempting to withdraw " + amount);
        try{
            if(lock.tryLock(3000, TimeUnit.MILLISECONDS)){

                if(balance >= amount){
                    try{
                        System.out.println(Thread.currentThread().getName()+" is going to withdraw");
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()+" has withdrawn "+amount+" and remaining balance is "+balance);
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                }else{
                    System.out.println("Insufficient balance for "+Thread.currentThread().getName());
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" could not get the lock and will try later");
            }

        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
