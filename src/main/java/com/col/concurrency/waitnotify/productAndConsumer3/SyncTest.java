package com.col.concurrency.waitnotify.productAndConsumer3;

public class SyncTest {
    public static void main(String args[]) {
        MyStack stack1 = new MyStack("stack1");
        Producer producer1 = new Producer(stack1,"producer1");
        Consumer consumer1 = new Consumer(stack1,"consumer1");
        Consumer consumer2 = new Consumer(stack1,"consumer2");

        MyStack stack2 = new MyStack("stack2");
        Producer producer2 = new Producer(stack2,"producer2");
        Producer producer3 = new Producer(stack2,"producer3");
        Consumer consumer3= new Consumer(stack2,"consumer3");
    }
}
