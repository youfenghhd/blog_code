package com.youfeng.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author -侑枫
 * @date 2023/8/9 20:33:29
 */
public class JdbcSimulationLoginSafe {
    public static void main(String[] args) throws Exception {
        // 建立数据库连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql:///testdb?characterEncoding=utf8&useSSL=false&useServerPrepStmts=true",
                "root", "000000");

        Scanner scan = new Scanner(System.in);
        //  接收输入的用户名密码
        String name = scan.nextLine();
        String pw = scan.nextLine();

        // 定义SQL查询语句，使用参数占位符 '?' 来保护查询
        String sql = "select * from userpw where username = ? and password = ?";

        // 创建预编译的PreparedStatement对象，该对象可以防止SQL注入攻击
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置'?'的值(即设置第几个'?'为何值）
        pstmt.setString(1, name);
        pstmt.setString(2, pw);

        // 执行预编译的查询
        ResultSet rs = pstmt.executeQuery();

        System.out.println(rs.next() ? "登陆成功" : "登陆失败");

        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}
