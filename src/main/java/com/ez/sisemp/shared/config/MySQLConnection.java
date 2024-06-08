package com.ez.sisemp.shared.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnection {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/sisemp";
    private static final String USER= "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private MySQLConnection() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }
        return connection;
    }

    public static ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
        return MySQLConnection.getConnection().createStatement().executeQuery(sql);
    }

    public static void closeConnection() throws SQLException {
        if(connection != null){
            connection.close();
        }
    }
}
