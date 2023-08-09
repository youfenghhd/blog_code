package com.youfeng.blog.jwt;

import com.youfeng.blog.jwt.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import static com.youfeng.blog.jwt.utils.JwtUtil.getJwt;

/**
 * @author -侑枫
 * @date 2023/7/31 13:47:05
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setUserId("00101");
        String jwt = getJwt(user);
        System.out.println(jwt);
        Claims body = Jwts.parser()
                // 加密密钥
                .setSigningKey(user.getPassword())
                // 要解密的JWT
                .parseClaimsJws(jwt)
                // 获取荷载内容
                .getBody();
        System.out.println(body);
    }
}
