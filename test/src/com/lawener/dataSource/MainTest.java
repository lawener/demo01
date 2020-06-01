package com.lawener.dataSource;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MainTest {

    @Test
    public void testDruid() throws SQLException {
        DataSource dataSource = DruidUtils.getDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);



    }

}
