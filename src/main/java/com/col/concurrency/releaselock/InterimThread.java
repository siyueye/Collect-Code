package com.col.concurrency.releaselock;

public class InterimThread extends Thread {
    private int a=1;
    public synchronized void print(){
        System.out.println("a="+a);
    }
    public void run() {
        synchronized(this){
            System.out.println("线程拿到锁"+this.getName());
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            a=1/0;  //抛出ArithmeticException
            a++;
        }
    }
    public static void main(String args[]){
        InterimThread interimThread =new InterimThread();
        interimThread.start();
        Thread.yield();
        interimThread.print();
    }
}