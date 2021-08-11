package com.tippy;

public class OrderItem extends Product{

    int quantity = 1;


    public OrderItem(Product product, int quantity) {
        this(product);
        this.quantity = quantity;
    }

    public OrderItem(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
    }
}
