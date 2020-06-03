package com.lawener.jdbc_utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    static String user ;
    static String password ;

    static {

        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        InputStream local_prop = classLoader.getResourceAsStream("jdbc.properties");
        Properties prop = new Properties();
        try {
            prop.load(local_prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user= prop.getProperty("user");
        /*System.out.println(user);*/
        password = prop.getProperty("password");
       /* System.out.println(password);*/
    }



    public static Connection getConnection(){

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection){

        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public static void close(Statement statement,Connection connection) {

        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
