package com.col.concurrency.waitnotify.productAndConsumer3;


public class Producer extends Thread {
    private MyStack theStack;

    public Producer (MyStack s, String name) {
        super(name);
        theStack = s;
        start();  //启动自身生产者线程
    }

    public void run() {
        String goods;
        for (int i = 0; i < 200; i++) {
            synchronized(theStack){
                goods="goods"+(theStack.getPoint()+1);
                if(theStack.push(goods))
                    System.out.println(getName()+ "第"+i+"次"+": push " + goods +" to "+theStack.getName());
            }
            yield();
        }
    }
}