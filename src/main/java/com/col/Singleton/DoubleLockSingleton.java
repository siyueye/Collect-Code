package com.col.Singleton;

/**
 * 双重同步锁
 */
public class DoubleLockSingleton {
    /**
     * **volatile**关键字说明：禁止重排序的功能
     */
    private static volatile DoubleLockSingleton instanceLazySynchronized = null;

    private DoubleLockSingleton() {
    }

    //运行时加载对象
    //静态的工厂方法
    public static DoubleLockSingleton getInstance() {
        if (instanceLazySynchronized == null) {
            synchronized(DoubleLockSingleton.class){
                if(instanceLazySynchronized == null){
                    instanceLazySynchronized = new DoubleLockSingleton();
                }
            }
        }
        return instanceLazySynchronized;
    }
}
