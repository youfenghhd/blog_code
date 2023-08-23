package com.youfeng.blog;

/**
 * 双检锁饿汉式单例模式
 *
 * @author -侑枫
 * @date 2023/8/23 20:48:36
 */
public class DoubleCheckLockLazyStyleSingleInstance {
    /**
     * volatile是为了防止指令重排序
     */
    private static volatile DoubleCheckLockLazyStyleSingleInstance instance;

    /**
     * 私有化构造器，防止外部 new 对象
     */
    private DoubleCheckLockLazyStyleSingleInstance() {
    }

    /**
     * 使用静态方法获取对象实例
     *
     * @return 单例类对象
     */
    public static DoubleCheckLockLazyStyleSingleInstance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockLazyStyleSingleInstance.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockLazyStyleSingleInstance();
                }
            }
        }
        return instance;
    }
}
