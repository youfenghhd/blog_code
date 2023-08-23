package com.youfeng.blog;

/**
 * 普通饿汉式单例模式
 *
 * @author -侑枫
 * @date 2023/8/23 20:31:44
 */
public class HungryStyleSingleInstance {
    /**
     * 类加载时即实例化对象
     */
    private static final HungryStyleSingleInstance HUNGRY_STYLE_SINGLE_INSTANCE = new HungryStyleSingleInstance();

    /**
     * 私有化构造器，防止外部 new 对象
     */
    private HungryStyleSingleInstance() {
    }

    /**
     * 使用静态方法获取对象实例
     *
     * @return 单例类对象
     */
    public static HungryStyleSingleInstance getInstance() {
        return HUNGRY_STYLE_SINGLE_INSTANCE;
    }
}
