package com.col.concurrency.waitnotify;

public class SimpleWaitNotify extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(()->{
            //细节1：wait方法与notify方法必须要由同一个锁对象调用。
            //因为：对应的锁对象可以通过notify唤醒使用同一个锁对象调用的wait方法后的线程。
            synchronized (lock) {
                try{
                    System.out.println("wait 之前->");
                    //细节2：wait方法与notify方法是属于Object类的方法的。
                    //因为：锁对象可以是任意对象，而任意对象的所属类都是继承了Object类的。
                    lock.wait();
                    System.out.println("wait 之后->");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(500);
        //细节3：wait方法与notify方法必须要在`同步代码块`或者是`同步函数`中使用。
        //因为：必须要`通过锁对象`调用这2个方法。否则会报java.lang.IllegalMonitorStateException异常.
        synchronized (lock){
            System.out.println("notify 操作后->");
            lock.notify();
        }
    }
}