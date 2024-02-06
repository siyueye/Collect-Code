package com.col.ThreadTest;

public class YieldAndSleep {
    public static void calculate() {
        for (int i = 0;i<100000000;i++) {
            int j = i*i;
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            System.out.println("YieldTest().start()-begin");
            new YieldTest().start();
            System.out.println("YieldTest().start()-end");
        }

        for (int i = 1; i <= 2; i++) {
            System.out.println("SleepTest().start()-begin");
//            new SleepTest().start();
            System.out.println("SleepTest().start()-end");
        }
    }
}
