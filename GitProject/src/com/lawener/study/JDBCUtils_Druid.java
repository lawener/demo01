package com.lawener.study;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils_Druid {
    public static DataSource dataSource;
    static{
        ClassLoader classLoader = JDBCUtils_Druid.class.getClassLoader();
        InputStream isr = classLoader.getResourceAsStream("Druid.properties");
        Properties pro = new Properties();
        try {
            pro.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void close(Statement statement, Connection conn){
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close(ResultSet res, Statement statement, Connection conn){
        try {
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(statement,conn);
    }



}
