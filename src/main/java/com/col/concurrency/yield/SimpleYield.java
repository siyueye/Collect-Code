package com.col.concurrency.yield;

public class SimpleYield  implements Runnable {
    SimpleYield(){
        //创建并启动线程
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            //当 i=O时让出CPU执行权，放弃时间片，进行下一轮调度
            System.out.println (Thread.currentThread() + " yield cpu ...") ;
            //当前线程让出CPU执行权，放弃时间片，进行下一轮调度
//            Thread.yield () ;
        }
        System.out.println(Thread.currentThread() + " is over " );
    }

    public static void main(String[] args) {
        new SimpleYield();
        new SimpleYield();
        new SimpleYield();
    }
}

