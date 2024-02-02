package com.col.concurrency.create.threadMethods;
//Java 中有三种线程创建方式，1.继承Thread类并重写run的方法，2.实现Runnable接口的 run方法，3.使用 FutureTask 方式创建线程
//1.继承Thread类并重写run的方法
//优缺点：
// 优点：使用继承方式的好处是， 在run（）方法内获取当前线程直接使用 this就可以了，无须使用 Thread.currentThread（） 方法；
// 缺点： Java 不支持多继承，如果继承了 Thread 类，那么就不能再继承其他类。
// 缺点： 另外任务与代码没有分离,当多个线程执行一样的任务时需要多份任务代码，而Runable 则没有这个限制。
// 缺点： 没有返回值
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println (" I am a child thread,线程id："+this.getId()+"线程名字："+this.getName()) ;
        System.out.println (" I am a child thread,线程id："+Thread.currentThread().getId()+"线程名字："+Thread.currentThread().getName()) ;
//        System.out.println (System.getProperty("java.home")+","+System.getProperty("sun.arch.data.model")+","+System.getProperty("os.name"));
        System.out.println (System.getProperty("java.version")+","+System.getProperty("java.vendor")+","+System.getProperty("java.vendor.url"));
    }

    public static void main(String[] args) {
        //创建线程
        MyThread thread= new MyThread();
        // 启动线程
        thread.start();
    }
}
