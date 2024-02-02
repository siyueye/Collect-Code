package com.col.concurrency.waitnotify.producerAndConsumer2;

import java.util.List;

public class Consumer implements Runnable {
    private final List<String> container;
    public  Consumer(List<String> container){this.container = container;}
    @Override
    public void run() {
        while (true){
            consum();
        }
    }

    private void consum() {
        try {
            synchronized (container){
                while (container.isEmpty()){
                    System.out.println("已消费完");
                    container.wait();
                }
                System.out.println("消费产品："+container.get(0));
                container.remove(0);
                Thread.sleep(2000);
                container.notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
