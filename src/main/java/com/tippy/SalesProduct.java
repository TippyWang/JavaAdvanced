package com.tippy;

public class SalesProduct extends Product{
    float discount = 1.0f;

    public SalesProduct(int id, String name, int price, Category category, float discount) {
        super(id, name, price, category);
        this.discount = discount;
    }
    public SalesProduct() {
        this.discount = discount;
    }
    @Override
    public int getPrice() {
        return (int) (price*discount);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
