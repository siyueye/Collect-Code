package com.col.ThreadTest;

public class YieldTest extends Thread {

    

    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println("YieldTest-run-begin");
        System.out.println("YieldTest-1");
        YieldAndSleep.calculate();
        yield();
        System.out.println("YieldTest-2");
        YieldAndSleep.calculate();
        System.out.println("YieldTest-run-end");
    }
}
