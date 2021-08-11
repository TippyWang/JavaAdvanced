package com.tippy;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category {
//    常數目前用來測試，基本都是撩資料庫
    static final Category CATEGORY_FOOD =  new Category(1, "Food");
    static final Category CATEGORY_DAILY =  new Category(2, "Daily");

    int id;
    String name;
    int version = 1;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


//    測試用
    static public List<Category> getDummyCategories(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Food"));
        categories.add(new Category(2 ,"Daily"));
        return categories;
    }

    static public List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();
//        TODO: 之後撈資料庫
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
        return categories;
    }

}
