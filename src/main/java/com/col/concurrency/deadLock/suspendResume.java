package com.col.concurrency.deadLock;

public class suspendResume extends Thread{
    private int a;  //共享数据

    public void run(){
        for(int i=0;i<1000;i++){
            synchronized(this){
                a+=i;
                yield();  //给其他线程运行的机会
                a-=i;
            }
        }
    }

    public synchronized void reset(){ a=0;}

    public static void main(String args[]) throws InterruptedException{
        suspendResume susRm=new suspendResume();
        susRm.start();
        yield();  //给susRm线程运行的机会
        susRm.suspend();  //让susRm线程暂停
        susRm.reset();  //调用susRm对象的同步代码块
        susRm.resume();  //使susRm线程恢复运行
    }
}