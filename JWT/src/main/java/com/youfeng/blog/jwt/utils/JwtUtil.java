package com.youfeng.blog.jwt.utils;

import com.youfeng.blog.jwt.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author -侑枫
 * @date 2023/7/31 13:33:27
 */
public class JwtUtil {
    /**
     * JWT过期时间1小时
     */
    private static final Date DATE = new Date(System.currentTimeMillis()+ 3600*1000);

    public static String getJwt(User user) {
        Map<String,Object> claims = new HashMap<>(8);
        // 自定义荷载
        claims.put("userId",user.getUserId());
        claims.put("userName",user.getUserName());
        return Jwts.builder()
                .setClaims(claims)
                // 利用用户密码作为密钥生成签名算法
                .signWith(SignatureAlgorithm.HS256, user.getPassword())
                // 设置JWT过期时间
                .setExpiration(DATE)
                .compact();
    }
}
