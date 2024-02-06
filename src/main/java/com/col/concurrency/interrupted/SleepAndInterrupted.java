package com.col.concurrency.interrupted;

public class SleepAndInterrupted {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep!");
                    Thread.sleep(10000);
                    System.out.println("child thread is in awaked!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
