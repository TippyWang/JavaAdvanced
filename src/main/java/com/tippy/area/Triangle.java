package com.tippy.area;

public class Triangle implements Shape{

    float width;
    float height;

    public Triangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return (width*height/2);
    }
}
