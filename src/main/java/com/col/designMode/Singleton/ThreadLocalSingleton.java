package com.col.designMode.Singleton;

/**
 * ThreadLocal实现单例模式
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> tlSingleton =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };
    /**
     * Get the focus finder for this thread.
     */
    public static ThreadLocalSingleton getInstance() {
        return tlSingleton.get();
    }
    // enforce thread local access
    private ThreadLocalSingleton() {}
}
