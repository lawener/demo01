package com.lawener.study;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static String username;
    public static String password;
    public static Connection conn;


    static{
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        InputStream iso = classLoader.getResourceAsStream("mysql_connector.properties");
        Properties pro = new Properties();
        try {
            pro.load(iso);
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = pro.getProperty("username");
        password = pro.getProperty("password");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Connection getConnection(){

        return conn;

    }

    public void close(Statement statement,Connection conn){
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close(ResultSet res,Statement statement,Connection conn){
        try {
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(statement,conn);
    }

}
