package com.col.concurrency.join;

public class SimpleJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne Over!");
            }
        });
        Thread threadTwo =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo Over!");
            }
        });
        threadOne.start();
        threadTwo.start();
        System.out.println("wait Allchild thread Over!");
        threadOne.join();
        threadTwo.join();
        System.out.println("all child thread Over!");
    }
}
