package com.col.concurrency.threadlocal;

public class ThreadLocalSimple {
    //(1)print函数
    static void print(String str) {
        //1.1 打印当前线程本地内存中localVariable变莹的位
        System.out.println(str + ":"+localVariable.get());
        //1.2 清除当前线程本地内存中的localVariable变量
        localVariable. remove() ;
    }
    //(2)创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<> () ;
    public static void main(String[] args) {
        //创建线程
        Thread threadOne =new Thread(new Runnable() {
            @Override
            public void run() {
                //3.1 设置线程One中本地交itlocal Variable的位
                localVariable.set ("threadOne local variable");
                //3.2 调用打印函数
                print ("threadOne" ) ;
                //3.3 打印本地变量值
                System.out.println ("threadOne remove after" + " :" +localVariable.get()) ;
            }
        });
        //创建线程
        Thread threadTwo =new Thread(new Runnable() {
            @Override
            public void run() {
                //4.1 设置线程One中本地交itlocal Variable的位
                localVariable.set ("threadTwo local variable");
                //4.2 调用打印函数
                print ("threadTwo" ) ;
                //4.3 打印本地变量值
                System.out.println ("threadTwo remove after" + " :" +localVariable.get()) ;
            }
        });
        // ( 5 ）启动线程
        threadOne.start() ;
        threadTwo.start() ;

    }
}
