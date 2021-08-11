package com.tippy.db;

import java.sql.*;

public class ShopTester {
    public static void main(String[] args) {
        try {
            // 1. JDBC Driver
            // The legacy way of loading a JDBC driver also still works for MariaDB Connector/J. e.g.
            Class.forName("org.mariadb.jdbc.Driver");
            // 2. connect database, url string
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop"
            ,"tippy","123");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from category");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                System.out.println(id);
                String name = resultSet.getString("name");
                System.out.println(name);
                int version = resultSet.getInt("version");
                System.out.println(version);
            }
            resultSet.close();
            stmt.cancel();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
