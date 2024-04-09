package com.atlogin.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        String email="12345@qq.com";
        String password="12345";
        String userName = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/demo? useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(url, "root", "yufei5312");
        Statement statement = conn.createStatement();
        String sql = String.format(
                "SELECT name FROM demo01 WHERE email = '%s' and password = '%s'",
                email,
                password
        );
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            userName = (String) rs.getObject(1);
        }
        System.out.println(userName);
        rs.close(); // 如果使用了ResultSet，则需关闭
        statement.close();
        conn.close();
    }
}
