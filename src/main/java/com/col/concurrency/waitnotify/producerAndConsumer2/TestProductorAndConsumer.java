package com.col.concurrency.waitnotify.producerAndConsumer2;

import java.util.ArrayList;
import java.util.List;

public class TestProductorAndConsumer {
    public static void main(String[] args) {
        List<String> con = new ArrayList<>();
        Productor productor = new Productor(con);
        Consumer consumer = new Consumer(con);
        new Thread(productor).start();
        new Thread(consumer).start();
    }
}
