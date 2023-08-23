package com.youfeng.blog;

/**
 * 静态内部类懒汉单例(线程安全)
 *
 * @author -侑枫
 * @date 2023/8/23 20:52:19
 */
public class StaticInternalLazyStyleSingleInstance {
    /**
     * 静态内部类实例化对象
     */
    private static class Singleton {
        /**
         * 类加载时进行实例化对象
         */
        private static final StaticInternalLazyStyleSingleInstance STATIC_INTERNAL_LAZY_STYLE_SINGLE_INSTANCE =
                new StaticInternalLazyStyleSingleInstance();
    }

    /**
     * 私有构造，防止外部new对象
     */
    private StaticInternalLazyStyleSingleInstance() {
    }

    /**
     * 通过静态方法获取对象实例
     *
     * @return
     */
    public static StaticInternalLazyStyleSingleInstance getInstance() {
        return Singleton.STATIC_INTERNAL_LAZY_STYLE_SINGLE_INSTANCE;
    }
}
