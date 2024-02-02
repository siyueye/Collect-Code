package com.col.concurrency.waitnotify.producerAndConsumer2;

import java.util.List;
import java.util.Random;

public class Productor implements Runnable {
    private final int CAPACITY_SIZE = 5;//容器可容纳最大数
    private final List<String> container;
    public Productor(List<String> container){this.container = container;}

    @Override
    public void run() {
        while (true){
            product();
        }
    }
    Random random = new Random();
    private void product(){
        try {
            synchronized (container){
                while (container.size() == CAPACITY_SIZE){
                    System.out.println("容器已经满了，等待消费者消费");
                    container.wait();
                }
                String productor = getRandomString(5);
                container.add(productor);
                System.out.println("生产出产品："+productor);
                Thread.sleep(1000);
                container.notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //length用户产生字符串的长度
    private static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
