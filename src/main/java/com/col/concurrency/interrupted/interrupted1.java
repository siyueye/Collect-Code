package com.col.concurrency.interrupted;

public class interrupted1 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadOne =new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志为true时会退出循环，并且清除中断标志
                while (!Thread.currentThread().interrupted ()) {
                }
                System.out.println ("threadOne isinterrupted: " + Thread.currentThread().isInterrupted()) ;
            }
        });
        // 后动线程
        threadOne.start() ;
        // 设置中断标志
        threadOne.interrupt() ;
        threadOne.join () ;
        System.out.println ("main thread is over") ;
    }
}
