package com.col.Singleton;

/**
 * 枚举（线程安全）
 */
public class EnumSingletonDemo {
    //私有化构造函数 初始化
    private EnumSingletonDemo(){}
    //定义一个静态枚举类
    static enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private EnumSingletonDemo enumSingletonDemo;
        //私有化枚举的构造函数,初始化一个对象实例
        private SingletonEnum(){
            enumSingletonDemo=new EnumSingletonDemo();
        }
        //公开获取初始化的对象实例
        public EnumSingletonDemo getInstnce(){
            return enumSingletonDemo;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static EnumSingletonDemo getInstance(){
        return SingletonEnum.INSTANCE.getInstnce();
    }

}
