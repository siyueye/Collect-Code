package com.col.concurrency.interrupted;

public class SimpleInterruped {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread()+"Hello");
                }
//                while(true){
//                    System.out.println(Thread.currentThread()+"Hello");
//                }
            }
        });
        //启动子线程
        thread.start() ;
        //主线程休眠ls，以使中断前让子线寻呈输出
//        Thread.sleep(1000) ;
        //中断子线程
        System.out.println ("main thread interrupt thread") ;
        thread.interrupt() ;
        System.out.println ("thread:"+thread.isInterrupted()) ;
        //等待子线程执行完毕
        thread.join() ;
        System.out.println( "main is over");
    }

}