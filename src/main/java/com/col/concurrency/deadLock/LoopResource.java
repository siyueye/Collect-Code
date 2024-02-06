package com.col.concurrency.deadLock;

public class LoopResource {
    //创建资源
    private static Object resourceA = new Object () ;
    private static Object resourceB =new Object() ;

    public static void main(String[] args) {
        //创建线程
        Thread threadA =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get ResourceA") ;
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace() ;
                    }
                    System.out .println (Thread.currentThread() +"waiting get resourceB" ) ;
                    synchronized (resourceB){
                        System.out.println (Thread. currentThread ()+"get resourceB" );
                    }

                }
            }
        });
        //创建线程
        Thread threadB =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread() + "get ResourceB") ;
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace() ;
                    }
                    System.out .println (Thread.currentThread() +"waiting get resourceA" ) ;
                    synchronized (resourceA){
                        System.out.println (Thread. currentThread ()+"get resourceA" );
                    }

                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start() ;
    }
}