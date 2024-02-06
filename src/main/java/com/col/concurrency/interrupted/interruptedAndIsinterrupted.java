package com.col.concurrency.interrupted;

/**
 * 在interrupted（）方法内部是获取当前线程的中断状态，这里虽然
 * 调用了 threadOne 的 interrupted（） 方法，但是获取的是主线程的中断标志，因为主线程是当前线程。
 * threadOne.interrupted（）和 Thread.interrupted（）方法的作用是一样的，目的都是获取当前线程的中断标志。
 */
public class interruptedAndIsinterrupted {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne =new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){

                }
            }
        });
        //启动线程
        threadOne.start() ;
        //设置中断标志
        threadOne.interrupt () ;
        //获取中断标志
        System.out.println ("Isinterrupted :" + threadOne.isInterrupted()) ;
        //获取中断标志并重置
        System.out.println ("is Interrupted:" + threadOne.interrupted()) ;
        //获取中断标志并重置
        System.out.println("is Interrupted:" + Thread.interrupted() ) ;
        //获取中断标志
        System.out.println ("isinterrupted： "+ threadOne.isInterrupted () ) ;
        threadOne.join () ;
        System.out.println("main thread is over");
    }
}
