package com.lambda;

interface Student{
    public String getBio(String name);
}
public class LambdaExpression {

    public static void main(String[] args) {
//        Student student = new Student(){
//            @Override
//            public String getBio(String name) {
//                return "My name is "+name;
//            }
//        };
        Student student = (name) -> "My name is "+name;

        System.out.println(student.getBio("Mehedi Hasan"));

        Thread thread = new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread: "+Thread.currentThread().getName());
            }
        });
        Thread thread1 = new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread: "+Thread.currentThread().getName());
            }
        });
        thread.start();
        thread1.start();

    }

}
