package com.col.concurrency.waitnotify.productAndConsumer3;

public class MyStack {
    private String name;
    private final int SIZE=100;   //堆栈中最多放200个物品
    private String[] buffer=new String[SIZE];  //存放物品的数组
    int point=-1;   //指向堆栈的指针

    public MyStack(String name){this.name=name;}
    public String getName(){return name;}

    public synchronized int getPoint(){return point;}

    public synchronized String pop() {   // 取出一个物品
        this.notifyAll();

        while(point==-1){
            System.out.println(Thread.currentThread().getName()+": wait，"+"point+"+point+"buffer.length ="+buffer.length+",Status:"+Thread.currentThread().getState());
            try{
                this.wait();
            }catch(InterruptedException e){throw new RuntimeException(e);}
        }

        String goods = buffer[point];   //取出point指针所指的物品
        buffer[point]=null;
        Thread.yield();
        point--;
        return goods;
    }

    public synchronized boolean push(String goods) {    //加入一个物品
        this.notifyAll();

        while(point==buffer.length-1){
            System.out.println(Thread.currentThread().getName()+": wait，"+"point="+point+"buffer.length ="+buffer.length+",Status:"+Thread.currentThread().getState());
            try{
                this.wait();
            }catch(InterruptedException e){throw new RuntimeException(e);}
        }

        point++;   //point指针递增
        Thread.yield();
        buffer[point]=goods;    //向point指针所在位置加入物品
        return true;
    }
}
