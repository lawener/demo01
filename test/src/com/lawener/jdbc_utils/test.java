package com.lawener.jdbc_utils;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

public class test {
    Connection connection;
    Statement statement;
    @Before
    public void initial(){
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        String insert_user = "insert into users (username,password) values('lawener','123456')";
        try {
            statement.executeUpdate(insert_user);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection);
        }

    }

    @Test
    public void testQueryAll(){
        String query_all_user = "select * from users";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query_all_user);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(id+" | "+username+" | "+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String scan_username = scanner.next();
        System.out.println("请输入登陆密码：");
        String scan_password = scanner.next();

        String sql = "select * from users where username=? && password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,scan_username);
            preparedStatement.setString(2,scan_password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println("登陆成功！");

            }else{
                System.out.println("登陆失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegister(){
        System.out.println("注册用户：");
        System.out.println("请输入用户名：");
        Scanner scan = new Scanner(System.in);
        String scan_username = scan.next();
        System.out.println("请输入密码：");
        String scan_password= scan.next();

        String sql = "insert into users (username,password) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,scan_username);
            preparedStatement.setString(2,scan_password);
            int i = preparedStatement.executeUpdate();
            if (i ==1){
                System.out.println("注册成功！");
            }else{
                System.out.println("注册失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
