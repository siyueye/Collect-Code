package com.col.Singleton;

/**
 * 饿汉模式  线程安全的
 *
 * 直接在运行这个类的时候进行一次loading，之后直接访问。显然，这种方法没有起到lazy loading的效果，
 * 考虑到前面提到的和静态类的对比，这种方法只比静态类多了一个内存常驻而已。
 */
public class HungrySingleton {
    /* 持有私有静态实例，防止被引用 */
    private static HungrySingleton instance = new HungrySingleton();
    /* 私有构造方法，防止被实例化 */
    private HungrySingleton() {
    }
    /* 静态工程方法，创建实例 */
    public static HungrySingleton getInstance() {
        return instance;
    }

}
