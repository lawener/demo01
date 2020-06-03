package com.lawener.dataSource;



import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class c3p0_utils {

    static String user ;
    static String password ;
    static String url ;
    static String driver ;

    static {

        ClassLoader classLoader = c3p0_utils.class.getClassLoader();
        InputStream local_prop = classLoader.getResourceAsStream("c3p0.properties");
        Properties prop = new Properties();
        try {
            prop.load(local_prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user= prop.getProperty("user");
        /*System.out.println(user);*/
        url = prop.getProperty("url");
        password = prop.getProperty("Driver");
        /* System.out.println(password);*/
    }



    public static Connection getConnection(){

        return null;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){

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
