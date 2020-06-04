package com.lawener.study;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

    @Test
    public void QueryTest(){
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT * from users";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            System.out.print("username"+" ");
            System.out.println("password"+"");

            while(resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.print(username+"  ");
                System.out.println(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(resultSet,statement,connection);
    }


    @Test
    public void test_Druid() throws SQLException {
        Connection connection = JDBCUtils_Druid.getConnection();
        String sql = "INSERT INTO USERS(username,password) value ('hello2','123456')";
        PreparedStatement statement = connection.prepareStatement(sql);
        boolean execute = statement.execute();
        System.out.println(execute);


    }

}
