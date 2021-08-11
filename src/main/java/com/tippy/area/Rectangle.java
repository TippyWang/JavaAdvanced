package com.tippy.area;

public class Rectangle implements Shape{

    float width;
    float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return (width*height/2);
    }
}
