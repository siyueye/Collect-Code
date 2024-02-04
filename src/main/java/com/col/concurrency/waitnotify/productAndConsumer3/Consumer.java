package com.col.concurrency.waitnotify.productAndConsumer3;

public class Consumer extends Thread {
    private MyStack theStack;

    public Consumer (MyStack s, String name) {
        super(name);
        theStack = s;
        start();  //启动自身消费者线程
    }

    public void run() {
        String goods;
        for (int i=0; i < 200; i++) {
            goods = theStack.pop();
            System.out.println(getName() +"第"+i+"次"+": pop " + goods +" from "+theStack.getName());
            yield();
        }
    }
}