package com.youfeng.blog;

/**
 * 普通懒汉单例(线程不安全)
 *
 * @author -侑枫
 * @date 2023/8/23 20:37:44
 */
public class LazyStyleSingleInstance {

    private static LazyStyleSingleInstance instance;

    /**
     * 私有化构造器，防止外部 new 对象
     */
    private LazyStyleSingleInstance() {
    }

    /**
     * 使用静态方法获取对象实例
     *
     * @return 单例类对象
     */
    public static LazyStyleSingleInstance getInstance() {
        if (instance == null) {
            instance = new LazyStyleSingleInstance();
        }
        return instance;
    }
}
