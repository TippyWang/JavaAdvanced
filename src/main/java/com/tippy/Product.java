package com.tippy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Product {

    /*
    * int -> 0
    * String -> null
    * */
    int id;
    String name;
    int price;
    Category category;
    float discount = 1.0f;

    public Product() {
        super();
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, int price) {
//        呼叫上方的建構子
        this(name ,price);
        this.id = id;
//        this.name = name;
//        this.price = price;
    }

    public Product(int id ,String name, int price, Category category) {
        this(id ,name ,price);
        this.category = category;
    }
    public static List<Product> getProduct(){
        List<Product> products = new ArrayList<>();
        List<Category> dummyCategories = Category.getDummyCategories();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
            String line = bufferedReader.readLine();
            while (line != null){
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[2];
                int price = Integer.parseInt(tokens[3]);
                Category category = dummyCategories.get(Integer.parseInt(tokens[1]) - 1);
                Product product;
                if (tokens.length > 4){
//                    product.discount = Float.parseFloat(tokens[4]);
                    float discount = Float.parseFloat(tokens[4]);
                    product = new SalesProduct(id, name, price,
                            category ,discount);
                }else {
                    product =new Product(id, name, price, category);
                }
                products.add(product);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean isOnSale(){
        return discount < 1.0f;
    }

    public int getPrice(){
        return price;
    }

// @ => Annotation 標示
    @Override
    public String toString() {
        return name + "價格為\t" +  getPrice()  + "\t元";
    }
}
