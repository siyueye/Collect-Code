package com.col.concurrency.create.threadMethods;
//Java 中有三种线程创建方式，1.继承Thread类并重写run的方法，2.实现Runnable接口的 run方法，3.使用 FutureTask 方式创建线程
//2.实现Runnable接口的 run方法
//优缺点：
// 优点：两个线程共用一个task代码逻辑；可以继承别的类
// 缺点： 没有返回值
public class RunableTask implements Runnable{
    @Override
    public void run() {
         System.out.println (" I am a child thread,线程id："+Thread.currentThread().getId()+"线程名字："+Thread.currentThread().getName()) ;
    }

    public static void main(String[] args) {
        RunableTask task = new RunableTask();
        new Thread(task).start() ;
        new Thread(task).start() ;
    }
}
