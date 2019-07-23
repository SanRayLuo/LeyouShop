package com.item;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author SanRay
 * @date 2019-07-10 14:54
 */
public class testQuery {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yun6?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","123456");
            if(connection == null){
                System.out.println("空的连接");
            }
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
