package com.youfeng.blog;

/**
 * 枚举类饿汉单例(线程安全且防止反序列化)
 *
 * @author -侑枫
 * @date 2023/8/23 20:59:37
 */
public enum EnumSingleInstance {
    // 实例
    INSTANCE;
}
