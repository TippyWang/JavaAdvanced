package com.tippy;

import java.util.List;

public class Tester {

    public static void main(String[] args) {
        List<Category> categories = Category.getDummyCategories();
        for (Category category : categories) {
            System.out.println(category.name);
        }
        for (Product product : Product.getProduct()) {
//          查看真實型態
            if(product instanceof SalesProduct){
                System.out.print("*");
            }
            System.out.println(product);
        }
//        Product product1 = new Product("衛生紙", 30 ,Category.CATEGORY_DAILY) ;
//        Product product2 = new Product("雞胸肉" ,50 ,Category.CATEGORY_FOOD);
//        TODO: 購物車可先不填數量 是不是還需要地方存 orderItem ?!
//        OrderItem orderItem1 = new OrderItem( product1 ,2);
//        OrderItem orderItem2 = new OrderItem( product2 );
    }
}
