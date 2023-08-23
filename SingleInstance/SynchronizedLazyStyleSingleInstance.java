package com.youfeng.blog;
/**
 * 同步锁懒汉单例(线程安全)
 *
 * @author -侑枫
 * @date 2023/8/23 20:43:58
 */
public class SynchronizedLazyStyleSingleInstance {
    private static SynchronizedLazyStyleSingleInstance instance;

    /**
     * 私有化构造器，防止外部 new 对象
     */
    private SynchronizedLazyStyleSingleInstance() {
    }

    /**
     * 使用静态方法获取对象实例
     *
     * @return 单例类对象
     */
    public static synchronized SynchronizedLazyStyleSingleInstance getInstance() {
        if (instance == null) {
            instance = new SynchronizedLazyStyleSingleInstance();
        }

        return instance;
    }
}
