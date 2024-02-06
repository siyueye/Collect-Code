package com.col.concurrency.interrupted;

/**
 **线程A调用线程B的join方法后会被阻塞， 当其他线程调用了线程A的interrupt（）方法中断了线程 A 时，线程 A会抛出 InterruptedException 异常而返回。
 */
public class JoinAndInterrupted {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("threadOne begin run");
                for (; ; ) {

                }
            }
        });
        //获取主线程
        final Thread mainThread = Thread.currentThread();
        Thread threadTwo = new Thread(new Runnable() {

            @Override
            public void run() {
                //休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 中断主线程  当threadTwo线程调用了线程main的interrupt（）方法中断了线程main时，线程 main会抛出 InterruptedException 异常而返回。
                mainThread.interrupt();
            }
        });
        // 启动子线程
        threadOne.start();
        //延迟ls启动线程
        threadTwo.start();
        try {//等待线程one执行结束
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }
    }
}
