package com.youfeng.blog.jwt.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author -侑枫
 * @date 2023/7/31 13:16:21
 * 需要登录才可以操作的注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmToken {
    boolean required() default true;
}
