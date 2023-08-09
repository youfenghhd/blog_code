package com.youfeng.blog.jwt.config;

import com.youfeng.blog.jwt.handler.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author -侑枫
 * @date 2023/7/31 13:58:43
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 拦截所有请求，通过判断是否有注解 决定是否需要登录
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 自己写的拦截器
     *
     * @return 拦截器
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
