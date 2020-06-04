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
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("username"+":"+username);
                System.out.println("password"+":"+password);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
