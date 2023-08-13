package com.youfeng.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author -侑枫
 * @date 2023/8/9 20:19:36
 */
public class JdbcSimulationLoginUnsafe {
    public static void main(String[] args) throws Exception {
        // 建立数据库连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql:///testdb?characterEncoding=utf8&useSSL=false",
                "root", "000000");

        Scanner scan = new Scanner(System.in);
        // 接收输入的用户名密码
        String name = scan.nextLine();
        String pw = scan.nextLine();

        String sql = "select * from userpw where username = '" + name + "'" +
                "and password ='" + pw + "' ";

        // 创建数据库查询的Statement对象
        Statement stmt = conn.createStatement();

        // 执行SQL查询
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs.next() ? "登陆成功" : "登陆失败");

        // 释放资源：关闭数据库结果集、Statement和连接
        rs.close();
        stmt.close();
        conn.close();
    }
}
