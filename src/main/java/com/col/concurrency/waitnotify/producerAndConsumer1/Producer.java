package com.col.concurrency.waitnotify.producerAndConsumer1;

public class Producer implements Runnable{
    int n1 = 2;//每次生产2瓶
    int n2 = 3;//假设只供应3次
    public int getCount(){
        return n1 * n2;//返回共生产多少
    }
    private Box b;

    public Producer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        //供应3次牛奶
        for(int i=1; i<=n2; i++) {
            b.put(n1);
        }
    }
}
