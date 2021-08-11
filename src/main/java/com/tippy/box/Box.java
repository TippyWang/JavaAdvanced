package com.tippy.box;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box {
//    int length;
//     int width;
//     int height;

    int firstLongest;
    int secondLongest;
    int thirdLongest;
    String name;
    int price;
    public Box(int length, int width, int height) {
        List<Integer> sort = sort(length, width, height);
        this.firstLongest = sort.get(0);
        this.secondLongest = sort.get(1);
        this.thirdLongest = sort.get(2);
//        this.length = length;
//        this.width = width;
//        this.height = height;
     }

    public Box(ResultSet boxResult) {
        try {
            //  大到小排序
            List<Integer> sort = sort(boxResult.getInt("length"),
                    boxResult.getInt("width"), boxResult.getInt("height"));
            this.firstLongest = sort.get(0);
            this.secondLongest = sort.get(1);
            this.thirdLongest = sort.get(2);
            this.name = boxResult.getString("name");
            this.price = boxResult.getInt("price");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean validate(int length, int width, int height){
        List<Integer> customerSort = sort(length, width, height);
//        return length <= this.length && width <= this.width && height <= this.height;
        return customerSort.get(0) <= this.firstLongest &&
                customerSort.get(1) <= this.secondLongest &&
                customerSort.get(2) <= this.thirdLongest;
    }


    List<Integer> sort(int length, int width, int height){
        //大到小排序
        List<Integer> lengthList = new ArrayList<>(List.of(length, width, height));
        lengthList.sort(Collections.reverseOrder());
        return lengthList;
    }

    @Override
    public String toString() {
        return name +"\t"+ this.firstLongest +"x"+ this.secondLongest +"x"+this.thirdLongest+
                "\t符合您的需求\t價格:"+ price +"元";
    }

    public String buyString(){
        return "感協您購買 [ " + name +" ] 商品價格為\t" + price+"元";
    }
}
