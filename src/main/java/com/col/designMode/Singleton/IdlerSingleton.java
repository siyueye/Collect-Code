package com.col.designMode.Singleton;
/**
 * 单例模式--懒汉模式
 */
public class IdlerSingleton {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static IdlerSingleton instance = null;
    /* 私有构造方法，防止被实例化 */
    private IdlerSingleton(){

    }
    /* 1:懒汉式，静态工程方法，创建实例 */
    public static synchronized IdlerSingleton getInstance(){
        if(instance==null){
           instance= new IdlerSingleton();
        }
        return instance;
    }
}
