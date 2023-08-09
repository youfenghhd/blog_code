package com.youfeng.blog.jwt.handler;

import com.sun.istack.internal.NotNull;
import com.youfeng.blog.jwt.utils.ConfirmToken;
import com.youfeng.blog.jwt.utils.PassToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author -侑枫
 * @date 2023/7/31 13:47:52
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final String OPTIONS = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse httpServletResponse, @NotNull Object object) {
        //浏览器在发送正式的请求时会先发送options类型的请求试探
        //放行该请求
        if (OPTIONS.equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        //设置允许跨域访问
        //jwt要设置跨域，不然拿不到请求头里的token
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Authorization,"
                + " Content-Type, Accept, Connection, User-Agent, Cookie,token");
        // 从 http 请求头中取出 token
        String token = request.getHeader("Authorization");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(ConfirmToken.class)) {
            ConfirmToken confirmToken = method.getAnnotation(ConfirmToken.class);
            if (confirmToken.required()) {
                // 执行认证
                if (token == null) {
                    return false;
                }
                // 根据业务需求获取用户实体类，此操作略

                // 获取 token 中的 user id 和 userName 验证
                Claims body = Jwts.parser()
                        // 加密密钥
                        .setSigningKey(user.getPassword())
                        // 要解密的JWT
                        .parseClaimsJws(token)
                        // 获取荷载内容
                        .getBody();

                if (body.get("userId") != user.getUserId() || body.get("userName") != user.getUserName()) {
                    return false;
                }
                System.out.println("JWT验证码完毕");
            }
        }
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
