package com.col.concurrency.waitnotify.producerAndConsumer1;

public class Box extends Thread{
    //定义一个成员变量，表示第x瓶奶
    private int milk;

    //提供存储牛奶和获取牛奶的操作
    public synchronized void put(int milk) {
        //如果有牛奶，等待消费
        while(this.milk!=0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶，就生产牛奶
        this.milk = milk;

        System.out.println("生产了" + this.milk + "瓶奶放入奶箱");

        //唤醒其他等待的线程
        this.notifyAll();
    }

    public synchronized void get() {
        //如果没有牛奶，等待生产
        while(this.milk == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果有牛奶，就消费牛奶
        System.out.println("用户拿到第" + this.milk + "瓶奶");

        //每次消费一瓶
        this.milk--;
        //唤醒其他等待的线程
        this.notifyAll();
    }
}
