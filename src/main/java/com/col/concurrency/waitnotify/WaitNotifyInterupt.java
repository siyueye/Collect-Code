package com.col.concurrency.waitnotify;

public class WaitNotifyInterupt {
    static Object obj= new Object();
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run () {
                try {
                    System.out.println("－－－begin--");
                    //阻塞当前线斗呈
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("---end---");
                } catch (InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start() ;
        Thread.sleep(1000) ;
        System.out.println ("－一－begin interrupt threadA一－－");
        threadA.interrupt ();
        System.out.println("---end interrupt threadA---");
                    }
}
