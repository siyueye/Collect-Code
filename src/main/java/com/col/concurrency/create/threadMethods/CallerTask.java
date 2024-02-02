package com.col.concurrency.create.threadMethods;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//Java 中有三种线程创建方式，1.继承Thread类并重写run的方法，2.实现Runnable接口的 run方法，3.使用 FutureTask 方式创建线程
//3.使用 FutureTask 方式创建线程
//优缺点：
// 优点：有返回值
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) {
        // 创建异步任务
        FutureTask<String> futureTask=new FutureTask<>(new CallerTask()) ;
        //启动线程
        new Thread(futureTask).start() ;
        try { 
        //等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
    }
}
