package com.tippy.db;


import com.tippy.box.Box;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

// create box
// create table - box
// create 2-3 id, name, length, width, height, price
public class BoxExam {
    public static void main(String[] args) {
        // connect to db(localhost)
        // enter your object length
        // enter your object width
        // enter your object height
        // box name, price or no box for you
        ArrayList<Box> boxes = new ArrayList<>();

//        TODO: 連線資料庫
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop"
                    , "tippy", "123");
            Statement statement = connection.createStatement();
            ResultSet boxResult = statement.executeQuery("select * from box");
            while (boxResult.next()){
                Box box = new Box(boxResult);
                boxes.add(box);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        TODO: 輸入長寬高
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Box> canBuyBoxes = new HashMap<>();
        while (true){
            try {
                int num = 1;
                System.out.print("請輸入長度:");
                int length = scanner.nextInt();
                System.out.print("請輸入寬度:");
                int width = scanner.nextInt();
                System.out.print("請輸入高度:");
                int height = scanner.nextInt();
//                回傳可使用的箱子
                for (Box box : boxes) {
                    if (box.validate(length ,width ,height)){
                        canBuyBoxes.put(num ,box);
                        num++;
                    }
                }
                break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("請輸入數字!!!!!");
                scanner.next();
            }
        }
        //  TODO: 選擇欲購買的箱子
        if (!canBuyBoxes.isEmpty()){
            System.out.println("以下是符合規格之箱子");
            for (Integer integer : canBuyBoxes.keySet()) {
                System.out.println(integer+")\t"+canBuyBoxes.get(integer));
            }
            System.out.print("請輸入欲購買箱子之編號:");
            String obj = scanner.next();
            while (true){
                try {
                    if (canBuyBoxes.keySet().contains(Integer.parseInt(obj))){
                        System.out.println(canBuyBoxes.get(Integer.parseInt(obj)).buyString());
                        break;
                    }else {
                        System.out.print("無效編號,請重新選擇:");
                        obj = scanner.next();
                    }
                }catch (NumberFormatException e){
                    System.out.print("無效編號,請重新選擇:");
                    obj = scanner.next();
                }
            }
        }else {
            System.out.println("尚無您可使用的盒子");
        }
    }
}
